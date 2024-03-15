import java.util.ArrayList;

public class KnightTour {
    static int[][] chessBoard = new int[8][8];

    public static void printBoard() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.print(chessBoard[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static ArrayList<int[]> getPossibilities(int x, int y) {
        int[] posX = {2, 1, 2, 1, -2, -1, -2, -1};
        int[] posY = {1, 2, -1, -2, 1, 2, -1, -2};
        ArrayList<int[]> possibilities = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            if (x + posX[i] >= 0 && x + posX[i] <= 7 && y + posY[i] >= 0 && y + posY[i] <= 7 && chessBoard[x + posX[i]][y + posY[i]] == 0) {
                possibilities.add(new int[]{x + posX[i], y + posY[i]});
            }
        }
        return possibilities;
    }

    public static void solve(int x,int y) {
        int counter = 2;
        for (int i = 1; i < 65; i++) {
            ArrayList<int[]> pos = getPossibilities(x, y);
            int[] minimum = pos.get(0);
            for (int[] p : pos) {
                if (getPossibilities(p[0], p[1]).size() <= getPossibilities(minimum[0], minimum[1]).size()) {
                    minimum = p;
                }
            }
            x = minimum[0];
            y = minimum[1];
            chessBoard[x][y] = counter;
            counter++;
        }
    }

    public static void main(String[] args) {
        solve(0,0);
        printBoard();
    }
}
