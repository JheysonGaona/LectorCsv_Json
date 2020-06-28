package lectorJson;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * @author jheys
 */
public class Paper {

    @SerializedName("paper_id")
    @Expose
    public String paper_id;

    @SerializedName("metadata")
    @Expose
    private Metadata metadata;

    public Paper() {
    }
    
    public Paper(String paper_id, Metadata metadata) {
        this.paper_id = paper_id;
        this.metadata = metadata;
    }
    
    public String getPaper_id() {
        return paper_id;
    }

    public void setPaper_id(String paper_id) {
        this.paper_id = paper_id;
    }

    public Metadata getMetadata() {
        return metadata;
    }

    public void setMetadata(Metadata metadata) {
        this.metadata = metadata;
    }

    @Override
    public String toString() {

        return "{ \n"
                + "\tpaper_id: " + getPaper_id() + "\n"
                + "\tmetadata: {" + this.getMetadata().toString()
                + "\n}";
    }
}
