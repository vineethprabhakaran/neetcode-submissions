class Solution {
    public static int[][] directions = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public int orangesRotting(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int fresh  = 0;
        Queue<int[]> q = new LinkedList<>();
        for(int r = 0; r < row; r++){
            for(int c = 0; c < col; c++){
                if(grid[r][c] == 2){
                    q.add(new int[]{r, c, 0});
                }
                if(grid[r][c] == 1){
                    fresh++;
                }
            }
        }
        return bfs(grid, q, fresh);
    }

    public int bfs(int[][] grid, Queue<int[]> q, int fresh){
        int minutes = 0;
        while(!q.isEmpty()){
            int[] node = q.poll();
            int row = node[0];
            int col = node[1];
            minutes = Math.max(minutes, node[2]);
            for(int[] dir : directions){
                int nr = row + dir[0];
                int nc = col + dir[1];
                if(nr >= 0 && nc >= 0 && nr < grid.length && 
                nc < grid[0].length && grid[nr][nc] == 1){
                    q.add(new int[]{nr, nc, node[2] + 1});
                    grid[nr][nc] = 2;
                    fresh--;
                }
            }
        }
        return fresh == 0 ? minutes : -1;
    }
}
