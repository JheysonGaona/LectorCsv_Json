package juntarDatosJsonCsv;

/**
 * @author jheys
 */
public class Location {
    
    private int id;
    private String settlement;
    private String addrline;
    private String addressCountry;
    private String region;
    private String postCode;

    public Location() {
    }
    
    public Location(String settlement, String addrline, String addressCountry, String region, String postCode) {
        this.settlement = settlement;
        this.addrline = addrline;
        this.addressCountry = addressCountry;
        this.region = region;
        this.postCode = postCode;
    }

    public Location(int id, String settlement, String addrline, String addressCountry, String region, String postCode) {
        this.id = id;
        this.settlement = settlement;
        this.addrline = addrline;
        this.addressCountry = addressCountry;
        this.region = region;
        this.postCode = postCode;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSettlement() {
        return settlement;
    }

    public void setSettlement(String settlement) {
        this.settlement = settlement;
    }

    public String getAddrline() {
        return addrline;
    }

    public void setAddrline(String addrline) {
        this.addrline = addrline;
    }

    public String getAddressCountry() {
        return addressCountry;
    }

    public void setAddressCountry(String addressCountry) {
        this.addressCountry = addressCountry;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }
    
}
