package leetcode_3163;


class StringCompressionIII{
    public String compressedString(String word) {
        StringBuilder res = new StringBuilder();
        int count = 1;
        // we add the first character to the result
        char ch = word.charAt(0);

        // loop through the word and count the number of the same character
        // we start from the second character as we have already added the first character to the result
        // this is because we need to compare the current character with the previous one
        for(int i = 1; i < word.length(); i++){
            // if the character is the same as the previous one, increase the count
            if(word.charAt(i) == ch && count < 9)
            {
                count++;
            }
            // if the character is different from the previous one, append the count and the character to the result
            // then reset the count to 1
            // and update the character to the current character
            else
            {
                res.append(count).append(ch);
                count = 1;
                ch = word.charAt(i);
            }
        }
        // append the last count and character to the result
        // this is because the loop above will not add the last character
        res.append(count).append(ch);

        return res.toString();
    }
    
    public static void main(String[] args) {
        StringCompressionIII sc = new StringCompressionIII();
        System.out.println(sc.compressedString("abcde"));
        System.out.println(sc.compressedString("aaaaaaaaaaaaaabb"));
    }
}