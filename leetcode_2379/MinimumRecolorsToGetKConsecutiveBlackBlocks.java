package leetcode_2379;

class MinimumRecolorsToGetKConsecutiveBlackBlocks {
    public int minimumRecolors(String blocks, int k) {
        // Sliding Window Approach (Count White Blocks)
        int white = 0;
        int minWhite = Integer.MAX_VALUE;
        for (int i = 0; i < k; i++) {
            if (blocks.charAt(i) == 'W')
                white++;
        }
        minWhite = white;

        for (int i = k; i < blocks.length(); i++) {
            if (blocks.charAt(i - k) == 'W')
                white--;
            if (blocks.charAt(i) == 'W')
                white++;
            minWhite = Math.min(minWhite, white);
        }

        return minWhite;

        // Sliding Window Approach (Count Black Blocks)
        // int black = 0, ans = Integer.MAX_VALUE;
        // for(int i=0; i<blocks.length(); i++)
        // {
        //     if(i - k >= 0 && blocks.charAt(i - k) == 'B')
        //         black--;
        //     if(blocks.charAt(i) == 'B')
        //         black++;
        //     ans = Math.min(ans, k - black);
        // }
        
        // return ans;
    }

    public static void main(String[] args) {
        MinimumRecolorsToGetKConsecutiveBlackBlocks obj = new MinimumRecolorsToGetKConsecutiveBlackBlocks();
        String blocks = "WBBWWBBWBW";
        //WBBWWBBWBW
        int k = 7;
        System.out.println(obj.minimumRecolors(blocks, k));
    }
}