class Solution {
    
    int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    
    public boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j] == word.charAt(0) && dfs(word, board, visited, i, j, 0))
                    return true;
            }
        }
        return false;
    }
    
    boolean dfs(String word, char[][] board, boolean[][] visited, int i, int j, int cur) {
        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length || visited[i][j] || board[i][j] != word.charAt(cur))
            return false;
        if(cur == word.length() - 1 && board[i][j] == word.charAt(cur)){
            // for(int[] e : lst)
            //     System.out.println(Arrays.toString(e));
            // System.out.println(i + " : " + j);
            return true;
        }
        visited[i][j] = true;
        for(int[] d : dirs){
            int ni = i + d[0];
            int nj = j + d[1];
            if(dfs(word, board, visited, ni, nj, cur + 1))
                return true;
        }
        visited[i][j] = false;
        return false;
    }
}