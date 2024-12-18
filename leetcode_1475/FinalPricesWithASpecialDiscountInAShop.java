import java.util.Stack;

class FinalPricesWithASpecialDiscountInAShop{
    public int[] finalPrices(int[] prices) 
    {
        // Monotonic stack approach
        int [] res = new int [prices.length];
        int n = prices.length;
        Stack<Integer> stack = new Stack<>();
        
        for(int i=0; i<n; i++)
            res[i] = prices[i];

        for (int i=0; i<n; i++)
        {
            while(!stack.isEmpty() && prices[stack.peek()] >= prices[i])
            {
                int index = stack.pop();
                res[index] -= prices[i];
            }
            stack.push(i);
        }

        return res;
    }

    public static void main(String[] args) {
        FinalPricesWithASpecialDiscountInAShop obj = new FinalPricesWithASpecialDiscountInAShop();
        int [] prices = {8,4,6,2,3};
        int [] res = obj.finalPrices(prices);
        for(int i=0; i<res.length; i++)
            System.out.print(res[i] + " ");
    }
}