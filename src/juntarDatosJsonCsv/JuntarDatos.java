package juntarDatosJsonCsv;

/**
 * @author jheys
 */
public class JuntarDatos {

    private BibliograficR_Author bibliograficR_Author;
    private Thematic thematic;
    private Author author;
    private Affiliation affiliation;
    private Location location;

    public JuntarDatos() {
    }

    public JuntarDatos(BibliograficR_Author bibliograficR_Author, Thematic thematic,
            Author author, Affiliation affiliation, Location location) {
        this.bibliograficR_Author = bibliograficR_Author;
        this.thematic = thematic;
        this.author = author;
        this.affiliation = affiliation;
        this.location = location;
    }

    public BibliograficR_Author getBibliograficR_Author() {
        return bibliograficR_Author;
    }

    public void setBibliograficR_Author(BibliograficR_Author bibliograficR_Author) {
        this.bibliograficR_Author = bibliograficR_Author;
    }

    public Thematic getThematic() {
        return thematic;
    }

    public void setThematic(Thematic thematic) {
        this.thematic = thematic;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Affiliation getAffiliation() {
        return affiliation;
    }

    public void setAffiliation(Affiliation affiliation) {
        this.affiliation = affiliation;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}