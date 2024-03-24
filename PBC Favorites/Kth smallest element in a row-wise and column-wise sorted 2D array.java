import java.util.*;
class HelloWorld {
    public static void main(String[] args) {
        int k = 7;
        int mat[][] = {
            { 10, 20, 30, 40 },
            { 15, 25, 35, 45 },
            { 25, 29, 37, 48 },
            { 32, 33, 39, 50 },
        };
        PriorityQueue<Integer> a = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0; i < mat.length; i++) {
            for(int j = 0; j < mat[0].length; j++) {
                a.add(mat[i][j]);
            }
            while(a.size() > k) {
                a.remove();
            }
        }
        System.out.println(a.remove());
    }
}
