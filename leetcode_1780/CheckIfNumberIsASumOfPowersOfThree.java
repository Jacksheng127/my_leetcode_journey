package leetcode_1780;

class CheckIfNumberIsASumOfPowersOfThree {
    public boolean checkPowersOfThree(int n) {
        while(n > 0)
        {
            if(n % 3 == 2)
            {
                return false;
            }
            n /= 3;
        }

        return true;
    }

    public static void main(String[] args) {
        CheckIfNumberIsASumOfPowersOfThree obj = new CheckIfNumberIsASumOfPowersOfThree();
        System.out.println(obj.checkPowersOfThree(12));
    }
}