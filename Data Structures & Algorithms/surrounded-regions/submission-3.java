class Solution {
    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        for (int r = 0; r < n; r++) {
            if (board[r][0] == 'O') {
                dfs(board, r, 0);
            }
            if (board[r][m - 1] == 'O') {
                dfs(board, r, m - 1);
            }
        }
        for (int c = 0; c < m; c++) {
            if (board[0][c] == 'O') {
                dfs(board, 0, c);
            }
            if (board[n - 1][c] == 'O') {
                dfs(board, n - 1, c);
            }
        }
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < m; c++) {
                if (board[r][c] == 'O') {
                    board[r][c] = 'X';
                }
                if (board[r][c] == '#') {
                    board[r][c] = 'O';
                }
            }
        }
    }
    public static void dfs(char[][] board, int r, int c) {
        int n = board.length;
        int m = board[0].length;

        if (c < 0 || r < 0 || c >= m | r >= n) {
            return;
        }
        if (board[r][c] != 'O') {
            return;
        }
        board[r][c] = '#';
        dfs(board, r - 1, c);
        dfs(board, r + 1, c);
        dfs(board, r, c - 1);
        dfs(board, r, c + 1);
    }
}