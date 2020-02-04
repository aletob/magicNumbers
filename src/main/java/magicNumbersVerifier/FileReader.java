package magicNumbersVerifier;

import java.io.*;

public class FileReader {

    public static String getFileName(String userInput) throws Exception {
        String filePath = new File("").getAbsolutePath();
        return new StringBuilder(filePath).append(File.separator).append(userInput).toString();

    }

    public static File readFileFromPath(String path) throws FileNotFoundException {
        File file = new File(path);
        if (!file.exists()) {
            throw new FileNotFoundException();
        }
        return file;
    }
}
