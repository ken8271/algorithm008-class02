//子问题
//状态定义
//DP方程：dp[i] = dp[i] + dp[i+1]
class Solution {
    public int numDecodings(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }
        
        int size = s.length();
        int[] dp = new int[size + 1];
        char[] nums = s.toCharArray();

        dp[size] = 1;

        for(int i=size-1; i>=0; i--){
            if(nums[i] == '0'){
                continue;
            }

            int num = 0;
            for(int j=i; j<size && j-i <2; j++){
                num = num*10 + (nums[j] - '0');
                if(num <= 26){
                    dp[i] += dp[j+1];
                }
            }
        }

        return dp[0];
    }
}