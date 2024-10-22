from collections import deque
import heapq
from typing import Optional

class TreeNode:
    def __init__(self, val=0, left: Optional['TreeNode'] = None, right: Optional['TreeNode'] = None):
        self.val = val
        self.left = left
        self.right = right

class KthLargestSumInABinaryTree:
    def kthLargestSum(self, root: TreeNode, k: int) -> int:
        q = deque([root])
        min_heap = []
        
        while q:
            level_sum = 0
            for i in range(len(q)):
                node = q.popleft()
                level_sum += node.val
                if node.left:
                    q.append(node.left)
                if node.right:
                    q.append(node.right)
            heapq.heappush(min_heap, level_sum)
            if len(min_heap) > k:
                heapq.heappop(min_heap)
        return -1 if len(min_heap) < k else min_heap[0]
        
def main():
    main_instance = KthLargestSumInABinaryTree()
    root = TreeNode(1)
    root.left = TreeNode(2)
    root.left = TreeNode(3)
    print(main_instance.kthLargestSum(root, 1))

if __name__ == "__main__":
    main()