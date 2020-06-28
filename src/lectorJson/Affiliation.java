package lectorJson;

/**
 * @author jheys
 */
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Affiliation {

    @SerializedName("laboratory")
    @Expose
    private String laboratory;

    @SerializedName("institution")
    @Expose
    private String institution;

    @SerializedName("location")
    @Expose
    private Location location;

    public Affiliation() {
    }

    public Affiliation(String laboratory, String institution, Location location) {
        this.laboratory = laboratory;
        this.institution = institution;
        this.location = location;
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

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
    
        @Override
    public String toString() {
        return "\n"
                + "\t\t\t\tlaboratory: " + getLaboratory() + "\n"
                + "\t\t\t\tinstitution: " + getInstitution() + "\n"
                + "\t\t\t\tlocation: {" + getLocation()
                + "\n\t\t\t\t}";
    }
}
