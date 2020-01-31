package magicNumbersVerifier;

import magicNumbersVerifier.exceptions.IncorrectFileNameException;
import magicNumbersVerifier.exceptions.UnsupportedFileTypeException;

import java.io.File;
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


}
