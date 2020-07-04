package lectorCSV;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author jheys
 */
public class Main {

    public static void main(String[] args) throws IOException {
        List<Csv> list = new ArrayList<>();
        Csv obj = new Csv();
        // Lee el fichero csv y trae solo datos con respecto al coronavirus
        list = obj.leer("");        
    }
}