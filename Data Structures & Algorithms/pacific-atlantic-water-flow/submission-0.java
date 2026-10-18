class Solution {
    public static int[][] directions = new int[][] {{1,0},{-1,0},{0,-1},{0,1}};
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int row = heights.length;
        int col = heights[0].length;
        boolean[][] pacific  = new boolean[row][col];
        boolean[][] atlantic = new boolean[row][col];

        for(int i = 0; i < col; i++){
            dfs(heights, 0, i, pacific);
            dfs(heights, row -1, i, atlantic);
        }
        for(int i = 0; i < row; i++){
            dfs(heights, i, 0, pacific);
            dfs(heights, i, col -1, atlantic);
        }
        List<List<Integer>> result = new ArrayList<>();

        for(int i = 0; i < row; i++){
            for(int j = 0; j < col ; j++){
                if(pacific[i][j] && atlantic[i][j]){
                    result.add(Arrays.asList(i, j));
                }
            }
        }

        return result;
    }

    public  void dfs(int[][] heights, int r, int c, boolean[][] oceans){
        oceans[r][c] = true;
        for(int[] dir : directions){
            int nr = r + dir[0];
            int nc = c + dir[1];
            if(nr >= 0 && nc >=0 && nr < heights.length && nc < heights[0].length && 
            !oceans[nr][nc] && heights[nr][nc] >= heights[r][c]){
                dfs(heights, nr, nc, oceans);
            }
        }
    }
}
