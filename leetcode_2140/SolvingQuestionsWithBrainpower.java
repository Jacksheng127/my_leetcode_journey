package leetcode_2140;

import java.util.Arrays;

class SolvingQuestionsWithBrainpower{
    public long mostPoints(int[][] questions) {
        int n = questions.length;
        long[] cache = new long[questions.length];
        Arrays.fill(cache, 0);
        
        // Memoization Approach
        // return backtracking(questions, cache, 0);

        // Bottom Up Approach / Tabulation Approach
        for(int i = n - 1; i >= 0; i--) {
            
            long points = questions[i][0];
            int brainpowers = questions[i][1];
            int nextIndex = i + 1 + brainpowers;
            // If we choose the current question
            long chooseCurrent = points + (nextIndex < n ? cache[nextIndex] : 0);
            // If we skip the current question
            long skipCurrent = (i + 1 < n ? cache[i + 1] : 0);

            cache[i] = Math.max(chooseCurrent, skipCurrent);
        }

        return cache[0];
    }

    private long backtracking(int[][] questions, long[] cache, int index) {
        if(index >= questions.length) return 0;
        if(cache[index] != 0)
            return cache[index];
        
        long points = questions[index][0];
        int brainpowers = questions[index][1];

        cache[index] = Math.max(
            backtracking(questions, cache, index + 1), // skip the current question
            points + backtracking(questions, cache, index + 1 + brainpowers) // choose the current question
        );

        return cache[index];
    }

    public static void main(String[] args) {
        SolvingQuestionsWithBrainpower obj = new SolvingQuestionsWithBrainpower();
        int[][] questions = {
            {3, 2},
            {4, 3},
            {4, 4},
            {2, 5}
        };
        long result = obj.mostPoints(questions);
        System.out.println(result); 
    }
}