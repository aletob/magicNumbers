package magicNumbersVerifier;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;

public class UserInteraction {

    public static String getUserInput() throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        return reader.readLine();
    }

    public static void printMainOptions(){
        System.out.println("\nTo quit the program, press \"q\".");

        String filePath = new File("").getAbsolutePath();
        System.out.println("To verify file extension, give a name of a file from given location: " + filePath);
    }
}
