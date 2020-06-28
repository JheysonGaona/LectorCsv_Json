package lectorCSV;

import au.com.bytecode.opencsv.CSVReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author jheys
 */
public class Csv {

    private String cord_uid;
    private String[] id_paper;
    private String source_x;
    private String title;
    private String doi;
    private String pmcid;
    private String pubmed_id;
    private String license;
    private String abstract_paper;
    private String publish_time;
    private ArrayList authors;
    private String jorunal;
    private String microsoft_Academic_Paper_ID;
    private String who_Covidence;
    private String arxiv_id;
    private boolean has_pdf_parce;
    private boolean has_pmc_xml_parse;
    private String full_text_file;
    private String url;

    public Csv() {
    }

    public Csv(String cord_uid, String[] id_paper, String source_x, String title,
            String doi, String pmcid, String pubmed_id, String license, String abstract_paper,
            String publish_time, ArrayList authors, String jorunal,
            String microsoft_Academic_Paper_ID, String who_Covidence,
            String arxiv_id, boolean has_pdf_parce, boolean has_pmc_xml_parse,
            String full_text_file, String url) {
        this.cord_uid = cord_uid;
        this.id_paper = id_paper;
        this.source_x = source_x;
        this.title = title;
        this.doi = doi;
        this.pmcid = pmcid;
        this.pubmed_id = pubmed_id;
        this.license = license;
        this.abstract_paper = abstract_paper;
        this.publish_time = publish_time;
        this.authors = authors;
        this.jorunal = jorunal;
        this.microsoft_Academic_Paper_ID = microsoft_Academic_Paper_ID;
        this.who_Covidence = who_Covidence;
        this.arxiv_id = arxiv_id;
        this.has_pdf_parce = has_pdf_parce;
        this.has_pmc_xml_parse = has_pmc_xml_parse;
        this.full_text_file = full_text_file;
        this.url = url;
    }

    public String getCord_uid() {
        return cord_uid;
    }

    public void setCord_uid(String cord_uid) {
        this.cord_uid = cord_uid;
    }

    public String[] getId_paper() {
        return id_paper;
    }

    public void setId_paper(String[] id_paper) {
        this.id_paper = id_paper;
    }

    public String getSource_x() {
        return source_x;
    }

    public void setSource_x(String source_x) {
        this.source_x = source_x;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDoi() {
        return doi;
    }

    public void setDoi(String doi) {
        this.doi = doi;
    }

    public String getPmcid() {
        return pmcid;
    }

    public void setPmcid(String pmcid) {
        this.pmcid = pmcid;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public String getAbstract_paper() {
        return abstract_paper;
    }

    public void setAbstract_paper(String abstract_paper) {
        this.abstract_paper = abstract_paper;
    }

    public String getPublish_time() {
        return publish_time;
    }

    public void setPublish_time(String publish_time) {
        this.publish_time = publish_time;
    }

    public ArrayList getAuthors() {
        return authors;
    }

    public void setAuthors(ArrayList authors) {
        this.authors = authors;
    }

    public String getJorunal() {
        return jorunal;
    }

    public void setJorunal(String jorunal) {
        this.jorunal = jorunal;
    }

    public String getMicrosoft_Academic_Paper_ID() {
        return microsoft_Academic_Paper_ID;
    }

    public void setMicrosoft_Academic_Paper_ID(String microsoft_Academic_Paper_ID) {
        this.microsoft_Academic_Paper_ID = microsoft_Academic_Paper_ID;
    }

    public String getWho_Covidence() {
        return who_Covidence;
    }

    public void setWho_Covidence(String who_Covidence) {
        this.who_Covidence = who_Covidence;
    }

    public String getArxiv_id() {
        return arxiv_id;
    }

    public void setArxiv_id(String arxiv_id) {
        this.arxiv_id = arxiv_id;
    }

    public boolean isHas_pdf_parce() {
        return has_pdf_parce;
    }

    public void setHas_pdf_parce(boolean has_pdf_parce) {
        this.has_pdf_parce = has_pdf_parce;
    }

    public boolean isHas_pmc_xml_parse() {
        return has_pmc_xml_parse;
    }

    public void setHas_pmc_xml_parse(boolean has_pmc_xml_parse) {
        this.has_pmc_xml_parse = has_pmc_xml_parse;
    }

    public String getFull_text_file() {
        return full_text_file;
    }

    public void setFull_text_file(String full_text_file) {
        this.full_text_file = full_text_file;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPubmed_id() {
        return pubmed_id;
    }

    public void setPubmed_id(String pubmed_id) {
        this.pubmed_id = pubmed_id;
    }

    public List<Csv> leer(String link) {
        List<Csv> lista = new ArrayList<>();
        String[] linea = null;
        String[] diccionario = {"covid-19", "sars-cov-2"};
        ArrayList<Author> listAuthors;
        Author objAuthor;
        int inicio = 0, cont = 1;
        try {
            CSVReader lector = new CSVReader(new FileReader(link), ';', '"');
            while ((linea = lector.readNext()) != null) {
                if (inicio != 0) {
                    for (String palabraActual : diccionario) {
                        if (linea[3].toLowerCase().contains(palabraActual)) {
                            // System.out.println(cont + " " + linea[1] + ", " + linea[5]);
                            String cord_uidCsv = linea[0];
                            String[] id_paperCsv = linea[1].split(";");
                            String source_xCsv = linea[2];
                            String titleCsv = linea[3];
                            String doiCsv = linea[4];
                            String pmcidCsv = linea[5];
                            String pubmed_idCsv = linea[6];
                            String licenseCsv = linea[7];
                            String abstract_paperCsv = linea[8];
                            String publish_timeCsv = linea[9];
                            String[] authorsCsv = linea[10].replace(", ", " ").split(";");
                            listAuthors = new ArrayList<>();
                            for (String actual : authorsCsv) {
                                objAuthor = new Author(actual);
                                listAuthors.add(objAuthor);
                            }
                            String jorunalCsv = linea[11];
                            String microsoft_Academic_Paper_IDCsv = linea[12];
                            String who_CovidenceCsv = linea[13];
                            String arxiv_idCsv = linea[14];
                            boolean has_pdf_parceCsv = Boolean.parseBoolean(linea[15]);
                            boolean has_pmc_xml_parseCsv = Boolean.parseBoolean(linea[16]);
                            String full_text_fileCsv = linea[17];
                            String urlCsv = linea[18];

                            lista.add(new Csv(cord_uidCsv, id_paperCsv, source_xCsv,
                                    titleCsv, doiCsv, pmcidCsv, pubmed_idCsv, licenseCsv,
                                    abstract_paperCsv, publish_timeCsv, listAuthors, jorunalCsv,
                                    microsoft_Academic_Paper_IDCsv, who_CovidenceCsv,
                                    arxiv_idCsv, has_pdf_parceCsv, has_pmc_xml_parseCsv,
                                    full_text_fileCsv, urlCsv));
                            cont++;
                        }
                    }
                }
                inicio++;
            }
            if (linea != null) {
                lector.close();
            }
        } catch (FileNotFoundException e) {
            System.err.println(e.getMessage());
        } catch (IOException io) {
            System.err.println(io.getMessage());
        }
        return lista;
    }
}
