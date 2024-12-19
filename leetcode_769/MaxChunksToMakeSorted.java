package leetcode_769;

class MaxChunksToMakeSorted{
    public int maxChunksToSorted(int[] arr) {
        // Prefix Sum approach
        int cur_max = -1;
        int res = 0;

        for(int i = 0; i < arr.length; i++){
            cur_max = Math.max(cur_max, arr[i]);
            if(cur_max == i){
                res++;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        MaxChunksToMakeSorted m = new MaxChunksToMakeSorted();
        int[] arr = {4,3,2,1,0};
        System.out.println(m.maxChunksToSorted(arr));
    }
}