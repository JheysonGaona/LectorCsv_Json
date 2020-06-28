package juntarDatosJsonCsv;

/**
 * @author jheys
 */
public class BibliograficR_Author {
    
    private int bibliograficResource_id;
    private int author_id;

    public BibliograficR_Author() {
    }

    public BibliograficR_Author(int bibliograficResource_id, int author_id) {
        this.bibliograficResource_id = bibliograficResource_id;
        this.author_id = author_id;
    }

    public int getBibliograficResource_id() {
        return bibliograficResource_id;
    }

    public void setBibliograficResource_id(int bibliograficResource_id) {
        this.bibliograficResource_id = bibliograficResource_id;
    }

    public int getAuthor_id() {
        return author_id;
    }

    public void setAuthor_id(int author_id) {
        this.author_id = author_id;
    }
}