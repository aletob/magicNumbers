import magicNumbersVerifier.FileReader;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;

public class MagicNumberVerifier {

    @Test(expected = FileNotFoundException.class)
    public void shouldThrowFileNotFoundException() throws Exception {
        String filePath = new File("").getAbsolutePath();
        String randomName = "notExistingFile.pdf";
        String nameWithPath = filePath + "\\" + randomName;
        FileReader.readFileFromPath(nameWithPath);

    }
}
