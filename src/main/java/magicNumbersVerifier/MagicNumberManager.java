package magicNumbersVerifier;

import magicNumbersVerifier.exceptions.IncorrectFileNameException;
import magicNumbersVerifier.exceptions.UnsupportedFileTypeException;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Map;

public class MagicNumberManager {
    private static Map<String, FileType> supportedExtensions = FileType.setSupportedFileType();

    public static Map<String, FileType> getSupportedExtensions() {
        return supportedExtensions;
    }

    public static String getExtension(File file) throws IncorrectFileNameException {
        String name = file.getName();
        int dotIndex = name.indexOf('.');
        if (dotIndex < 0) {
            throw new IncorrectFileNameException(name);
        }
        String extension = name.substring(dotIndex + 1);
        return extension.toUpperCase();
    }

    public static boolean isExtensionSupported(File file) throws Exception {
        String givenExtension = MagicNumberManager.getExtension(file);
        if (supportedExtensions.keySet().contains(givenExtension)) {
            return true;
        } else {
            throw new UnsupportedFileTypeException(givenExtension);
        }
    }

    public static String[] countNumbersOfGivenFile(File file, String extension) throws Exception {
        byte[] bFile = Files.readAllBytes(Paths.get(file.getPath()));

        int bytesToCheck = supportedExtensions.get(extension).getBytesToCheck().length;
        String[] givenFileNumbers = new String[bytesToCheck];

        int byteIndex;
        for (int i = 0; (i < bytesToCheck && i < bFile.length); i++) {
            byteIndex = supportedExtensions.get(extension).getBytesToCheck()[i];
            byteIndex = byteIndex >= 0 ? byteIndex : bFile.length + byteIndex;
            givenFileNumbers[i] = String.format("%02X", bFile[byteIndex]);
        }
        return givenFileNumbers;
    }

    public static boolean verifyFileNumbers(File file) throws Exception {
        String extension = MagicNumberManager.getExtension(file);
        String[] givenFileNumbers = MagicNumberManager.countNumbersOfGivenFile(file, extension);

        for (String[] array : supportedExtensions.get(extension).getMagicNumbers()) {
            if (Arrays.equals(array, givenFileNumbers)) {
                System.out.println("File format correct, it's " + extension);
                return true;
            }
        }
        System.out.println("Given extension is incorrect. It's not " + extension);
        return false;
    }


}
