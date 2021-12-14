package by.epam.module02.task2113;

public class Main {
    //13. Отсотрировать стобцы матрицы по возрастанию и убыванию значений элементов
    public static void main(String[] args) {
        double[][] a = {{1, 5, 6, 2, 4, 5}, {-1, 5, 8, -9, 3, 5}, {21, 56, 1, 0, 5, 9}, {9, -10, 5, 6, 3, 2}};

        double temp;

        printMatrix(a);

        for (int j = 0; j < a[0].length; j++) {
            for (int i = 0; i < a.length; i++) {
                for (int k = i + 1; k < a.length; k++) {
                    if (a[i][j] > a[k][j]) {
                        temp = a[i][j];
                        a[i][j] = a[k][j];
                        a[k][j] = temp;
                    }
                }
            }
        }

        System.out.println("Matrix with ascending sorted columns: ");
        printMatrix(a);

        for (int j = 0; j < a[0].length; j++) {
            for (int i = 0; i < a.length; i++) {
                for (int k = i + 1; k < a.length; k++) {
                    if (a[i][j] < a[k][j]) {
                        temp = a[i][j];
                        a[i][j] = a[k][j];
                        a[k][j] = temp;
                    }
                }
            }
        }

        System.out.println("Matrix with descending sorted columns: ");
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
