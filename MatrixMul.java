public class MatrixMul
{
    static void mul(int a[][], int b[][])
    {
        int r1 = a.length;
        int c1 = a[0].length;
        int r2 = b.length;
        int c2 = b[0].length;

        int c[][] = new int[r1][c2];

        if(c1 != r2)
        {
            System.out.println("Matrix Mul not possible.");
            return;
        }
        else
        {
            for(int i = 0; i < r1; i++)
            {
                for(int j = 0; j < c2; j++)
                {
                    c[i][j] = 0;
                    for(int k = 0; k < c1; k++)
                    {
                        c[i][j] += a[i][k] * b[k][j];
                    }
                    System.out.print(c[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
    public static void main(String[] args)
    {
        int a[][] = {
            {1, 2},
            {3, 4}
        };

        int b[][] = {
            {5, 6},
            {7, 8}
        };

        mul(a, b);
    }
}