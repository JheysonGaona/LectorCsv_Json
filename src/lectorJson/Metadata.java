package lectorJson;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;

/**
 * @author jheys
 */
public class Metadata {

    @SerializedName("title")
    @Expose
    private String title;

    @SerializedName("authors")
    @Expose
    private List<Authors> authors;

    public Metadata() {
    }

    public Metadata(String title, List<Authors> authors) {
        this.title = title;
        this.authors = authors;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Authors> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Authors> authors) {
        this.authors = authors;
    }

    @Override
    public String toString() {
        return "\n"
                + "\t\ttitle: " + getTitle() + "\n"
                + "\t\tauthors: " + this.getAuthors().toString()
                + "\t\t";
    }
}
