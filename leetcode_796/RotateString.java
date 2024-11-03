package leetcode_796;

class RotateStirng{
    public boolean rotateString(String s, String goal) {
        if (s.length() != goal.length()) return false;
        
        String contatenate = s + s;
        
        return contatenate.contains(goal);
    }

    public static void main(String[] args) {
        RotateStirng rs = new RotateStirng();
        String s = "abcde";
        String goal = "cdeab";
        System.out.println(rs.rotateString(s, goal));
    }
}