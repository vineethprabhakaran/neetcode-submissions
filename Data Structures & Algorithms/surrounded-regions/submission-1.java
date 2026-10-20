class Solution {
    public void solve(char[][] board) {
        int row = board.length;
        int col = board[0].length;
        for(int i = 0; i < col; i++){
            if(board[0][i] == 'O'){
                capture(board, 0, i);
            }
            if(board[row-1][i] == 'O'){
                capture(board, row-1, i);
            }
        }

        for(int i = 0; i < row ; i++){
            if(board[i][0] == 'O'){
                capture(board, i, 0);
            }
            if(board[i][col-1] =='O'){
                capture(board, i, col-1);
            }
        }

        for(int i = 0; i < row; i++){
            for(int j = 0; j < col ; j++){
                if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
                if(board[i][j] == 'T'){
                    board[i][j] = 'O';
                }
            }
        }
    }

    public void capture(char[][] board, int r, int c){
        if( r < 0 || c < 0 || r >= board.length || c >= board[0].length || board[r][c] != 'O' ){
            return;
        }
        board[r][c] = 'T';
        capture(board, r + 1, c);
        capture(board, r - 1, c);
        capture(board, r, c + 1);
        capture(board, r, c - 1);
    }
}
