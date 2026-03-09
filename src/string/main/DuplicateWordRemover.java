package string.main;

public class DuplicateWordRemover {
    public String removeDuplicates(String input) {
        String[] words = input.split(" ");
        StringBuilder result = new StringBuilder(words[0]);

        for (int i = 1; i < words.length; i++) {
            if (!words[i].equals(words[i - 1])) {
                result.append(" ").append(words[i]);
            }
        }

        return result.toString();
    }
}