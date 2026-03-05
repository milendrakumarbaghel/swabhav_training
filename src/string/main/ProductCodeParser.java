package string.main;

public class ProductCodeParser {
    public String[] splitString(String productCode) {
        return productCode.split("-");
    }

    public String getCategory(String[] parts) {
        return parts[0].toUpperCase();
    }

    public String getProduct(String[] parts) {
        return parts[1];
    }

    public String getYear(String[] parts) {
        return parts[2];
    }

    public boolean startsWithProductType(String productCode, String category) {
        return productCode.startsWith(category);
    }

    public boolean endsWithYear(String productCode, int year) {
        return productCode.endsWith(Integer.toString(year));
    }

    public String replaceHyphen(String productCode) {
        return productCode.replace("-", " ");
    }

    public int firstHyphenPosition(String productCode) {
        return productCode.indexOf("-");
    }

}
