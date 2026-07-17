import java.util.Scanner;
class Fibonacci_DP
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of terms: ");
        int n = sc.nextInt();
        int fib[] = new int[n];
        
        if(n >= 1){
            fib[0] = 0;
        }
        if(n >= 2){
            fib[1] = 1;
        }
        for(int i = 2; i < n; i++){
            fib[i] = fib[i-1] + fib[i-2];
        }
        System.out.println("Fibonacci Series: ");
        for(int i = 0; i < n; i++){
            System.out.print(fib[i] + " ");
        }
        sc.close();
    }
}