class Solution {
    int[] dx = new int[]{0,1,1,1,0,-1,-1,-1};
    int[] dy = new int[]{1,1,0,-1,-1,-1,0,1};

    public char[][] updateBoard(char[][] board, int[] click) {
        int n = board.length;

        if(n == 0){
            return board;
        }

        int m = board[0].length;

        dfs(board, click[0], click[1], n, m);

        return board;
    }

    public void dfs(char[][] board, int x,int y, int n, int m){
        if(x < 0 || y < 0 || x >= n || y >= m){
            return ;
        }

        if(board[x][y] == 'E'){
            board[x][y] = 'B';

            int count = judge(board, x, y, n, m);

            if(count > 0){
                board[x][y] = (char)(count + '0');
            } else {
                for(int i=0; i<8; i++){
                    dfs(board, x+dx[i], y+dy[i], n, m);
                }
            }
        } else if(board[x][y] == 'M'){
            board[x][y] = 'X';
        }

    }

    private int judge(char[][] board, int x, int y ,int n, int m){
        int count = 0;

        for(int i=0; i<8; i++){
            int newX = x + dx[i];
            int newY = y + dy[i];

            if(newX < 0 || newX >= n || newY < 0 || newY >= m){
                continue ;
            }

            if(board[newX][newY] == 'M'){
                count++;
            }
        }

        return count;
    }
}