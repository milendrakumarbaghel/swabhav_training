package string.main;

public class PasswordValidator {

    public boolean isLengthValid(String password) {
        return password.length() >= 8;
    }

    public boolean hasUpperCase(String password) {
        for (int i = 0; i < password.length(); i++) {
            char ch = password.charAt(i);

            if (Character.isUpperCase(ch)) {
                return true;
            }
        }
        return false;
    }

    public boolean hasLowerCase(String password) {
        for (int i = 0; i < password.length(); i++) {
            char ch = password.charAt(i);

            if (Character.isLowerCase(ch)) {
                return true;
            }
        }
        return false;
    }

    public boolean hasDigit(String password) {
        for (int i = 0; i < password.length(); i++) {
            char ch = password.charAt(i);

            if (Character.isDigit(ch)) {
                return true;
            }
        }
        return false;
    }

    public String removeSpaces(String password) {
        return password.replace(" ", "");
    }

    public boolean isValidPassword(String password) {
        if(!isLengthValid(password)) {
            System.out.println("Password Length is not valid");
            return false;
        }

        if(!hasUpperCase(password)) {
            System.out.println("Password does not contain UpperCase letter");
            return false;
        }

        if(!hasLowerCase(password)) {
            System.out.println("Password does not contain LowerCase letter");
            return false;
        }

        if(!hasDigit(password)) {
            System.out.println("Password does not contain digits");
            return false;
        }

        return true;
    }
}