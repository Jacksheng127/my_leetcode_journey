package leetcode_3208;

class AlternatingGroupsII {
    public int numberOfAlternatingGroups(int[] colors, int k) {
        int n = colors.length;
        int left = 0, res = 0;

        for(int right = 1; right < n + k - 1; right++)
        {
            // If the current color is the same as the previous color, we need to move the left pointer to the where the right pointer is at
            if(colors[right % n] == colors[(right - 1) % n])
                left = right;
            // If the current sliding window is greater than k, we need to move the left pointer to the right
            if(right - left + 1 > k)
                left++;
            // If the current sliding window is equal to k, then this mean we have an alternating group
            if(right - left + 1 == k)
                res++;
        }

        return res;
    }

    public static void main(String[] args) {
        AlternatingGroupsII obj = new AlternatingGroupsII();
        int[] colors = {0, 1, 0, 1, 0};
        int k = 3;
        System.out.println(obj.numberOfAlternatingGroups(colors, k));
    }
}