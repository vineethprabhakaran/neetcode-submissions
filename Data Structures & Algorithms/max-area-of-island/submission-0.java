class Solution {
    public static int[][] directions = new int[][] {{1,0},{-1,0},{0,1},{0,-1}};
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        int area = 0;
        int row = grid.length;
        int col = grid[0].length;
        for(int r = 0; r < row; r++){
            for(int c= 0; c < col; c++){
                if(grid[r][c] == 1){
                    area = bfs(grid, r, c);
                    maxArea = Math.max(maxArea, area);
                }
            }
        }
        return maxArea;
    }

    public int bfs(int[][] grid, int r, int c){
        int area = 1;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{r, c});
        grid[r][c] = 0;

        while(!queue.isEmpty()){
            int[] node = queue.poll();
            int row = node[0];
            int col = node[1];
            for(int[] dir : directions){
                int nr = row + dir[0];
                int nc = col + dir[1];
                if(nc >=0 && nr >= 0 && nr < grid.length && nc < grid[0].length && 
                grid[nr][nc] == 1){
                    queue.add(new int[] { nr, nc});
                    grid[nr][nc] = 0;
                    area++;
                }
            }
        }
        return area;
    }


}
