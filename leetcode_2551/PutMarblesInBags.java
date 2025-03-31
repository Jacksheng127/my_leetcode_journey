package leetcode_2551;

import java.util.Arrays;

class PutMarblesInBags{
    public long putMarbles(int[] weights, int k) {
        if(k == 1) return 0;
        int n = weights.length;

        int [] splits = new int[n - 1];

        for(int i = 0; i < n - 1; i++) {
            splits[i] = weights[i] + weights[i + 1];
        }

        Arrays.sort(splits);
        int index = k - 1;
        long maxScore = 0, minScore = 0;

        for(int i = 0; i < index; i++) {
            minScore += splits[i];
        }
        
        // n - 2 because of the split.length == n -1, thus getting last index will be n - 1 - 1, n - 2 is the last index of splits[] (since splits has length n-1
        // n - 1 - index == splits.length - index, where we sum only the k - 1 largest elements.
        // Another way of writting this: for(int i=splits.length; i>=splits.length - index; i--)
        for(int i = n - 2; i >= n - 1 - index; i--) {
            maxScore += splits[i];
        }

        return maxScore - minScore;
    }

    public static void main(String[] args) {
        PutMarblesInBags obj = new PutMarblesInBags();
        int[] weights = {1, 3, 5, 1};
        int k = 2;
        long result = obj.putMarbles(weights, k);
        System.out.println(result); // Output: 4
    }
}