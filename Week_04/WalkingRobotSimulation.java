class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        if(commands == null){
            return 0;
        }

        int[] dx = new int[]{0, 1, 0, -1};
        int[] dy = new int[]{1, 0, -1, 0};

        Set<Long> obstacleSet = new HashSet();
        if(obstacles != null){
            for(int[] obstacle : obstacles){
                long ox = (long) obstacle[0] + 30000;
                long oy = (long) obstacle[1] + 30000;
                obstacleSet.add((ox << 16) + oy);
            }
        }
        
        int di = 0;
        int x = 0;
        int y = 0;
        int ans = 0;
        for(int cmd : commands){
            if(cmd == -2){
                di = (di + 3)%4;
            } else if(cmd == -1){
                di = (di + 1)%4;
            } else {
                for(int i=0; i<cmd; i++){
                    int nx = x + dx[di];
                    int ny = y + dy[di];
                    long code = (((long) nx + 30000) << 16) + ((long) ny + 30000);

                    if(!obstacleSet.contains(code)){
                        x = nx;
                        y = ny;
                        ans = Math.max(ans, x*x + y*y);
                    }
                }
            }
        }

        return ans;
    }
}