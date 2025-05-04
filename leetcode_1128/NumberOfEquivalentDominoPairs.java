package leetcode_1128;

class NumberOfEquivalentDominoPairs {
    public int numEquivDominoPairs(int[][] dominoes) {
        int[] map = new int[100];
        for(int [] d : dominoes) {
            if(d[0] > d[1])
                map[d[0] * 10 + d[1]]++;
            else
                map[d[1] * 10 + d[0]]++;
        }

        int count = 0;
        for(int freq : map)
            count += (freq * (freq - 1)) / 2;
        
        return count;
    }

    public static void main(String[] args) {
        NumberOfEquivalentDominoPairs numberOfEquivalentDominoPairs = new NumberOfEquivalentDominoPairs();
        int[][] dominoes = {{1,2},{2,1},{3,4},{5,6}};
        System.out.println(numberOfEquivalentDominoPairs.numEquivDominoPairs(dominoes)); // Output: 1
    }
}