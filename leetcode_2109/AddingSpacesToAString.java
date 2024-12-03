class AddingSpacesToAString{
    public String addSpaces(String s, int[] spaces) {
        // StringBuilder Approach
        StringBuilder res = new StringBuilder(s.length() + spaces.length);
        int spaceIndex = 0;
        int spaceCount = spaces.length;
        for(int i = 0; i<s.length(); i++)
        {
            if(spaceIndex < spaceCount && spaces[spaceIndex] == i)
            {
                res.append(' ');
                spaceIndex++;
            }
            res.append(s.charAt(i));       
        }
        return res.toString();


        // Character Array Approach
        // char[] charRes = new char[s.length() + spaces.length];
        // int resIndex = 0;
        // spaceIndex = 0;
        // spaceCount = spaces.length;
        // for(int i = 0; i<s.length(); i++)
        // {
        //     if(spaceIndex < spaceCount && spaces[spaceIndex] == i)
        //     {
        //         charRes[resIndex++] = ' ';
        //         spaceIndex++;
        //     }
        //     charRes[resIndex++] = s.charAt(i);       
        // }
        // return new String(charRes);

    }

    public static void main(String[] args) {
        AddingSpacesToAString obj = new AddingSpacesToAString();
        String s = "LeetcodeHelpsMeLearn";
        int[] spaces = {8, 13, 15};
        System.out.println(obj.addSpaces(s, spaces));
    }
}