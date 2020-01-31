package magicNumbersVerifier;

import java.io.*;

public class FileReader {

    public static String getFileName() throws IOException {

        String filePath = new File("").getAbsolutePath();
        System.out.println("Give a file from location: " + filePath);

        BufferedReader fileNameReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = fileNameReader.readLine();

        System.out.println("Given file: " + fileName);

        return filePath + "\\" + fileName;

    }

    public static File readFileFromPath(String path) throws FileNotFoundException {
        File file = new File(path);
        if (!file.exists()) {
            throw new FileNotFoundException();
        }
        return file;
    }
}
