# class MinimumAddToMakeParenthesesValid:
#     def min_add_to_make_valid(self, s: str) -> int:
#         leftCount, rightCount = 0, 0
#         for c in s:
#             if c == '(':
#                 leftCount += 1
#             elif leftCount > 0:
#                 leftCount -= 1
#             else:
#                 rightCount += 1
#         return leftCount + rightCount


# def main():
#     main_instance = MinimumAddToMakeParenthesesValid()
#     print(main_instance.min_add_to_make_valid("())"))
#     print(main_instance.min_add_to_make_valid("((("))


# if __name__ == "__main__":
#     main()



# z = set('abc')
# z.add('san')
# z.update(set(['p', 'q']))
# print(z)
    

print(any([2>8, 4>2, 1>2]))

# name = "snow storm"
# print(name[2:7:2])

# def add(i, values = []):
#     values.append(i)
#     return values
# add(1)
# add(2)
# add(3)
# print(add(4))

# m=[1,2,3]
# tupl=('Python',)*(m.__len__() - m[::-1][0])
# print(tupl)
