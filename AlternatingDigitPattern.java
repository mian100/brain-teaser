public class AlternatingDigitPattern {

    public static void main(String[] args) {
        System.out.println(isAlternatingPattern(2745)); // true
        System.out.println(isAlternatingPattern(1234)); // false
        System.out.println(isAlternatingPattern(2947)); // true
        System.out.println(isAlternatingPattern(54321)); // false
    }

    // Main function to check alternating pattern
    public static boolean isAlternatingPattern(int n) {
        if (n < 10 || n < 100) {
            return false; // Pattern needs at least 3 digits to alternate
        }

        int prevDigit = n % 10;
        n /= 10;
        int currDigit = n % 10;
        n /= 10;

        int prevTrend = getTrend(currDigit, prevDigit); // 1 for up, -1 for down

        if (prevTrend == 0) return false;

        while (n > 0) {
            int nextDigit = n % 10;
            int currentTrend = getTrend(nextDigit, currDigit);

            if (currentTrend == 0 || currentTrend == prevTrend) {
                return false;
            }

            prevTrend = currentTrend;
            currDigit = nextDigit;
            n /= 10;
        }

        return true;
    }

    // Helper function: returns 1 if a<b (up), -1 if a>b (down), 0 if equal
    public static int getTrend(int a, int b) {
        if (a < b) return 1;
        if (a > b) return -1;
        return 0;
    }
}
