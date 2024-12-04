package leetcode_2825;

class MakeStringASubsequenceUsingCyclicIncrements{
    public boolean canMakeSubsequence(String str1, String str2) {
        int targetIdx = 0, targetLen = str2.length();

        for(char curChar : str1.toCharArray())
        {
            if(targetIdx < targetLen && (str2.charAt(targetIdx) - curChar + 26) % 26 <= 1)
            {
                targetIdx++;
            }
        }
        return targetIdx == targetLen;
    }

    public static void main(String[] args) {
        MakeStringASubsequenceUsingCyclicIncrements obj = new MakeStringASubsequenceUsingCyclicIncrements();
        String str1 = "abc";
        String str2 = "ad";
        System.out.println(obj.canMakeSubsequence(str1, str2));
    }
}