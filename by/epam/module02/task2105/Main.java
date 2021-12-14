package by.epam.module02.task2105;

import java.util.Scanner;

public class Main {
    //5. Сформировать квадратную матрицу порядка n по заданному образцу(n - четное):
    // 1 1 1 ... 1 1 1
    // 2 2 2 ... 2 2 0
    // 3 3 3 ... 3 0 0
    // ...............
    // n-1 n-1 0 ... 0 0 0
    // n 0 0 ... 0 0 0
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

        for (int i = 0; i < n; i++) {//filling the matrix
            for (int j = 0; j < n - i; j++) {
                a[i][j] = i + 1;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
    }
}
