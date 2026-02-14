package loops;

public class PrimePattern {
    public static boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        int n = 5;
        int number = 2;

        for (int i = 1; i <= n; i++) {
            int count = 0;

            for (int j = 1; count < i; number++) {
                if (isPrime(number)) {
                    System.out.print(number + " ");
                    count++;
                }
            }

            System.out.println();
        }
    }
}