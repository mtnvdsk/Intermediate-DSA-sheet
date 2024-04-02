class Solution {
    public String[] wordBoggle(char board[][], String[] dictionary)
    {
        int rows = board.length;
        int cols = board[0].length;
        ArrayList < String > ans = new ArrayList<>();
        
        for (String str: dictionary) {
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    if (board[i][j] == str.charAt(0) && dfs(i, j, board, str, 0)) ans.add(str);
                }
            }
        }

        Set <String> unique = new LinkedHashSet <>(ans); 
        return unique.toArray(new String[0]);
    }

    public boolean dfs(int i, int j, char[][] board, String str, int count) {
        if (count == str.length()) return true;
        
        boolean outside = i < 0 || i >= board.length || j < 0 || j >= board[0].length;
        if (outside || board[i][j] != str.charAt(count))  return false;
        
        int[][] directions = {{1, 0}, {0, 1}, {-1, 0}, {0, -1},
        {1, 1}, {-1, -1}, {1, -1}, {-1, 1}};
        
        char currChar = board[i][j];
        board[i][j] = '*';
        
        boolean result = false;
        for (int[] dir: directions) {
            int ii = i + dir[0];
            int jj = j + dir[1];
            
            if (dfs(ii, jj, board, str, count + 1)) {
                result = true;
                break;
            }
        }
        board[i][j] = currChar;
        return result;
    }
}