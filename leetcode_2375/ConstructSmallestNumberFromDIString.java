package leetcode_2375;

import java.util.Stack;

class ConstructSmallestNumberFromDIString{
    // Approach 1: Stack
    public String smallestNumber(String pattern) {
        StringBuilder res = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        int num = 1;

        for(char c : pattern.toCharArray())
        {
            stack.push(num++);
            if(c == 'I')
            {
                while(!stack.isEmpty())
                    res.append(stack.pop());
            }
        }
        stack.push(num);
        while(!stack.isEmpty())
            res.append(stack.pop());
        
        return res.toString();
    }

    // Approach 2: Array
    // public String smallestNumber(String pattern) {
    //     StringBuilder res = new StringBuilder();
    //     int n = pattern.length();
    //     int [] nums = new int[n + 1];

    //     for(int i = 0; i <= n; i++)
    //         nums[i] = i + 1;
        
    //     int i=0;
    //     while(i < n)
    //     {
    //         if(pattern.charAt(i) == 'I')
    //         {
    //             res.append(nums[i]);
    //             i++;
    //         }
    //         else
    //         {
    //             int j = i;
    //             while(i < n && pattern.charAt(i) == 'D')
    //                 i++;
    //             for(int k = i; k >= j; k--)
    //                 res.append(nums[k]);
    //             i++;
    //         }
    //     }
    //     if(i == n)
    //         res.append(nums[n]);
        
    //     return res.toString();
    // }

    public static void main(String[] args) {
        ConstructSmallestNumberFromDIString obj = new ConstructSmallestNumberFromDIString();
        String pattern = "IIIDIDDD";
        System.out.println(obj.smallestNumber(pattern));
    }
}