package by.epam.module02.task2114;

import java.util.Scanner;

public class Main {
    //14. Сформировать случайную матрицу m x n, состоящую из нулей и единиц, причем в каждом столбце число
    //единиц равно номеру столбца.
    //!Число строк тогда должно быть >= числа столбцов
    public static void main(String[] args) {
        int m;
        int n;
        int[][] a;
        int currentIndex;

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of the rows: m = ");
        m = scanner.nextInt();

        if (m <= 0) {
            System.out.println("Incorrect number!");
            return;
        }


        System.out.print("Enter number of the columns: n = ");
        n = scanner.nextInt();

        if (n <= 0) {
            System.out.println("Incorrect number!");
            return;
        }


        if (n > m) {
            System.out.println("It is impossible to construct a matrix of a given size.");// m>=n
            return;
        }

        a = new int[m][n];

        for (int j = 0; j < n; j++) {
            for (int k = 0; k < j + 1; k++) {

                do {
                    currentIndex = (int) (Math.random() * m);
                } while (a[currentIndex][j] != 0);

                a[currentIndex][j] = 1;
            }
        }

        System.out.println("Result: ");
        for (int[] ints : a) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }

    }
}
