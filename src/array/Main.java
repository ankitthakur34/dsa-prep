package array;

import java.util.Scanner;

import java.util.Arrays;
import java.util.Scanner;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        int m = scanner.nextInt();
        int[][] arr2 = new int[m][n];
        arr2[0] = arr.clone();

        for (int i = 1; i < m; i++) {
            int[] prevRow = arr2[i - 1];
            int[] currRow = arr2[i];

            for (int j = 0; j < n; j++) {
                int left = (j == 0) ? prevRow[n - 1] : prevRow[j - 1];
                int right = (j == n - 1) ? prevRow[0] : prevRow[j + 1];
                currRow[j] = (left == right) ? 0 : 1;
            }
        }

        for (int value : arr2[m - 1]) {
            System.out.print(value + " ");
        }

        scanner.close();
    }
}




