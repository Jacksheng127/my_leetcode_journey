package leetcode_1014;

class BestSightseeingPair {
    public int maxScoreSightseeingPair(int[] values) {
        int maxScore = 0;
        int maxI = values[0] + 0;
        // values[i] + values[j] + i - j == values[i] + i + values[j] - j

        for (int j = 1; j < values.length; j++) {
            // Calculate the score for the current pair (i, j)
            maxScore = Math.max(maxScore, maxI + values[j] - j);
            // Update max_i to be the maximum of its current value and values[j] + j
            maxI = Math.max(maxI, values[j] + j);

            // Another way to write the above two lines:
            // if(maxI + values[j] - j > maxScore)
            //     maxScore = maxI + values[j] - j;
            // if(values[j] + j > maxI)
            //     maxI = values[j] + j;
        }
        return maxScore;
    }

    public static void main(String[] args) {
        BestSightseeingPair sol = new BestSightseeingPair();
        int[] values = { 2, 2, 2 };
        System.out.println(sol.maxScoreSightseeingPair(values));
    }
}