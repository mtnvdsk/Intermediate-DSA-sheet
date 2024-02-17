import java.io.*;
 
class Solution {
static int N = 3;
 
// Function to swap diagonal of matrix
static void swapDiagonal(int matrix[][]) {
    for (int i = 0; i < N; i++) {
    int temp = matrix[i][i];
    matrix[i][i] = matrix[i][N - i - 1];
    matrix[i][N - i - 1] = temp;
    }
}
}