class MinimumNumberOfOperationsToMoveAllBallsToEachBox:
    def minOperations(self, boxes: str) -> list[int]:
        res = [0] * len(boxes)
        balls, moves = 0, 0
        
        for i in range(len(boxes)):
            res[i] = balls + moves
            moves = moves + balls
            balls += int(boxes[i])
            
        balls, moves = 0, 0
        for i in reversed(range(len(boxes))):
            res[i] += balls + moves
            moves = moves + balls
            balls += int(boxes[i])
        
        return res
    
def main():
    v = MinimumNumberOfOperationsToMoveAllBallsToEachBox()
    boxes = "110"
    print(v.minOperations(boxes))
    
    boxes = "001011"
    print(v.minOperations(boxes))

if __name__ == "__main__":
    main()