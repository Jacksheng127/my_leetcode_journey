package leetcode_2914;

/*
 * We group the input string as pair of 2 characters,
 * then we utilise 1 pointer, if the current character is the different from the next character,
 * we increase the result by 1. (we required to change the string to make it beautiful)
 */

class MinimumNumberOfChangesToMakeBinaryStringBeautiful{
    public int minChanges(String s) {
        int res = 0;
        
        for (int i = 0; i < s.length(); i+=2) {
            if (s.charAt(i) != s.charAt(i+1))
                res++;
        }
        return res;
    }
    public static void main(String[] args) {
        MinimumNumberOfChangesToMakeBinaryStringBeautiful obj = new MinimumNumberOfChangesToMakeBinaryStringBeautiful();
        System.out.println(obj.minChanges("1001"));
    }
}