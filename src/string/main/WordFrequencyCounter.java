package string.main;

public class WordFrequencyCounter {
    public void countFrequency(String sentence) {
        sentence = sentence.toLowerCase();

        String[] words = sentence.split(" ");
        boolean[] visited = new boolean[words.length];

        for (int i = 0; i < words.length; i++) {
            if (visited[i]) {
                continue;
            }

            int count = 1;

            for (int j = i + 1; j < words.length; j++) {

                if (words[i].equals(words[j])) {
                    count++;
                    visited[j] = true;
                }
            }

            System.out.println(words[i] + " : " + count);
        }
    }
}
