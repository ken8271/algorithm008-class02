class Solution {

    public int find(int[] parent, int i){
        if(parent[i] == -1){
            return i;
        }

        return find(parent, parent[i]);
    }

    public void union(int[] parent, int x, int y){
        int xset = find(parent, x);
        int yset = find(parent, y);

        if(xset != yset){
            parent[xset] = yset;
        }
    }

    public int findCircleNum(int[][] stus) {
        if(stus == null){
            return 0;
        }

        int[] parent = new int[stus.length];

        Arrays.fill(parent, -1);

        int xSize = stus.length;
        int ySize = stus[0].length;
        for(int i=0; i<xSize; i++){
            for(int j=0; j<ySize; j++){
                if(stus[i][j] == 1 && i != j){
                    union(parent, i, j);
                }
            }
        }

        int count = 0;
        for(int i=0; i<xSize; i++){
            if(parent[i] == -1){
                count++;
            }
        }

        return count;
    }
}