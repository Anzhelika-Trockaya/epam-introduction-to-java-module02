package by.epam.module02.task2103;

import java.util.Scanner;

public class Main {
    //3. Дана матрица. Вывести k-ю строку и p-й столбец матрицы.
    public static void main(String[] args) {
        int k;
        int p;
        int[][] a = {{1, 5, 6, 2, 4, 5}, {-1, 5, 8, -9, 3, 5}, {21, 56, 1, 0, 5, 9}, {9, -10, 5, 6, 3, 2}};

        for (int[] line : a) {
            for (int element : line) {
                System.out.print(element + " ");
            }
            System.out.println();
        }

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the line number you want to output. k = ");
        k = scanner.nextInt();

        if (k <= a.length && k > 0) {
            for (int j = 0; j < a[k - 1].length; j++) {
                System.out.print(a[k - 1][j] + " ");
            }
            System.out.println();
        } else {
            System.out.println("Incorrect line number!");
        }

        System.out.print("Enter the column number you want to output. p = ");
        p = scanner.nextInt();

        if (p <= a[0].length && p > 0) {
            for (int[] ints : a) {
                System.out.println(ints[p - 1]);
            }
            System.out.println();
        } else {
            System.out.println("Incorrect column number!");
        }

    }
}
