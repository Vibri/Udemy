package cz.vibri.io.javaio;

import java.io.File;
import java.net.URI;

public class FileAPI {

    public static void main(String[] args) {
        File f1 = new File("/src/main/resources/files");
        File f2 = new File(f1, "text.txt");
    }
}
