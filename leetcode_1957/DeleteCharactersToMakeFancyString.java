package leetcode_1957;

class DeleteCharactersToMakeFancyString{
    public String makeFancyString(String s) 
    {
        StringBuilder sb = new StringBuilder();
        sb.append(s.charAt(0));
        int count = 1, n = s.length();

        for(int i=1; i<n; i++)
        {
            // If current character is same as the last one
            if(s.charAt(i) == sb.charAt(sb.length()-1))
            {
                count++;
                // If count is less than 3, add character to result
                if(count < 3)
                    sb.append(s.charAt(i));
                // If count is 3 or more, skip character
            }
            else
            {
                // Reset count to 1 for new character
                count = 1;
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "leeetcode";
        DeleteCharactersToMakeFancyString obj = new DeleteCharactersToMakeFancyString();
        System.out.println(obj.makeFancyString(s));
    }
}