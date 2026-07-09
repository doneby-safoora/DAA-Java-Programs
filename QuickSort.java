import java.util.Scanner;
public class QuickSort{
    static void quickSort(int arr[], int low, int high){        //perform QS
        if(low < high){
            int pivotIndex = partition(arr, low, high);     //partition index
            quickSort(arr, low, pivotIndex - 1);        //sort left part
            quickSort(arr, pivotIndex + 1, high);       //sort right part
        }
    }

    static int partition(int arr[], int low, int high){
        int pivot = arr[high];
        int i = low -1;
        for(int j = low; j < high; j++){
            if(arr[j] < pivot){
                i++;

                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[i + 1];
        arr[i+1] = arr[high];
        arr[high] = temp;

        return i+1;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of elements: ");
        int n = sc.nextInt();
        int arr[] = new int[n];
        System.out.println("Enter array Elements: ");
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }

        quickSort(arr, 0, n-1);
        System.out.println("Sorted Array: ");
        for(int i = 0; i < n; i++){
            System.out.print(arr[i] + " ");
        }
        sc.close();
    }
}