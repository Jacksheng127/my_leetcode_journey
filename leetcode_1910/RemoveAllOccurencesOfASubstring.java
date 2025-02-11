package leetcode_1910;

class RemoveAllOccurencesOfASubstring {
    public String removeOccurrences(String s, String part) {
        // Approach 1: Using stack behavior
        StringBuilder stack = new StringBuilder();
        for (char c : s.toCharArray()) 
        {
            stack.append(c);
            if (stack.length() >= part.length() && stack.substring(stack.length() - part.length()).equals(part)) 
            {
                stack.delete(stack.length() - part.length(), stack.length());
            }
        }
        return stack.toString();

        // Approach 2: Using indexOf
        // StringBuilder res = new StringBuilder();
        // for(char c : s.toCharArray())
        // {
        //     res.append(c);
        //     int index;
        //     while((index = res.indexOf(part)) != -1)
        //     {
        //         res.delete(index, index + part.length());
        //     }
        // }
        // return res.toString();
    }

    public static void main(String[] args) {
        RemoveAllOccurencesOfASubstring raos = new RemoveAllOccurencesOfASubstring();
        System.out.println(raos.removeOccurrences("daabcbaabcbc", "abc"));
        System.out.println(raos.removeOccurrences("axxxxyyyyb", "xy"));
    }
}