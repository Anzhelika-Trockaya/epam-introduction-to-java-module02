package by.epam.module02.task2107;

import java.util.Scanner;

public class Main {
    //7. Сформировать квадратную матрицу порядка N по правилу: a [i, j] = sin ( (i^2 - j^2)/n )
    //и подсчитать количество положительных элементов в ней.
    public static void main(String[] args) {
        int n;
        double[][] a;
        int numberOfPositiveElements;

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter size of the matrix. (Size must be even.) n = ");
        n = scanner.nextInt();

        if (n < 2 || n % 2 != 0) {
            System.out.println("Incorrect size!");
            return;
        }

        a = new double[n][n];

        for (int i = 0; i < n; i++) {//filling the matrix
            for (int j = 0; j < n; j++) {
                a[i][j] = Math.sin(((Math.pow(i + 1, 2) - Math.pow(j + 1, 2)) / n));
            }
        }

        numberOfPositiveElements = 0;

        for (int i = 0; i < n; i++) {//filling the matrix
            for (int j = 0; j < n; j++) {
                if (a[i][j] > 0) {
                    numberOfPositiveElements++;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("Number of positive elements: " + numberOfPositiveElements);

    }
}
