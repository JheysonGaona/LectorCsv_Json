package juntarDatosJsonCsv;

/**
 * @author jheys
 */
public class BibliograficResource {

    private String idBifliograficR;
    private String title;
    private String date;
    private String journal;
    private String doi;
    private String url;
    private int thematic_id;

    public BibliograficResource() {
    }
    
    public BibliograficResource(String idBifliograficR, String title, String date, String journal, String doi, String url) {
        this.idBifliograficR = idBifliograficR;
        this.title = title;
        this.date = date;
        this.journal = journal;
        this.doi = doi;
        this.url = url;
    }

    public BibliograficResource(String idBifliograficR, String title, String date, String journal, String doi, String url, int thematic_id) {
        this.idBifliograficR = idBifliograficR;
        this.title = title;
        this.date = date;
        this.journal = journal;
        this.doi = doi;
        this.url = url;
        this.thematic_id = thematic_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getJournal() {
        return journal;
    }

    public void setJournal(String journal) {
        this.journal = journal;
    }

    public String getDoi() {
        return doi;
    }

    public void setDoi(String doi) {
        this.doi = doi;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getThematic_id() {
        return thematic_id;
    }

    public void setThematic_id(int thematic_id) {
        this.thematic_id = thematic_id;
    }

    public String getIdBifliograficR() {
        return idBifliograficR;
    }

    public void setIdBifliograficR(String idBifliograficR) {
        this.idBifliograficR = idBifliograficR;
    }
}
