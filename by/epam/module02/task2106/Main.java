package by.epam.module02.task2106;

import java.util.Scanner;

public class Main {
    //6. Сформировать квадратную матрицу порядка n по заданному образцу(n - четное):
    // 1 1 1 ... 1 1 1
    // 0 1 1 ... 1 1 0
    // 0 0 1 ... 1 0 0
    // ...............
    // 0 1 1 ... 1 1 0
    // 1 1 1 ... 1 1 1
    public static void main(String[] args) {
        int n;
        int[][] a;

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter size of the matrix. (Size must be even.) n = ");
        n = scanner.nextInt();

        if (n < 2 || n % 2 != 0) {
            System.out.println("Incorrect size!");
            return;
        }

        a = new int[n][n];

        for (int i = 0; i < n / 2; i++) {//filling the matrix
            for (int j = i; j < n - i; j++) {
                a[i][j] = 1;
                a[n - 1 - i][j] = 1;
            }
        }

        for (int[] line : a) {
            for (int element : line) {
                System.out.print(element + " ");
            }
            System.out.println();

        }
    }
}
