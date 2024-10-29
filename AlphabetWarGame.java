public class AlphabetWarGame {
    public static void main(String[] args) {
        String leftWord = "wwwwwwz";
        String rightWord = "zdqmwpbs";

        // Strength mappings
        String leftStrengths = "w4p3b2s1";
        String rightStrengths = "m4q3d2z1";

        // Calculate scores
        int leftScore = calculateScore(leftWord, leftStrengths);
        int rightScore = calculateScore(rightWord, rightStrengths);

        // Determine the winner
        if (leftScore > rightScore) {
            System.out.println("Left side wins!");
        } else if (leftScore < rightScore) {
            System.out.println("Right side wins!");
        } else {
            System.out.println("Let's fight again!");
        }
    }

    private static int calculateScore(String word, String strengths) {
        int score = 0;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            // Look up the strength value in the strengths string
            int index = strengths.indexOf(c);
            if (index != -1 && index % 2 == 0) { // Ensure it's a valid character and points to strength
                int strength = strengths.charAt(index + 1) - '0';
                score += strength;
            }
        }
        return score;
    }
}
