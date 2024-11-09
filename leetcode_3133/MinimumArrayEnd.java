package leetcode_3133;

class MinimumArrayEnd{
    public long minEnd(int n, int x) {
        // BitMasking

        // This will be the result that gets modified.
        long res = x; 
        // This variable will be used to track the bits of n that need to be incorporated into res.
        long remaining = n - 1;
        // This variable will be used to check individual bits starting from rightmost bit / least significant bit.
        long position = 1;

        // The loop continues until all bits of remaining have been processed.
        while (remaining != 0)
        {
            // If the current bit of x is 0
            if((x & position) == 0)
            {
                // (remaining & 1) takes the last bit of remaining / least significant bit of remaining
                // (remaining & 1) * position will shift the bit to correct posiition 
                // res |= ... will sets this bit in res
                res |= (remaining & 1) * position;
                // remaining >>= 1 will remove the last bit of remaining
                // shifts remaining right by one bit, to discard the bit that was just processed.
                remaining >>= 1;
            }
            // position is shifted left by one bit to check the next bit of x.
            position <<= 1;
        }
        return res;
    }

    public static void main(String[] args) {
        MinimumArrayEnd obj = new MinimumArrayEnd();
        System.out.println(obj.minEnd(3, 4));
    }
}