import java.io.*;

class Solution
{
	static int MAX =100;
	static void diagonalsquare(int mat[][], int row,
										int column)
		System.out.print( "Diagonal one : ");
		for (int i = 0; i < row; i++)
		{
			for (int j = 0; j < column; j++)
				if (i == j)
					System.out.print ( mat[i][j] * mat[i][j] +" ");
		}
		System.out.println();
		System.out.print("Diagonal two : ");
		for (int i = 0; i < row; i++)
		{
			for (int j = 0; j < column; j++)
				if (i + j == column - 1)
					System.out.print(mat[i][j] * mat[i][j] +" ");
		}
	}

}
