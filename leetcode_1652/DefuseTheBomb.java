package leetcode_1652;

class DefuseTheBomb{
    public int[] decrypt(int[] code, int k) {
        // Sliding window approach
        int n = code.length;
        int [] res = new int[n];

        // If k == 0, all elements become 0
        if(k == 0)
            return res;
        
        int sum = 0;
        int start, end;

        // Determine the range for the sliding window based on k
        if(k > 0)
        {
            start = 1; // Window starts from after current element
            end = k; // Window ends k elements ahead
        }
        else
        {
            start = n + k; // For negative k, window wraps around backward
            end = n - 1;
        }

        // Initialize the sum for the first window
        for (int i=start; i<=end; i++)
            sum += code[i % n];
        
        // Slide the window across the array
        for(int i=0; i<n; i++)
        {
            // Assign the current sum to result
            res[i] = sum;
            // Remove the element that is sliding out and move the start of the window
            sum -= code[(start++) % n];
            // Move the end of the window and add the element sliding in
            sum += code[(++end) % n];
        }
        return res;
    }

    public static void main(String[] args) {
        DefuseTheBomb obj = new DefuseTheBomb();
        int [] code = {5,7,1,4};
        int k = 3;
        int [] res = obj.decrypt(code, k);
        for(int i=0; i<res.length; i++)
            System.out.print(res[i] + " ");
    }
}