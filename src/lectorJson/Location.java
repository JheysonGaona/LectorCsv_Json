package lectorJson;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * @author jheys
 */
public class Location {

    @SerializedName("addrLine")
    @Expose
    private String addrLine;

    @SerializedName("postCode")
    @Expose
    private String postCode;

    @SerializedName("settlement")
    @Expose
    private String settlement;

    @SerializedName("region")
    @Expose
    private String region;

    @SerializedName("country")
    @Expose
    private String country;

    public Location() {
    }

    public Location(String addrLine, String postCode, String settlement, String region, String country) {
        this.addrLine = addrLine;
        this.postCode = postCode;
        this.settlement = settlement;
        this.region = region;
        this.country = country;
    }

    public String getAddrLine() {
        return addrLine;
    }

    public void setAddrLine(String addrLine) {
        this.addrLine = addrLine;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String post_Code) {
        this.postCode = post_Code;
    }

    public String getSettlement() {
        return settlement;
    }

    public void setSettlement(String settlement) {
        this.settlement = settlement;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {

        return "\n"
                + "\t\t\t\t\taddrLine: " + getAddrLine() + "\n"
                + "\t\t\t\t\tpost_Code: " + getPostCode() + "\n"
                + "\t\t\t\t\tsettlement: " + getSettlement() + "\n"
                + "\t\t\t\t\tregion: " + getRegion() + "\n"
                + "\t\t\t\t\tcountry: " + getCountry()
                + "\n\t\t\t\t\t}";
    }
}
