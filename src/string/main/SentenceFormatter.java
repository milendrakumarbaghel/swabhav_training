package string.main;

public class SentenceFormatter {
    public String trimSentence(String sentence) {
        return sentence.trim();
    }

    public String toLowerCase(String sentence) {
        return sentence.toLowerCase();
    }

    public String capitalizeFirstLetter(String sentence) {
        char first = Character.toUpperCase(sentence.charAt(0));
        return first + sentence.substring(1);
    }

    public String customeReplace(String sentence, String target, String replacement) {
        return sentence.replace(target, replacement);
    }

    public String[] getWords(String sentence) {
        return sentence.split(" ");
    }

    public int countWords(String sentence) {
        String[] words = sentence.split(" ");
        return words.length;
    }

    public String getFirstWord(String sentence) {
        String[] words = sentence.split(" ");
        return words[0];
    }

    public String getLastWord(String sentence) {
        String[] words = sentence.split(" ");
        return words[words.length - 1];
    }
}
