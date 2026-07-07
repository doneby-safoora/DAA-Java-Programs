// //MODULAR SOLUTION
// import java.util.*;
// class IR {
//     // Method to find the largest element
//     public static int first_largest(int[] arr) {
//         int largest = arr[0];

//         for (int i = 1; i < arr.length; i++) {
//             if (arr[i] > largest) {
//                 largest = arr[i];
//             }
//         }
//         return largest;
//     }

//     // Method to find the second largest element
//     public static int second_largest(int[] arr) {
//         int largest = first_largest(arr);
//         int secondLargest = Integer.MIN_VALUE;

//         for (int i = 0; i < arr.length; i++) {
//             if (arr[i] != largest && arr[i] > secondLargest) {
//                 secondLargest = arr[i];
//             }
//         }
//         return secondLargest;
//     }
// }

// public class Main {
//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);

//         System.out.print("Enter the size of the array: ");
//         int n = sc.nextInt();

//         int[] arr = new int[n];

//         System.out.println("Enter the array elements:");

//         for (int i = 0; i < n; i++) {
//             arr[i] = sc.nextInt();
//         }

//         int secondLargest = IR.second_largest(arr);

//         if (secondLargest == Integer.MIN_VALUE) {
//             System.out.println("Second largest element does not exist.");
//         } else {
//             System.out.println("Second largest element is: " + secondLargest);
//         }
//         sc.close();
//     }
// }

//RECURSIVE SOLUTION:

// class IR{
//     public static int findLargest(int[] arr, int index){
//         if(index == arr.length - 1){
//             return arr[index];
//         }

//         int largest = findLargest(arr, index+1);

//         if(arr[index] > largest){
//             return arr[index];
//         } else {
//             return largest;
//         }
//     }

//     public static int findSecondLargest(int[] arr){
//         int largest = findLargest(arr, 0);
//         int secondLargest = Integer.MIN_VALUE;

//         for(int i = 0; i < arr.length; i++){
//             if(arr[i] != largest && arr[i] > secondLargest){
//                 secondLargest = arr[i];
//             }
//         }
//         return secondLargest;
//     }

//     public static void main(String[] args){
//         int[] arr = {1,2,3,4,5};
//         System.out.println("Second Largest = " + findSecondLargest(arr));
//     }
// }

import java.util.*;
class SecondLargestElement {

    // Recursive method to find the largest element
    public static int findLargest(int[] arr, int index) {

        // Base case
        if (index == arr.length - 1) {
            return arr[index];
        }

        // Recursive call
        int largest = findLargest(arr, index + 1);

        // Compare current element with the largest
        if (arr[index] > largest) {
            return arr[index];
        } else {
            return largest;
        }
    }

    // Method to find the second largest element
    public static int findSecondLargest(int[] arr) {

        int largest = findLargest(arr, 0);
        int secondLargest = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != largest && arr[i] > secondLargest) {
                secondLargest = arr[i];
            }
        }
        return secondLargest;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the array: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the array elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int secondLargest = findSecondLargest(arr);
        System.out.println("Second Largest = " + secondLargest);
        sc.close();
    }
}

/*
Algorithm: Find Second Largest Using Recursion

BEGIN

INPUT size of array N

CREATE array ARR of size N

FOR i ← 0 TO N-1 DO
    INPUT ARR[i]
END FOR

CALL FindSecondLargest(ARR)

PRINT second largest element

END


Function FindLargest(ARR, INDEX)

IF INDEX = length(ARR) - 1 THEN
    RETURN ARR[INDEX]
END IF

LARGEST ← FindLargest(ARR, INDEX + 1)

IF ARR[INDEX] > LARGEST THEN
    RETURN ARR[INDEX]
ELSE
    RETURN LARGEST
END IF


Function FindSecondLargest(ARR)

LARGEST ← FindLargest(ARR, 0)

SECONDLARGEST ← Minimum Integer Value

FOR each element in ARR DO
    IF element ≠ LARGEST AND element > SECONDLARGEST THEN
        SECONDLARGEST ← element
    END IF
END FOR

RETURN SECONDLARGEST

*/