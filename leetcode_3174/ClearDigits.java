class ClearDigits {
    public String clearDigits(String s) {
        StringBuilder stack = new StringBuilder();
        for (char c : s.toCharArray()) 
        {
            if (Character.isDigit(c) && stack.length() > 0) 
            {
                stack.deleteCharAt(stack.length() - 1);
            }
            else
                stack.append(c);
        }
        return stack.toString();
    }

    public static void main(String[] args) {
        ClearDigits cd = new ClearDigits();
        System.out.println(cd.clearDigits("ab23c"));
        System.out.println(cd.clearDigits("a1b2c3"));
        System.out.println(cd.clearDigits("abc"));
    }
}