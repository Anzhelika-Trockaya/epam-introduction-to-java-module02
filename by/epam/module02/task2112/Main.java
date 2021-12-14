package by.epam.module02.task2112;

public class Main {
    //12. Отсортировать строки матрицы по возрастанию и убыванию значений элементов.
    public static void main(String[] args) {
        double[][] a = {{1, 5, 6, 2, 4, 5}, {-1, 5, 8, -9, 3, 5}, {21, 56, 1, 0, 5, 9}, {9, -10, 5, 6, 3, 2}};

        double temp;

        printMatrix(a);

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                for (int k = j + 1; k < a[i].length; k++) {
                    if (a[i][k] < a[i][j]) {
                        temp = a[i][k];
                        a[i][k] = a[i][j];
                        a[i][j] = temp;
                    }
                }
            }
        }

        System.out.println("Matrix with ascending sorted rows: ");
        printMatrix(a);

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                for (int k = j + 1; k < a[i].length; k++) {
                    if (a[i][k] > a[i][j]) {
                        temp = a[i][k];
                        a[i][k] = a[i][j];
                        a[i][j] = temp;
                    }
                }
            }
        }

        System.out.println("Matrix with descending sorted rows: ");
        printMatrix(a);

    }

    public static void printMatrix(double[][] a) {
        for (double[] doubles : a) {
            for (double aDouble : doubles) {
                System.out.print(aDouble + " ");
            }
            System.out.println();
        }
    }
}
