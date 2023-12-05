
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

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        Main m = new Main();
        int n; //do dai mang
        int x; //gia tri can tim
        System.out.print("Enter number of array: ");
        do {
            n = Integer.parseInt(sc.nextLine());
        } while (n < 0);
        int[] arr = new int[n];
        arr = m.getARandomArray(n);
        //arr = new int[]{2,4,1,8,0,6};
        arr = m.sortArray(arr, n);
        System.out.print("Enter search value: ");
        x = sc.nextInt();
        int index = m.binarySearch(arr, n, 0, n - 1, x);
        m.prinArray(arr, n);
        System.out.println();
        if (index != -1) {
            System.out.println("Found at: " + index);
        } else {
            System.out.println("Not found!");
        }

    }

    //Ham tim kiem nhi phan
    private int binarySearch(int[] arr, int n, int left, int right, int x) {
        if (right >= left) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == x) {
                return mid;
            }
            if (arr[mid] > x) {
                return binarySearch(arr, n, left, mid - 1, x);
            }
            return binarySearch(arr, n, mid + 1, right, x);
        }
        return -1;
    }

    //Ham tra ve mot mang ngau nhien
    private int[] getARandomArray(int n) {
        int arr[] = new int[n];
        Random rd = new Random();

        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = rd.nextInt(100);
        }

        return arr;
    }

    //in mang
    private void prinArray(int[] arr, int n) {
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    //ham sap xep mang
    private int[] sortArray(int[] arr, int n) {
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[i] > arr[j]) {
                    int tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                }
            }
        }
        return arr;
    }

}

