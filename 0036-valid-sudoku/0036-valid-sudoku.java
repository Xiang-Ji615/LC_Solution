class Solution {
    public boolean isValidSudoku(char[][] board) {
        for(int i=0;i<board.length;i++){
            int[] row = new int[10];
            int[] col = new int[10];
            int[] box = new int[10];
            for(int j=0;j<board[0].length;j++){
                if(board[i][j] != '.'){
                    row[board[i][j] - '0']++;
                    if(row[board[i][j] - '0'] > 1)
                        return false;
                }
                if(board[j][i] != '.'){
                    col[board[j][i] - '0']++;
                    if(col[board[j][i] - '0'] > 1)
                        return false;
                }
                int rowIdx = (i/3)*3;
                int colIdx = (i%3)*3;
                if (board[rowIdx + j / 3][colIdx + j % 3] != '.') {
				    box[board[rowIdx + j / 3][colIdx + j % 3] - '0']++;
				    if (box[board[rowIdx + j / 3][colIdx + j % 3] - '0'] > 1)
					    return false;
                }
            }
        }
        return true;
    }
}