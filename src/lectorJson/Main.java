package lectorJson;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import juntarDatosJsonCsv.*;
import lectorCSV.Csv;

/**
 * @author jheys
 */
public class Main {

    public static void main(String[] args) throws ParseException {

        // ********** Variables para fichero CSV **********
        List<Csv> list = new ArrayList<>();
        Csv obj = new Csv();
        // trae datos con respecto al coronavirus
        // Aqui metes la dirección del archivo CSV
        list = obj.leer("metadata(copia).csv");
        int x = 1, y = 1;
        for(Csv actual: list){
            System.out.println("Doc: " + x + " " + Arrays.toString(actual.getId_paper()));
            x++;
        }

        // ********** Variables para los archivos Json **********
        ArrayList<Paper> listJson = new ArrayList<>();
        // Aca metes la direción de la carpeta de los archivos pcm y json
        String dir1 = "Datos/Copia(copia)/noncomm_use_subset/pdf_json/";
        String dir2 = "Datos/Copia(copia)/noncomm_use_subset/pmc_json/";
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
                    // System.out.println(listado[i]);
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
        
        for(Paper actual: listJson){
            System.out.println("Doc: " + y + " " + actual.getPaper_id());
            y++;
        }

//        juntarDatosJsonCsv.BibliograficResource objRB;
//        juntarDatosJsonCsv.Author objAuthor;
//        juntarDatosJsonCsv.Affiliation objAffiliation;
//        juntarDatosJsonCsv.Location objLocation;
//        juntarDatosJsonCsv.Thematic objThematic;
//
//        ArrayList<Author> listAuthors = new ArrayList<>();
//
//        for (Csv actualCsv : list) {
//            for (Paper actualJson : listJson) {
//                if (actualCsv.getId_paper().equals(actualJson.getPaper_id())
//                        || actualCsv.getPmcid().equals(actualJson.getPaper_id())) {
//                    // System.out.println(actualCsv);
//
//                    objRB = new BibliograficResource(actualCsv.getId_paper()[0],
//                            actualCsv.getTitle(), actualCsv.getPublish_time(),
//                            actualCsv.getJorunal(),
//                            actualCsv.getDoi(), actualCsv.getUrl(), 0);
//
//                    objThematic = new Thematic();
//                    
//                    for (int j = 0; j < actualJson.getMetadata().getAuthors().size(); j++) {
//                        objAuthor = new Author(actualJson.getMetadata().getAuthors().get(j).getFirst() + " "
//                                + actualJson.getMetadata().getAuthors().get(j).getLast(),
//                                actualJson.getMetadata().getAuthors().get(j).getSuffix(),
//                                Arrays.toString(actualJson.getMetadata().getAuthors().get(j).getMiddle()),
//                                actualJson.getMetadata().getAuthors().get(j).getEmail());
//
//                        objAffiliation = new juntarDatosJsonCsv.Affiliation(
//                                actualJson.getMetadata().getAuthors().get(j).getAffiliation().getLaboratory(),
//                                actualJson.getMetadata().getAuthors().get(j).getAffiliation().getInstitution());
//
//                        objLocation = new juntarDatosJsonCsv.Location(
//                                actualJson.getMetadata().getAuthors().get(j).getAffiliation().getLocation().getSettlement(),
//                                actualJson.getMetadata().getAuthors().get(j).getAffiliation().getLocation().getAddrLine(),
//                                actualJson.getMetadata().getAuthors().get(j).getAffiliation().getLocation().getCountry(),
//                                actualJson.getMetadata().getAuthors().get(j).getAffiliation().getLocation().getRegion(),
//                                actualJson.getMetadata().getAuthors().get(j).getAffiliation().getLocation().getPostCode());
//                    }
//                }
            }
//        }
//    }

}
