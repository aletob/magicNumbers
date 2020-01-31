package magicNumbersVerifier.exceptions;

public class IncorrectFileNameException extends Exception {
    public IncorrectFileNameException(String name) {
        super("Give a namefile with extension. " + name + " is incorrect");
    }
}
