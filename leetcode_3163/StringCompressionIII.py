class StringCompressionIII:
    def compressedString(self, word: str) -> str:
        res = ""
        count = 1
        # we add the first character to the result
        ch = word[0]
        
        # we iterate through the word and count the number of times a character appears 
        for i in range(1, len(word)):
            # if the character is the same as the previous one and its count is less then 9
            # then we increment the count 
            if word[i] == ch and count < 9:
                count += 1
            # if the character is different from the previous one 
            # then we add its count and the previous character to the result
            # and reset the count to 1
            # and update the character to the current character
            else:
                res += str(count) + ch
                count = 1
                ch = word[i]
                
        # we add the last character and its count to the result
        # this is because the loop above will not add the last character
        res += str(count) + ch
        return res

def main():
    word1 = "abcde"
    word2 = "aaaaaaaaaaaaaabb"
    sc = StringCompressionIII()
    print(sc.compressedString(word1))
    print(sc.compressedString(word2))

if __name__ == "__main__":
    main()