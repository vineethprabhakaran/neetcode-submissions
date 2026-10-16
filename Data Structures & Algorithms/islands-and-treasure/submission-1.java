class Solution {
    public static int[][] directions = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
    public void islandsAndTreasure(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        Queue<int[]> q = new LinkedList<>();

        for(int r = 0; r < row; r++){
            for(int c = 0; c < col; c++){
                if(grid[r][c] == 0){
                    q.add(new int[]{r,c});
                }
            }
        }
        bfs(grid, q);
    }

    public void bfs(int[][] grid, Queue<int[]> q){
    
        while(!q.isEmpty()){
            int[] node = q.poll();
            int row = node[0];
            int col = node[1];
            for(int[] dir : directions){
                int nr = row + dir[0];
                int nc = col + dir[1];
                if(nr >=0 && nc >=0 && nr < grid.length && nc < grid[0].length && 
                grid[nr][nc] == 2147483647){
                    q.add(new int[]{nr, nc});
                    grid[nr][nc] =  grid[row][col] + 1;
                }
            }
        }
    }


}
