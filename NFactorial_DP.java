//Find n factorial using dynamic programming
import java.util.Scanner;
class NFactorial_DP
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter n value: ");
		int n = sc.nextInt();
		
		int[] arr = new int[n+1];
		arr[0] = 1;
		
		for(int i = 1;i <= n;i++)
		{
			arr[i] = arr[i-1]*i;
		}
		System.out.printf("Factorial of %d = %d ",n,arr[n]);
		sc.close();
	}
}

//int size = 4 bytes
//long size = 8 bytes

/*
import java.util.Scanner;
class Nfactorial_DB
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the value of n: ");
        int n = sc.nextInt();

        int arr[] = new int[n + 1];
        arr[0] = 1;

        for(int i = 1; i <= n; i++)
        {
            arr[i] = i * arr[i - 1];
        }

        System.out.println("\nFactorial of " + n + ":" + arr[n]);
        sc.close();
    }
}

*/

