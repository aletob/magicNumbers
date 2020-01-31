package magicNumbersVerifier;

import java.io.File;

public class App {
    public static void main(String[] args) {

        try {
            String inputFileNAme = FileReader.getFileName();
            File file = FileReader.readFileFromPath(inputFileNAme);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
