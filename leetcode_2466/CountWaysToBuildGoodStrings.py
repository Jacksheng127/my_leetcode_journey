class CountWaysToBuildGoodStrings:
    def countGoodStrings(self, low: int, high: int, zero: int, one: int) -> int:
        # Bottom up DP Approach
        dp = {0 : 1}
        mod = 10**9 + 7
        for i in range(1, high + 1):
            dp[i] = (dp.get(i - zero, 0) + dp.get(i - one, 0)) % mod
        
        return sum([dp[i] for i in range(low, high + 1)]) % mod;
    
        # # Top down DP Approach
        # MOD = 10**9 + 7
        # dp = {}
        
        # def dfs(length):
        #     if length > high:
        #         return 0

        #     if length in dp:
        #         return dp[length] 
            
        #     dp[length] = 1 if length >= low else 0
        #     dp[length] += dfs(length + zero) + dfs(length + one)
            
        #     return dp[length] % MOD
    
        # return dfs(0)
    
def main():
    countWaysToBuildGoodStrings = CountWaysToBuildGoodStrings()
    print(countWaysToBuildGoodStrings.countGoodStrings(3, 3, 1, 1))

if __name__ == "__main__":
    main()
    
    