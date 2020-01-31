package magicNumbersVerifier;

import java.util.*;

public class FileType {

    private final String extension;
    private final List<String[]> magicNumbers;
    private final int[] bytesToCheck;

    public FileType(String extension, List<String[]> magicNumbers, int[] bytesToCheck) {
        this.extension = extension;
        this.magicNumbers = magicNumbers;
        this.bytesToCheck = bytesToCheck;
    }

    public String getExtension() {
        return extension;
    }

    public List<String[]> getMagicNumbers() {
        return magicNumbers;
    }

    public int[] getBytesToCheck() {
        return bytesToCheck;
    }


/*    Data source:
    https://en.wikipedia.org/wiki/Magic_number_(programming)#Magic_numbers_in_files
    https://en.wikipedia.org/wiki/List_of_file_signatures*/

    public static Map<String, FileType> setSupportedFileType() {
        Map<String, FileType> supportedFiles = new HashMap<>();

        List<String[]> gifNumbers = Arrays.asList(
                new String[]{"47", "49", "46", "38", "39", "61"},
                new String[]{"47", "49", "46", "38", "37", "61"});
        FileType gif = new FileType("GIF", gifNumbers, new int[]{0, 1, 2, 3, 4, 5});

        List<String[]> jpgNumbers = Collections.singletonList(new String[]{"FF", "D8", "FF", "D9"});
        FileType jpg = new FileType("JPG", jpgNumbers, new int[]{0, 1, -2, -1});

        List<String[]> pngNumbers = Collections.singletonList(new String[]{"89", "50", "4E", "47", "0D", "0A", "1A", "0A"});
        FileType png = new FileType("PNG", pngNumbers, new int[]{0, 1, 2, 3, 4, 5, 6, 7});

        List<String[]> pdfNumbers = Collections.singletonList(new String[]{"25", "50", "44", "46"});
        FileType pdf = new FileType("PDF", pdfNumbers, new int[]{0, 1, 2, 3});

        List<String[]> xmlNumbers = Collections.singletonList(new String[]{"3C", "3F", "78", "6D", "6C", "20"});
        FileType xml = new FileType("XML", xmlNumbers, new int[]{0, 1, 2, 3, 4, 5});


        supportedFiles.put(jpg.getExtension(), jpg);
        supportedFiles.put(gif.getExtension(), gif);
        supportedFiles.put(png.getExtension(), png);
        supportedFiles.put(pdf.getExtension(), pdf);
        supportedFiles.put(xml.getExtension(), xml);

        return supportedFiles;
    }

}
