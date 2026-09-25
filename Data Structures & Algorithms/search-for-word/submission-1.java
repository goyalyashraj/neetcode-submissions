class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (board[r][c] == word.charAt(0)) {
                    boolean found = dfs(board, r, c, 0, word);
                    if (found)
                        return true;
                }
            }
        }
        return false;
    }
    public boolean dfs(char[][] board, int r, int c, int index, String word) {
        int m = board.length;
        int n = board[0].length;
        if (index == word.length()) {
            return true;
        }
        if (r < 0 || c < 0 || r >= m || c >= n) {
            return false;
        }
        if (board[r][c] == ' ' || board[r][c] != word.charAt(index)) {
            return false;
        }
        char ch = board[r][c];
        board[r][c] = ' ';
        if (dfs(board, r - 1, c, index + 1, word) || dfs(board, r, c + 1, index + 1, word)
            || dfs(board, r, c - 1, index + 1, word) || dfs(board, r + 1, c, index + 1, word)) {
            return true;
        }
        board[r][c] = ch;
        return false;
    }
}
