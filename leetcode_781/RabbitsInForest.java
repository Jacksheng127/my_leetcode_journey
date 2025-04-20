package leetcode_781;

import java.util.HashMap;
import java.util.Map;

class RabbitsInForest {
    public int numRabbits(int[] answers) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : answers) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        int total = 0;
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int k = entry.getKey();
            int v = entry.getValue();
            int groupSize = k + 1;
            int groups = (v+k) / groupSize;
            total += groups * groupSize;
        }

        return total;
    }

    public static void main(String[] args) {
        RabbitsInForest rabbitsInForest = new RabbitsInForest();
        int[] answers = {1, 1, 2};
        System.out.println(rabbitsInForest.numRabbits(answers)); // Output: 5
    }
}