class circularSentence:
    def isCircularSentence(self, sentence: str) -> bool:
        # # Spliting method 
        # words = sentence.split(" ")
        
        # # This method works because it wont have an index out of range error
        # for i in range(len(words)):
        #     # current words at index i of the first letter is not equal to the previous word's last letter
        #     if words[i][0] != words[i-1][-1]: 
        #         return False
        # return True
        
        # One liner method
        for i in range(len(sentence)):
            if sentence[i] == " " and sentence[i-1] != sentence[i+1]:
                return False
        # Check if the first and last letter of the sentence are the same
        return sentence[0] == sentence[-1]

def main():
    sentence = "leetcode exercises sound delightful"
    obj = circularSentence()
    print(obj.isCircularSentence(sentence))

if __name__ == "__main__":
    main()
