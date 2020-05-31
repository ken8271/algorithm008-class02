//子问题：sum(i,j) = grid[i,j] + min(sum(i,j+1), sum(i+1, j))
//状态定义
//DP方程：
class Solution {
    public int minPathSum(int[][] grid) {
        if(grid == null || grid.length == 0){
            return 0;
        }

        int n = grid.length;
        int m = grid[0].length;

        int[][] dp = new int[n][m];

        for(int i=n-1; i>=0; i--){
            for(int j=m-1; j>=0; j--){
                if(i==n-1 && j != m-1){
                    dp[i][j] = grid[i][j] + dp[i][j+1];
                } else if(i != n-1 && j == m-1){
                    dp[i][j] = grid[i][j] + dp[i+1][j];
                } else if(i != n-1 && j != m-1){
                    dp[i][j] = grid[i][j] + Math.min(dp[i][j+1], dp[i+1][j]);
                } else {
                    dp[i][j] = grid[i][j];
                }
            }
        }

        return dp[0][0];
        
    }
}