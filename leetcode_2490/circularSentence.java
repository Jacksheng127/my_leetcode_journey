package leetcode_2490;

class circularSentence{
    public boolean isCircularSentence(String sentence) {
        int len = sentence.length();
        for(int i=0; i<len; i++)
        {
            if(sentence.charAt(i) == ' ' && sentence.charAt(i-1) != sentence.charAt(i+1))
                return false;
        }
        return sentence.charAt(0) == sentence.charAt(len-1);
    }

    public static void main(String[] args) {
        String sentence = "leetcode exercises sound delightful";
        circularSentence obj = new circularSentence();
        System.out.println(obj.isCircularSentence(sentence));
    }
}