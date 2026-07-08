import java.util.Scanner;
class TowerOfHanoi{
    static int steps = 0;

    static void towerOfHanoi(int n, char from_rod, char to_rod, char aux_rod){
        //Base
        if(n == 0)
            return; //zero disks=nothing to move

        // Step 1: Move n-1 disks from source to helper
        towerOfHanoi(n-1, from_rod, aux_rod, to_rod); //because aux_rod becomes the temporary destination.

        // Step 2: Move the largest(nth) disk from source to destination
        steps++;
        System.out.println("Disk " + n + " moved from " + from_rod + " to " + to_rod);
        
         // Step 3: Move n-1 disks from auxiliary to destination
        towerOfHanoi(n-1, aux_rod, to_rod, from_rod);
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of disks: ");
        int n = sc.nextInt();

        towerOfHanoi(n, 'A', 'C', 'B');
        System.out.println("\nTotal number of steps = " + steps);
        sc.close();
    }
}
