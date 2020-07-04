package Main;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lectorCSV.Csv;
import lectorJson.Paper;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.RDFWriter;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.sparql.vocabulary.FOAF;
import org.apache.jena.vocabulary.DCTerms;
import org.apache.jena.vocabulary.RDF;

/**
 * @author jheys
 */
public class Main {

    public static void main(String[] args) throws ParseException {

        String limpieza[] = {",", ".", "{", "}", "[", "]", "ç", "ã", "'", "(", ")", ";", ":", "%", "&", "ñ", "¤", "δ", "’"};

        // ********** Variables para fichero CSV **********
        List<Csv> list = new ArrayList<>();
        Csv obj = new Csv();
        // trae datos con respecto al coronavirus
        list = obj.leer("metadata_principal.csv");

        // ********** Variables para los archivos Json **********
        ArrayList<Paper> listJson = new ArrayList<>();
        String dir1 = "Datos/Copia/pdf_json/";
        String dir2 = "Datos/Copia/pmc_json/";
        String[] listaDeDirectorios = {dir1, dir2};
        for (int cont = 0; cont < listaDeDirectorios.length; cont++) {
            File carpeta = new File(listaDeDirectorios[cont]);
            String[] listado = carpeta.list();
            BufferedReader br = null;
            Gson gson = new Gson();
            String[] diccionario = {"covid-19", "sars-cov-2"};
            for (int i = 0; i < listado.length; i++) {
                try {
                    br = new BufferedReader(new FileReader(listaDeDirectorios[cont] + listado[i]));
                    Paper result = gson.fromJson(br, Paper.class);
                    //System.out.println(listado[i]);
                    for (String actual : diccionario) {
                        if (result.getMetadata().getTitle().toLowerCase().contains(actual)) {
                            listJson.add(result);
                            break;
                        }
                    }
                } catch (FileNotFoundException e) {
                    System.err.println(e.getMessage());
                }
            }
        }

        // Dato para validar si el usuario posee correo
        String mail;
        // Datos para validar si la location es null
        String addrLine;
        String postCode;
        String settlement;
        String region;
        String country;

        // Datos para validar si la Organización es null
        String institution;
        String laboratory;

        // Ontologia RDF
        Model model = ModelFactory.createDefaultModel();
        try {
            File f = new File("Authors_Graphs.rdf");
            FileOutputStream os = new FileOutputStream(f);

            //prefijo para CLASES creadas en la ontología
            String dataPrefix = "http://utpl.edu.ec/lod/biblioCOVID/ontology/";
            model.setNsPrefix("data", dataPrefix);

            //prefijo para PROPIEDADES creadas
            String propdesPrefix = "http://utpl.edu.ec/lod/biblioCOVID/ontology/myOnto/";
            model.setNsPrefix("myOnto", propdesPrefix);
            Model myOntoModel = ModelFactory.createDefaultModel();

            //prefijo para dublincore
            String dublincore = "http://purl.org/dc/elements/1.1/";
            model.setNsPrefix("dc", dublincore);
            Model dcModel = ModelFactory.createDefaultModel();

            //Prefio para schema
            String schema = "http://schema.org/";
            model.setNsPrefix("schema", schema);
            Model schemaModel = ModelFactory.createDefaultModel();

            //prefijo para fabio
            String fabio = "http://purl.org/spar/fabio/";
            model.setNsPrefix("fabio", fabio);
            Model fabioModel = ModelFactory.createDefaultModel();

            //prefijo para frbr
            String frbr = "http://purl.org/vocab/frbr/core#";
            model.setNsPrefix("frbr", frbr);
            Model frbrModel = ModelFactory.createDefaultModel();

            //Fijar Prefijo para otros vocabularios como DBPedia que no están directamente incorporados en Jena
            String dbo = "http://dbpedia.org/ontology/";
            model.setNsPrefix("dbo", dbo);
            Model dboModel = ModelFactory.createDefaultModel();

            String rdfs = "https://www.w3.org/2000/01/rdf-schema/";
            model.setNsPrefix("rdfs", rdfs);
            Model rdfsModel = ModelFactory.createDefaultModel();

            Resource paper = model.createResource(dataPrefix + "Paper")
                    .addProperty(rdfsModel.getProperty(rdfs + "subClassOf"),
                            dcModel.getResource(dublincore + "BibliographicResource"))
                    .addProperty(myOntoModel.getProperty(propdesPrefix + "isPart"),
                            fabioModel.getResource(fabio + "Journal"));

            for (Csv actualCsv : list) {
                for (Paper actualJson : listJson) {
                    if (actualCsv.getId_paper()[0].equals(actualJson.getPaper_id())
                            || actualCsv.getPmcid().equals(actualJson.getPaper_id())) {
                        System.out.println(actualJson.getPaper_id());
                        Resource location = null;

                        String limpiezaJournal = actualCsv.getJorunal().replace(" ", "_");
                        for (String actual : limpieza) {
                            limpiezaJournal = limpiezaJournal.replace(actual, "");
                        }

                        Resource journal = model.createResource(dataPrefix + limpiezaJournal)
                                .addProperty(RDF.type, fabioModel.getResource(fabio + "Journal"))
                                .addProperty(rdfsModel.getProperty(rdfs + "comment"),
                                        "Corresponde a una revista en la cual pueden ser publicados recursos bibliográficos");

                        Resource id_paper = model.createResource(dataPrefix + actualJson.getPaper_id())
                                .addProperty(RDF.type, paper)
                                .addProperty(dcModel.getProperty(dublincore + "title"), actualJson.getMetadata().getTitle())
                                .addProperty(dcModel.getProperty(dublincore + "date"), actualCsv.getPublish_time())
                                .addProperty(fabioModel.getProperty(fabio + "hasDOI"), actualCsv.getDoi())
                                .addProperty(dcModel.getProperty(dublincore + "abstract"), actualCsv.getAbstract_paper())
                                .addProperty(myOntoModel.getProperty(propdesPrefix + "hasJournal"), journal)
                                .addProperty(fabioModel.getProperty(fabio + "hasURL"), actualCsv.getUrl());

                        for (int cont = 0; cont < actualJson.getMetadata().getAuthors().size(); cont++) {

                            String newAutor = actualJson.getMetadata().getAuthors().get(cont).getFirst()
                                    + " " + actualJson.getMetadata().getAuthors().get(cont).getLast();

                            mail = actualJson.getMetadata().getAuthors().get(cont).getEmail();
                            if (mail == null) {
                                mail = "";
                            }

                            String limpiezaAutor = newAutor.replace(" ", "_");
                            for (String actual : limpieza) {
                                limpiezaAutor = limpiezaAutor.replace(actual, "");
                            }

                            Resource autor = model.createResource(dataPrefix + limpiezaAutor)
                                    .addProperty(RDF.type, FOAF.Person)
                                    .addProperty(FOAF.name, actualJson.getMetadata().getAuthors().get(cont).getFirst())
                                    .addProperty(FOAF.lastName, actualJson.getMetadata().getAuthors().get(cont).getLast())
                                    .addProperty(dcModel.getProperty(dublincore + "creator"), id_paper)
                                    .addProperty(dboModel.getProperty(dbo + "suffix"), actualJson.getMetadata().getAuthors().get(cont).getSuffix())
                                    .addProperty(schemaModel.getProperty(schema + "email"), mail)
                                    .addProperty(myOntoModel.getProperty(propdesPrefix + "middle"), Arrays.toString(actualJson.getMetadata().getAuthors().get(cont).getMiddle()));

                            if (actualJson.getMetadata().getAuthors().get(cont).getAffiliation().getLocation() != null) {
                                settlement = actualJson.getMetadata().getAuthors().get(cont).getAffiliation().getLocation().getSettlement();
                                if (settlement == null) {
                                    settlement = "";
                                }

                                addrLine = actualJson.getMetadata().getAuthors().get(cont).getAffiliation().getLocation().getAddrLine();
                                if (addrLine == null || addrLine.isEmpty()) {
                                    addrLine = "";
                                }

                                postCode = actualJson.getMetadata().getAuthors().get(cont).getAffiliation().getLocation().getPostCode();
                                if (postCode == null) {
                                    postCode = "";
                                }

                                country = actualJson.getMetadata().getAuthors().get(cont).getAffiliation().getLocation().getCountry();
                                if (country == null) {
                                    country = "";
                                }

                                region = actualJson.getMetadata().getAuthors().get(cont).getAffiliation().getLocation().getRegion();
                                if (region == null) {
                                    region = "";
                                }

                                String limpiezaSettlement = settlement.replace(" ", "_");
                                for (String actual : limpieza) {
                                    limpiezaSettlement = limpiezaSettlement.replace(actual, "");
                                }

                                location = model.createResource(dataPrefix + limpiezaSettlement)
                                        .addProperty(RDF.type, frbrModel.getResource(frbr + "Place"))
                                        .addProperty(myOntoModel.getProperty(propdesPrefix + "addrLine"), addrLine)
                                        .addProperty(myOntoModel.getProperty(propdesPrefix + "postCode"), postCode)
                                        .addProperty(myOntoModel.getProperty(propdesPrefix + "settlement"), settlement)
                                        .addProperty(myOntoModel.getProperty(propdesPrefix + "hasCountry"), country)
                                        .addProperty(myOntoModel.getProperty(propdesPrefix + "hasRegion"), region);

                                //✉ --> c5db08a4925ae08d69530ee3c2bb263f8fd9fca4 --> first": "\u2709"
                            }

                            laboratory = actualJson.getMetadata().getAuthors().get(cont).getAffiliation().getLaboratory();
                            if (laboratory == null) {
                                laboratory = "";
                            }

                            institution = actualJson.getMetadata().getAuthors().get(cont).getAffiliation().getInstitution();
                            if (institution == null) {
                                institution = "";
                            }
                            String limpiezaInstitution = institution.replace(" ", "_");
                            for (String actual : limpieza) {
                                limpiezaInstitution = limpiezaInstitution.replace(actual, "");
                            }
                            if (location != null) {

                                Resource organization = model.createResource(dataPrefix + limpiezaInstitution)
                                        .addProperty(RDF.type, FOAF.Organization)
                                        .addProperty(schemaModel.getProperty(schema + "affiliation"), autor)
                                        .addProperty(myOntoModel.getProperty(propdesPrefix + "laboratory"), laboratory)
                                        .addProperty(myOntoModel.getProperty(propdesPrefix + "institution"), institution)
                                        .addProperty(schemaModel.getProperty(schema + "location"), location);
                            } else {
                                Resource organization = model.createResource(dataPrefix + limpiezaInstitution)
                                        .addProperty(RDF.type, FOAF.Organization)
                                        .addProperty(schemaModel.getProperty(schema + "affiliation"), autor)
                                        .addProperty(myOntoModel.getProperty(propdesPrefix + "laboratory"), laboratory)
                                        .addProperty(myOntoModel.getProperty(propdesPrefix + "institution"), institution);

                            }
                            model.add(autor, DCTerms.subject, id_paper);
                        }
                        break;
                    }
                }
            }

            // model.write(System.out);
            model.write(System.out, "N3");

            RDFWriter writer = model.getWriter("RDF/XML");
            writer.write(model, os, "");
            //Close model
            model.close();

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
