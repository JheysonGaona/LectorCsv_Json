package juntarDatosJsonCsv;

/**
 * @author jheys
 */
public class Affiliation {
    
    private int id;
    private String laboratory;
    private String institution;

    public Affiliation() {
    }
    
    public Affiliation(String laboratory, String institution) {
        this.laboratory = laboratory;
        this.institution = institution;
    }

    public Affiliation(int id, String laboratory, String institution) {
        this.id = id;
        this.laboratory = laboratory;
        this.institution = institution;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLaboratory() {
        return laboratory;
    }

    public void setLaboratory(String laboratory) {
        this.laboratory = laboratory;
    }

    public String getInstitution() {
        return institution;
    }

    public void setInstitution(String institution) {
        this.institution = institution;
    }
}