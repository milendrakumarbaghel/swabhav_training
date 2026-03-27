package streamAPI.toArrayQuestions;

import java.util.Arrays;
import java.util.List;

public class Q2 {
    static void main() {
        int[] arr = {1, 2, 3, 4, 5};
        int sum = Arrays.stream(arr).sum();

        System.out.println(sum);
    }
}
