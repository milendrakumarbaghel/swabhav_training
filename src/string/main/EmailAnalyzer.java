package string.main;

public class EmailAnalyzer {
    public String trimEmail(String email) {
        return email.trim();
    }

    public boolean containsAtSymbol(String email) {
        return email.contains("@");
    }

    public String getUsername(String email) {
        int index = email.indexOf("@");
        return email.substring(0, index);
    }

    public String getDomain(String email) {
        int index = email.indexOf("@");
        return email.substring(index + 1);
    }

    public boolean isGmail(String domain) {
        return domain.equalsIgnoreCase("gmail.com");
    }

    public String convertToLowerCase(String email) {
        return email.toLowerCase();
    }

    public int usernameLength(String username) {
        return username.length();
    }

    public boolean containsDigit(String username) {
        for (char c : username.toCharArray()) {
            if (Character.isDigit(c)) {
                return true;
            }
        }

        return false;
    }

    public String replaceDots(String username) {
        return username.replace('.', '_');
    }
}
