class MinimumNumberOfChangesToMakeBinaryStringBeautiful:
    '''
        We group the input string as pair of 2 characters,
        then we utilise 1 pointer, if the current character is the different from the next character,
        we increase the result by 1. (we required to change the string to make it beautiful)
    '''
    def minChanges(self, s: str) -> int:
        res = 0
        for i in range(0, len(s), 2):
            if s[i] != s[i+1]:
                res += 1
        return res

def main():
    s = "1001"
    mnc = MinimumNumberOfChangesToMakeBinaryStringBeautiful()
    print(mnc.minChanges(s))

if __name__ == "__main__":
    main()