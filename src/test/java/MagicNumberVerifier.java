import magicNumbersVerifier.FileReader;
import magicNumbersVerifier.MagicNumberManager;
import magicNumbersVerifier.exceptions.UnsupportedFileTypeException;
import org.junit.Assert;
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

    @Test
    public void shouldReturnPDFForTestPdfExistingFile() throws Exception {
        String filePath = new File("").getAbsolutePath();
        String randomName = "test.pdf";
        String nameWithPath = filePath + "\\" + randomName;

        File file = FileReader.readFileFromPath(nameWithPath);
        String extension = MagicNumberManager.getExtension(file);

        Assert.assertEquals("PDF", extension);
    }

    @Test
    public void shouldBeTrueIfExtensionJPG() throws Exception {
        String filePath = new File("").getAbsolutePath();
        String existingFile = "test.jpg";
        String nameWithPath = filePath + "\\" + existingFile;
        File file = FileReader.readFileFromPath(nameWithPath);
        boolean isSupported = MagicNumberManager.isExtensionSupported(file);

        Assert.assertTrue(isSupported);
    }

    @Test(expected = UnsupportedFileTypeException.class)
    public void shouldThrowExceptionIfExtensionDOCX() throws Exception{
        String filePath = new File("").getAbsolutePath();
        String existingFile = "test.docx";
        String nameWithPath = filePath + "\\" + existingFile;
        File file = FileReader.readFileFromPath(nameWithPath);
        MagicNumberManager.isExtensionSupported(file);

    }

    @Test
    public void shouldReturnArray() throws Exception{

        String filePath = new File("").getAbsolutePath();
        String existingFile = "test.jpg";
        String nameWithPath = filePath + "\\" + existingFile;
        File file = FileReader.readFileFromPath(nameWithPath);
        String[] calculatedMagicNumbers = MagicNumberManager.countNumbersOfGivenFile(file, "JPG");

        String[] jpgArray = MagicNumberManager.getSupportedExtensions().get("JPG").getMagicNumbers().get(0);
        Assert.assertArrayEquals(jpgArray, calculatedMagicNumbers);
    }
}
