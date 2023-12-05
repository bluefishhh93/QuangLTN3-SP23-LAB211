
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author xuant
 */
public class Main {
    private static Scanner sc = new Scanner(System.in);

   public static void main(String[] args) {
       int n=inputLength();;
    int[] x = getARandomArray(n);
       System.out.println("Before sorted: ");
    printArray(x);

    int left = 0;
    int right = x.length - 1;

    quickSort(x, left, right);
       System.out.println("After sorted: ");
    printArray(x);
  }

   
   private static int[] getARandomArray(int n) {
        int arr[] = new int[n];
        Random rd = new Random();

        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = rd.nextInt(100);
        }

        return arr;
    }
   
  private static void quickSort(int[] arr, int left, int right) {
    if (arr == null || arr.length == 0)
      return;

    if (left >= right)
      return;

    int middle = left + (right - left) / 2; 
    int pivot = arr[middle];
    int i = left, j = right;

    while (i <= j) {
      while (arr[i] < pivot) {
        i++;
      }

      while (arr[j] > pivot) {
        j--;
      }

      if (i <= j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        i++;
        j--;
      }
    }

    if (left < j)
      quickSort(arr, left, j);

    if (right > i)
      quickSort(arr, i, right);
  }

  private static void printArray(int[] arr) { 
      System.out.println(Arrays.toString(arr));
  }

    private static int inputLength() {
        int n;
        do{
            try {
                System.out.println("Enter number of array:");
                 n = Integer.parseInt(sc.nextLine());
                 if(n>0) return n;
                 else System.out.println("Number of array must larger than 0");
            } catch (Exception e) {
                System.out.println("Invalid Number of array");
            } 
            }while(true);
    }
}

//cuoi
/*
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {5, 3, 2, 6, 7, 8, 1, 0, 9, 4};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
    
    public static void quickSort(int[] arr, int left, int right) {
        if (left < right) {
            int pivotIndex = partition(arr, left, right);
            quickSort(arr, left, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, right);
        }
    }
    
    public static int partition(int[] arr, int left, int right) {
        int pivot = arr[right];
        int i = left - 1;
        for (int j = left; j < right; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, right);
        return i + 1;
    }
    
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}



*/
//dau
/*


*/