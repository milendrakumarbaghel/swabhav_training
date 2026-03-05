package string.main;

public class FileNameValidator {
    public boolean isPdf(String fileName) {
        return fileName.endsWith(".pdf");
    }

    public String getExtension(String fileName) {
        int index = fileName.lastIndexOf(".");
        return fileName.substring(index + 1);
    }

    public String getFileNameWithoutExtension(String fileName) {
        int index = fileName.lastIndexOf(".");
        return fileName.substring(0, index);
    }

    public String replaceUnderscore(String name) {
        return name.replace("_", " ");
    }

    public String convertUpperCase(String name) {
        return name.toUpperCase();
    }

    public boolean containsFinal(String name) {
        return name.toLowerCase().contains("final");
    }
}
