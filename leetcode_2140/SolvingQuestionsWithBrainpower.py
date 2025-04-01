class SolvingQuestionsWithBrainpower:
    def mostPoints(self, questions: list[list[int]]) -> int:
        n = len(questions)
        cache = [0] * (n)
        
        # Bottom-up DP approach
        for i in reversed(range(n)):
            points, brainpowers = questions[i]
            next_index = i + 1 + brainpowers 
            choose = points + (cache[next_index] if next_index < n else 0)
            skip = (cache[i + 1] if i + 1 < n else 0)
            cache[i] = max(choose, skip)

        return cache[0]
        
        # Memoization approach
        # def backtracking(i):
        #     if i >= n: return 0
        #     if cache[i]: return cache[i]
            
        #     points, brainpowers = questions[i]
        #     cache[i] = max(
        #         backtracking(i + 1), # skip the current question
        #         points + backtracking(i + 1 + brainpowers) # solve the current question
        #     )
        #     return cache[i]
        # return backtracking(0)
    
def main():
    questions = [[3, 2], [4, 3], [4, 4], [2, 5]]
    solver = SolvingQuestionsWithBrainpower()
    result = solver.mostPoints(questions)
    print(result)  # Output: 5
    
if __name__ == "__main__":
    main()