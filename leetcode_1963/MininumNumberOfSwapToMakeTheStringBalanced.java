package leetcode_1963;


class MininumNumerOfSwapToMakeTheStringBalanced {
    // Solution 1
    public int minSwaps(String s) {
        int count = 0;
        for (char c : s.toCharArray()) {
            if (c == '[') {
                count++;
            } else if (count > 0) {
                count--;
            }
        }
        return (count + 1) / 2;
    }

    // Solution 2
    // public int minSwaps(String s) {
    //     int openBracket = 0, count = 0;
    //     for (char c : s.toCharArray()) {
    //         if (c == '[') {
    //             openBracket--;
    //         } else {
    //             openBracket++;
    //         }
    //         count = Math.max(count, openBracket);
    //     }
    //     return (count + 1) / 2;
    // }

    public static void main(String[] args) {
        MininumNumerOfSwapToMakeTheStringBalanced m = new MininumNumerOfSwapToMakeTheStringBalanced();
        System.out.println(m.minSwaps("][]["));
    }
}