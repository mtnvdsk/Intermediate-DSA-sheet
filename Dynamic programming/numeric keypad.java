class HelloWorld {
    static int []row={0,0,-1,0,1};
    static int []col={0,-1,0,1,0};
    public static int get(String[][] a,int i,int j,int n){
        if(n<=0){
            return 0;
        }
        if(n==1) return 1;
        
        int r=0,c=0,move=0,total=0,k=0;
        for(move=0;move<5;move++){
            r=i+row[move];
            c=j+col[move];
            if(r>=0 && c>=0 && r<=3 && c<=2 && a[r][c]!="*" && a[r][c]!="#"){
                total+=get(a,r,c,n-1);
            }
        }
        return total;
    }
    public static void main(String[] args) {
        int n=5;
        int total=0;
        String[][] a={{"1","2","3"},{"4","5","6"},{"7","8","9"},{"#","0","*"}};
        for(int i=0;i<a.length;i++){
            for(int j=0;j<a[0].length;j++){
                if(a[i][j]!="#" && a[i][j]!="*"){
                    total+=get(a,i,j,n);
                }
            }
        }
        System.out.println(total);
    }
}

//dynamic programming
public class HelloWorld {
    static int[] row = {0, 0, -1, 0, 1};
    static int[] col = {0, -1, 0, 1, 0};

    public static int get(String[][] a, int i, int j, int n, int[][][] dp) {
        if (n == 0) {
            return 1; // If we visited all cells exactly n times, return 1
        }
        if (dp[i][j][n] != -1) {
            return dp[i][j][n];
        }
        int total = 0;
        for (int move = 0; move < 5; move++) {
            int r = i + row[move];
            int c = j + col[move];
            if (r >= 0 && c >= 0 && r < a.length && c < a[0].length && a[r][c] != "*" && a[r][c] != "#") {
                total += get(a, r, c, n - 1, dp);
            }
        }
        dp[i][j][n] = total; // Memoize the result
        return total;
    }

    public static void main(String[] args) {
        int n = 5;
        int total = 0;
        String[][] a = {{"1", "2", "3"}, {"4", "5", "6"}, {"7", "8", "9"}, {"#", "0", "*"}};
        int[][][] dp = new int[a.length][a[0].length][n + 1]; // Initialize dp array
        for (int[][] matrix : dp) {
            for (int[] row : matrix) {
                Arrays.fill(row, -1); // Initialize dp array with -1
            }
        }
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                if (!a[i][j].equals("#") && !a[i][j].equals("*")) {
                    total += get(a, i, j, n, dp);
                }
            }
        }
        System.out.println(total);
    }
}
