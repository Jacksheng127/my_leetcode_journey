package leetcode_1534;

class CountGoodTriplets {
    public int countGoodTriplets(int[] arr, int a, int b, int c) {
        int n = arr.length;
        int res = 0;
        int [] prefixCount = new int[1001]; // prefix counts
        // prefixCount[i] is map to count of nums <= i
        // just like the upper bound of the range

       
        for (int j = 0 ; j < n - 1; j++) {
            for (int k = j + 1; k < n; k++) {
                if(Math.abs(arr[j] - arr[k]) <= b)
                {
                    // How many values before j where abs conditions is met
                    int r = Math.min(arr[j] + a, arr[k] + c);
                    int l = Math.max(arr[j] - a, arr[k] - c);
                    l = Math.max(l, 0);
                    r = Math.min(r, 1000);

                    if(l <= r)
                        res += (prefixCount[r] - (l == 0 ? 0 : prefixCount[l - 1]));
                }
            }
            for(int i=arr[j]; i < 1001; i++)
                prefixCount[i]++;
        }

        return res;
    }

    public static void main(String[] args) {
        CountGoodTriplets solution = new CountGoodTriplets();
        int[] arr = {3,0,1,1,9,7};
        int a = 7;
        int b = 2;
        int c = 3;
        int result = solution.countGoodTriplets(arr, a, b, c);
        System.out.println(result); // Output: 10
    }
}