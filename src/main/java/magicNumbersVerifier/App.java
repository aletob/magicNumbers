package magicNumbersVerifier;

import java.io.File;

public class App {
    public static void main(String[] args) {

        try {
            String inputFileNAme = FileReader.getFileName();
            File file = FileReader.readFileFromPath(inputFileNAme);
            if (MagicNumberManager.isExtensionSupported(file)) {
                System.out.println("Supported");
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
