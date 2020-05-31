//子问题
//状态定义
//DP方程：dp[i][j] = min(dp[i-1][j],dp[i-1][j-1],dp[i][j-1])
class Solution {
    public int maximalSquare(char[][] matrix) {
        if(matrix == null){
            return 0;
        }

        int n = matrix.length;

        if(n == 0){
            return 0;
        }

        int m = matrix[0].length;

        int[][] dp = new int[n][m];

        int maxSquare = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(matrix[i][j] == '1'){
                    if(i == 0 || j == 0){
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                    }
                }

                maxSquare = Math.max(maxSquare, dp[i][j] * dp[i][j]); 
            }
        }

        return maxSquare;
    }
}