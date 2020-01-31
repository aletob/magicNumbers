package magicNumbersVerifier.exceptions;

public class UnsupportedFileTypeException extends Exception {
    public UnsupportedFileTypeException(String givenExtension) {
        super("Extension " + givenExtension + " is not supported");
    }
}
