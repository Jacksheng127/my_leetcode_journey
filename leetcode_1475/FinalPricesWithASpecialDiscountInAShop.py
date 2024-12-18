class FinalPricesWithASpecialDiscountInAShop:
    def finalPrices(self, prices: list[int]) -> list[int]:
        res = [p for p in prices]
        
        stack = [] # store the index of prices, values are in increasing order
        
        for i in range(len(prices)):
            while stack and prices[stack[-1]] >= prices[i]:
                index = stack.pop()
                res[index] -= prices[i]
            stack.append(i)
        
        return res

def main():
    finalPricesWithASpecialDiscountInAShop = FinalPricesWithASpecialDiscountInAShop()
    print(finalPricesWithASpecialDiscountInAShop.finalPrices([8,4,6,2,3])) # [4,2,4,2,3]
   
if __name__ == "__main__":
    main()