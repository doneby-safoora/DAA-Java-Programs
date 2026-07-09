import java.util.Scanner;
public class BinarySearch{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of elements: ");
        int n = sc.nextInt();
        
        int arr[] = new int[n];
        System.out.println("Enter the sorted array: ");
        for(int i = 0; i< n; i++){
            arr[i] = sc.nextInt();
        }
        
        System.out.print("Enter the element to search: ");
        int key = sc.nextInt();

        int low = 0;
        int high = n-1;
        int mid;

        while(low <= high){
            mid = (low + high)/2;
            if(arr[mid] == key){
                System.out.println("Element found at index " + mid);
                return;
            }
            else if(key < arr[mid]){
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        System.out.println("Element not found.");
        sc.close();
    }
}