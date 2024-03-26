class HelloWorld {
    public static void rec(String a,String b,int i,int j,String ans){
        if(i==a.length() || j==b.length()){
            System.out.println(ans);
            return;
        }
        if(a.charAt(i)==b.charAt(j)){
            rec(a,b,i+1,j+1,ans+a.charAt(i));
        }
        rec(a,b,i,j+1,ans);
        rec(a,b,i+1,j,ans);
    }
    public static void main(String[] args) {
        String a="abcdefg";
        String b="haibjckdle";
        String dp[][]=new String[a.length()][b.length()];
        String ans="";
        rec(a,b,0,0,ans);
        
    }
}


//dp
class HelloWorld {
    public static String rec(String a, String b, int i, int j, String[][] memo) {
        if (i == a.length() || j == b.length()) {
            return "";
        }
        if (memo[i][j] != null) {
            return memo[i][j];
        }
        if (a.charAt(i) == b.charAt(j)) {
            memo[i][j] = a.charAt(i) + rec(a, b, i + 1, j + 1, memo);
            return memo[i][j];
        }
        String x = rec(a, b, i, j + 1, memo);
        String y = rec(a, b, i + 1, j, memo);
        memo[i][j] = x.length() > y.length() ? x : y;
        return memo[i][j];
    }

    public static void main(String[] args) {
        String a = "abcdefg";
        String b = "haibjckdle";
        String[][] memo = new String[a.length()][b.length()];
        String ans = rec(a, b, 0, 0, memo);
        System.out.println(ans);
    }
}
