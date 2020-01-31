package magicNumbersVerifier;

import java.io.File;
import java.io.IOException;

public class App {
    public static void main(String[] args) throws Exception {

        UserInteraction.printMainOptions();
        String userInput = UserInteraction.getUserInput();

        while (userInput != null && !userInput.equals("q")) {
            try {
                String fileFullPath = FileReader.getFileName(userInput);
                File file = FileReader.readFileFromPath(fileFullPath);
                if (MagicNumberManager.isExtensionSupported(file)) {
                    MagicNumberManager.verifyFileNumbers(file);
                }
            } catch (IOException e) {
                System.out.println("Reading given file failed. Check if you put correct name.");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            } finally {
                UserInteraction.printMainOptions();
                userInput = UserInteraction.getUserInput();
            }
        }

    }
}
