package juntarDatosJsonCsv;

/**
 * @author jheys
 */
public class Thematic {
    
    private int id;
    private String nameThematic;

    public Thematic() {
    }

    public Thematic(int id, String nameThematic) {
        this.id = id;
        this.nameThematic = nameThematic;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameThematic() {
        return nameThematic;
    }

    public void setNameThematic(String nameThematic) {
        this.nameThematic = nameThematic;
    }
}