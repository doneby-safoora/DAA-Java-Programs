import java.util.Scanner;

public class StrassenMatrixMultiplication {

    // Add two matrices
    static int[][] add(int[][] A, int[][] B) 
	{
        int n = A.length;
        int[][] C = new int[n][n];

        for (int i = 0; i < n; i++)
		{
            for (int j = 0; j < n; j++)
			{
                C[i][j] = A[i][j] + B[i][j];
			}
		}

        return C;
    }

    // Subtract two matrices
    static int[][] subtract(int[][] A, int[][] B) 
	{
        int n = A.length;
        int[][] C = new int[n][n];

        for (int i = 0; i < n; i++)
		{
            for (int j = 0; j < n; j++)
			{
                C[i][j] = A[i][j] - B[i][j];
			}
		}

        return C;
    }

    // Strassen Multiplication
    static int[][] strassen(int[][] A, int[][] B) {

        int n = A.length;
        int[][] C = new int[n][n];

        // Base case
        if (n == 1) {
            C[0][0] = A[0][0] * B[0][0];
            return C;
        }

        int size = n / 2;

        int[][] A11 = new int[size][size];
        int[][] A12 = new int[size][size];
        int[][] A21 = new int[size][size];
        int[][] A22 = new int[size][size];

        int[][] B11 = new int[size][size];
        int[][] B12 = new int[size][size];
        int[][] B21 = new int[size][size];
        int[][] B22 = new int[size][size];

        // Divide matrices
        for (int i = 0; i < size; i++) 
		{
            for (int j = 0; j < size; j++) 
			{

                A11[i][j] = A[i][j];
                A12[i][j] = A[i][j + size];
                A21[i][j] = A[i + size][j];
                A22[i][j] = A[i + size][j + size];

                B11[i][j] = B[i][j];
                B12[i][j] = B[i][j + size];
                B21[i][j] = B[i + size][j];
                B22[i][j] = B[i + size][j + size];
            }
        }

        // Compute M1 to M7
        int[][] M1 = strassen(add(A11, A22), add(B11, B22));
        int[][] M2 = strassen(add(A21, A22), B11);
        int[][] M3 = strassen(A11, subtract(B12, B22));
        int[][] M4 = strassen(A22, subtract(B21, B11));
        int[][] M5 = strassen(add(A11, A12), B22);
        int[][] M6 = strassen(subtract(A21, A11), add(B11, B12));
        int[][] M7 = strassen(subtract(A12, A22), add(B21, B22));

        // Compute C11, C12, C21, C22
        int[][] C11 = add(subtract(add(M1, M4), M5), M7);
        int[][] C12 = add(M3, M5);
        int[][] C21 = add(M2, M4);
        int[][] C22 = add(subtract(add(M1, M3), M2), M6);

        // Combine into result matrix
        for (int i = 0; i < size; i++) 
		{
            for (int j = 0; j < size; j++) 
			{
                C[i][j] = C11[i][j];
                C[i][j + size] = C12[i][j];
                C[i + size][j] = C21[i][j];
                C[i + size][j + size] = C22[i][j];
            }
        }
        return C;
    }

    // Display matrix
    static void printMatrix(int[][] M) 
	{
        for (int[] row : M) 
		{
            for (int val : row)
			{
                System.out.print(val + "\t");
			}
            System.out.println();
        }
    }

    public static void main(String[] args) 
	{
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter matrix size (power of 2): ");
        int n = sc.nextInt();
        int[][] A = new int[n][n];
        int[][] B = new int[n][n];
        System.out.println("Enter First Matrix:");
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                A[i][j] = sc.nextInt();

        System.out.println("Enter Second Matrix:");
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                B[i][j] = sc.nextInt();

        int[][] result = strassen(A, B);

        System.out.println("\nResult Matrix:");
        printMatrix(result);

        sc.close();
    }
}