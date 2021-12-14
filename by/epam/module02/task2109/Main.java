package by.epam.module02.task2109;

public class Main {
    //9. Задана матрица неотрицательных чисел. Посчитать сумму элементов в каждом столбце. Определить, какой
    //столбец содержит максимальную сумму
    public static void main(String[] args) {

        double[][] a = {{1, 5, 6, 2, 4, 5}, {1, 5, 8, 9, 3, 5}, {21, 56, 1, 0, 5, 9}, {9, 10, 5, 6, 3, 2}};

        double[] sumOfElementsInTheColumns = new double[a[0].length];
        double maxSumOfElementsInTheColumns;

        for (double[] value : a) {
            for (double v : value) {
                System.out.print(v + " ");
            }
            System.out.println();
        }

        for (double[] doubles : a) {//counting the sum of elements in the columns
            for (int j = 0; j < doubles.length; j++) {
                sumOfElementsInTheColumns[j] += doubles[j];
            }
        }

        maxSumOfElementsInTheColumns = 0;

        for (double sumOfElementsInTheColumn : sumOfElementsInTheColumns) {//search for the maximum sum
            if (sumOfElementsInTheColumn > maxSumOfElementsInTheColumns) {
                maxSumOfElementsInTheColumns = sumOfElementsInTheColumn;
            }
        }

        System.out.print("Sum of elements in the columns: ");

        for (double sumOfElementsInTheColumn : sumOfElementsInTheColumns) {
            System.out.print(sumOfElementsInTheColumn + " ");
        }

        System.out.println("Maximum sum: " + maxSumOfElementsInTheColumns);

    }
}
