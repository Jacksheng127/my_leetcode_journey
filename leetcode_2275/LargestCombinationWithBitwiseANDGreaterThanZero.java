class LargestCombinationWithBitwiseANDGreaterThanZero{
    public int largestCombination(int[] candidates) {
        int res = 0;
        for (int i=0; i<32; i++)
        {
            int count = 0;
            for(int candidate: candidates)
            {
                if((candidate & (1<<i)) != 0)
                {
                    count++;
                }
            }
            res = Math.max(res, count);
        }
        return res;
    }

    public static void main(String[] args) {
        LargestCombinationWithBitwiseANDGreaterThanZero obj = new LargestCombinationWithBitwiseANDGreaterThanZero();
        int[] candidates = {16,17,71,62,12,24,14};
        System.out.println(obj.largestCombination(candidates));
    }
}