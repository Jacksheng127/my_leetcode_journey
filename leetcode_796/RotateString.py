class RotateStirng:
    def rotateString(self, s: str, goal: str) -> bool:
        if len(s) != len(goal):
            return False
        contatenate = s + s
        return goal in contatenate

def main():
    s = "abcde"
    goal = "cdeab"
    solution = RotateStirng()
    print(solution.rotateString(s, goal))

if __name__ == "__main__":
    main()