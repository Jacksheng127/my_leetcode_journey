package leetcode_921;

class MinimumAddToMakeParenthesesValid {
    public int minAddToMakeValid(String s) {
        int leftCount = 0;
        int rightCount = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                leftCount++;
            } else if (leftCount > 0) {
                leftCount--;
            } else {
                rightCount++;
            }
        }
        return leftCount + rightCount;
    }

    public static void main(String[] args) {
        MinimumAddToMakeParenthesesValid obj = new MinimumAddToMakeParenthesesValid();
        System.out.println(obj.minAddToMakeValid("())"));
        System.out.println(obj.minAddToMakeValid("((("));
    }
}