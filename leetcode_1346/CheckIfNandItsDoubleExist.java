package leetcode_1346;

import java.util.HashSet;
import java.util.Set;

class CheckIfNandItsDoubleExist{
    public boolean checkIfExist(int[] arr) {
       Set<Integer> set = new HashSet<>();
       for(int num : arr)
       {
            if(set.contains(num * 2) || (num % 2 == 0 && set.contains(num / 2)))
                return true;
            set.add(num);
       }
       return false;
    }

    public static void main(String[] args) {
        CheckIfNandItsDoubleExist obj = new CheckIfNandItsDoubleExist();
        int[] arr = {10, 2, 5, 3};
        System.out.println(obj.checkIfExist(arr));
    }
}