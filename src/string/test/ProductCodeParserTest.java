package string.test;

import string.main.ProductCodeParser;

import java.util.Scanner;

public class ProductCodeParserTest {
    static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);
        ProductCodeParser productCodeParser = new ProductCodeParser();

        System.out.print("Enter product code (eg. CAT-ITEMCODE-YEAR -> ELC-TV-2023): ");
        String code = scanner.nextLine();

        String[] parts = productCodeParser.splitString(code);

        System.out.println("Split of product code is");
        for(String part : parts) {
            System.out.print(part + " ");
        }
        System.out.println();

        String category = productCodeParser.getCategory(parts);
        String product = productCodeParser.getProduct(parts);
        String year = productCodeParser.getYear(parts);

        System.out.println("Category: " + category);
        System.out.println("Product: " + product);
        System.out.println("Year: " + year);

        System.out.println("Enter Product Type: ");
        String productTypeToCheck = scanner.nextLine();
        boolean startsWithProductType = productCodeParser.startsWithProductType(product, productTypeToCheck);
        System.out.println("Starts with: " + productTypeToCheck + "->" + (startsWithProductType ? "Yes" : "No"));

        System.out.println("Enter year: ");
        int yearToCheck = scanner.nextInt();
        boolean endsWithYear = productCodeParser.endsWithYear(code, yearToCheck);
        System.out.println("Ends with year: " + yearToCheck + "->" + (endsWithYear ? "Yes" : "No"));

        String modifiedCode = productCodeParser.replaceHyphen(code);
        System.out.println("Modified Code: " + modifiedCode);

        int position = productCodeParser.firstHyphenPosition(code);
        System.out.println("First hyphen position: " + position);

        scanner.close();

    }
}
