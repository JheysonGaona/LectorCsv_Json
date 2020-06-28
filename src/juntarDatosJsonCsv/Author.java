package juntarDatosJsonCsv;

/**
 * @author jheys
 */
public class Author {

    private int id;
    private String name;
    private String suffix;
    private String middle;
    private String email;
    private int affiliation_id;

    public Author() {
    }
    
    public Author(String name, String suffix, String middle, String email) {
        this.name = name;
        this.suffix = suffix;
        this.middle = middle;
        this.email = email;
    }

    public Author(int id, String name, String suffix, String middle, String email, int affiliation_id) {
        this.id = id;
        this.name = name;
        this.suffix = suffix;
        this.middle = middle;
        this.email = email;
        this.affiliation_id = affiliation_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    public String getMiddle() {
        return middle;
    }

    public void setMiddle(String middle) {
        this.middle = middle;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAffiliation_id() {
        return affiliation_id;
    }

    public void setAffiliation_id(int affiliation_id) {
        this.affiliation_id = affiliation_id;
    }
}
