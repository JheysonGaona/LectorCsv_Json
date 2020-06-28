package lectorJson;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.Arrays;

/**
 * @author jheys
 */
public class Authors {

    @SerializedName("first")
    @Expose
    private String first;

    @SerializedName("middle")
    @Expose
    private String[] middle = new String[0];

    @SerializedName("last")
    @Expose
    private String last;

    @SerializedName("suffix")
    @Expose
    private String suffix;

    @SerializedName("affiliation")
    @Expose
    private Affiliation affiliation;

    @SerializedName("email")
    @Expose
    private String email;

    public Authors() {
    }

    public Authors(String first, String last, String suffix, Affiliation affiliation, String email) {
        this.first = first;
        this.last = last;
        this.suffix = suffix;
        this.affiliation = affiliation;
        this.email = email;
    }

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String[] getMiddle() {
        return middle;
    }

    public void setMiddle(String[] middle) {
        this.middle = middle;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    public Affiliation getAffiliation() {
        return affiliation;
    }

    public void setAffiliation(Affiliation affiliation) {
        this.affiliation = affiliation;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "\n\t\t\t{\n"
                + "\t\t\tfirt: " + getFirst() + "\n"
                + "\t\t\tlast: " + getLast() + "\n"
                + "\t\t\tmiddle: " + Arrays.toString(getMiddle()) + "\n"
                + "\t\t\tsuffix: " + getSuffix() + "\n"
                + "\t\t\tafiliation: {" + getAffiliation().toString()
                + "\n\t\t\temail: " + getEmail() + "\n"
                + "\t\t\t}";
    }
}
