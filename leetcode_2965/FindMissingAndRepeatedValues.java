package leetcode_2965;

class FindMissingAndRepeatedValues {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        // Frequency Array Approach
        int n = grid.length;
        int size = n * n;
        int [] freq = new int[size + 1];
        int repeated = -1, missing = -1;

        for(int[] row : grid)
        {
            for(int num : row)
                freq[num]++;
        }

        for(int num = 1; num <= size; num++)
        {
            if(freq[num] == 0)
                missing = num;
            if(freq[num] == 2)
                repeated = num;
        }

        return new int[]{repeated, missing};

        // HashSet Approach
        // int n = grid.length;
        // int size = n * n;
        // Set<Integer> seen = new HashSet<>();
        // int repeated = -1, missing = -1;

        // for(int[] row : grid)
        // {
        //     for(int num : row)
        //     {
        //         if(!seen.add(num))
        //             repeated = num;
        //     }
        // }

        // for(int num = 1; num <= size; num++)
        // {
        //     if(!seen.contains(num))
        //         missing = num;
        // }

        // return new int[]{repeated, missing};
    }

    public static void main(String[] args) {
        FindMissingAndRepeatedValues obj = new FindMissingAndRepeatedValues();
        int[][] grid = {{1, 3}, {2, 2}};
        int[] result = obj.findMissingAndRepeatedValues(grid);
        System.out.println("Repeated: " + result[0] + ", Missing: " + result[1]);
    }
}