package string.test;

import string.main.FileNameValidator;

import java.util.Scanner;

public class FileNameValidatorTest  {
    static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        FileNameValidator validator = new FileNameValidator();

        System.out.print("Enter file name (eg. report_final_2024.pdf): ");
        String fileName = scanner.nextLine();

        boolean isPdf = validator.isPdf(fileName);
        String extension = validator.getExtension(fileName);

        String nameWithoutExtension = validator.getFileNameWithoutExtension(fileName);
        String modifiedName = validator.replaceUnderscore(nameWithoutExtension);

        boolean containsFinal = validator.containsFinal(modifiedName);

        System.out.println("File Name: " + modifiedName);
        System.out.println("Extension: " + extension);
        System.out.println("Convert to UpperCase: " + validator.convertUpperCase(fileName));
        System.out.println("Is PDF file: " + (isPdf ? "Yes" : "No"));
        System.out.println("Contains 'final': " + (containsFinal ? "Yes" : "No"));

        scanner.close();
    }
}
