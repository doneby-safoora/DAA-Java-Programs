import java.util.Scanner;

public class MergeSort
{
    static void mergeSort(int arr[], int left, int right){  //function to divide the array
        if(left < right){
            int mid = (left + right)/2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }    

    static void merge(int arr[], int left, int mid, int right){ //function to merge 2 sorted arrays
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int leftArr[] = new int[n1];
        int rightArr[] = new int[n2];

        for(int i = 0; i < n1; i++){
            leftArr[i] = arr[left + 1];
        }
        for(int j = 0; j < n2; j++){
            rightArr[j] = arr[mid + 1 + j];
        }
        
        int i = 0;
        int j = 0;
        int k = left;

        while(i < n1 && j < n2){
            if(leftArr[i] <= rightArr[j]){
                arr[k] = leftArr[i];
                i++;
            } else {
                arr[k] = rightArr[j];
                j++;
            }
            k++;
        }

        while(i < n1){
            arr[k] = leftArr[i];
            i++;
            k++;
        }
        while(j < n2){
            arr[k] = rightArr[j];
            j++;
            k++;
        }
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of elements: ");
        int n = sc.nextInt();

        int arr[] = new int[n];

        System.out.println("Enter the array elements:");

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        mergeSort(arr, 0, n - 1);

        System.out.println("Sorted Array:");

        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }

        sc.close();
    }    
}