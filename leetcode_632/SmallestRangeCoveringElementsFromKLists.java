package leetcode_632;

import java.util.List;
import java.util.PriorityQueue;

class SmallestRangeCoveringElementsFromKLists {
    public int[] smallestRange(List<List<Integer>> nums)
    {
        // Min-Heap: stores (value, list index, element index)
        PriorityQueue<int[]> minHeap = new PriorityQueue<int[]>((a,b) -> a[0] - b[0]);
        int curMax = Integer.MIN_VALUE;

        // Initialize the heap with the first element of each list
        for (int i=0; i<nums.size(); i++)
        {
            minHeap.offer(new int[]{nums.get(i).get(0), i, 0});
            curMax = Math.max(curMax, nums.get(i).get(0));
        }

        // Track the smallest range
        int[] smallRange = new int[]{0, Integer.MAX_VALUE};

        while(true){
            // Get the minimum element from the heap
            int[] curr = minHeap.poll();
            int curMin = curr[0], listIdx = curr[1], elemIdx = curr[2];

            // Update the smallest range if a better one is found
            if ((curMax - curMin < smallRange[1] - smallRange[0]) ||
                (curMax - curMin == smallRange[1] - smallRange[0] && curMin < smallRange[0]))
            {
                smallRange[0] = curMin;
                smallRange[1] = curMax;
            }

            // Move to the next element in the same list
            if (elemIdx + 1 < nums.get(listIdx).size())
            {
                int nextVal = nums.get(listIdx).get(elemIdx + 1);
                minHeap.offer(new int[]{nextVal, listIdx, elemIdx + 1});
                curMax = Math.max(curMax, nextVal);
            }
            // If any list is exhausted, stop
            else 
                break;
        }
        return smallRange;
    }

    public static void main(String[] args) {
        SmallestRangeCoveringElementsFromKLists s = new SmallestRangeCoveringElementsFromKLists();
        List<List<Integer>> nums = List.of(
            List.of(4,10,15,24,26),
            List.of(0,9,12,20),
            List.of(5,18,22,30)
        );
        int[] result = s.smallestRange(nums);
        System.out.println("[" + result[0] + ", " + result[1] + "]");
    }
}