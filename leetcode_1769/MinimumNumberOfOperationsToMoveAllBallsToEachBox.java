package leetcode_1769;

class MinimumNumberOfOperationsToMoveAllBallsToEachBox{
    public int[] minOperations(String boxes) {
        int n = boxes.length();
        int [] res = new int[n];
        int balls = 0, moves = 0;

        for(int i=0; i<n; i++)
        {
            res[i] = balls + moves;
            moves = balls + moves;
            balls += boxes.charAt(i) - '0';
        }

        balls = 0; 
        moves = 0;
        for(int i=n-1; i>=0; i--)
        {
            res[i] += balls + moves;
            moves = balls + moves;
            balls += boxes.charAt(i) - '0';
        }

        return res;
    }

    public static void main(String[] args) {
        MinimumNumberOfOperationsToMoveAllBallsToEachBox obj = new MinimumNumberOfOperationsToMoveAllBallsToEachBox();
        String boxes = "110";
        int [] res = obj.minOperations(boxes);
        for(int i=0; i<res.length; i++)
        {
            System.out.print(res[i] + " ");
        }
    }
}