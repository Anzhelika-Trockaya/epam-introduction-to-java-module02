package by.epam.module02.task2003;

import java.util.Arrays;

public class Main {
    //Дан массив действительных чисел, размерность которого N. Подсчитать, сколько в нем отрицательных,
    //положительных и нулевых элементов.
    public static void main(String[] args) {
        double[] a = {1.5, -0.000098, 2.0, -2, -300.25, 3.58, 3.46, 3.0, 0, 3.1, 3.05, 0.005, 0.0, 1, 8, 7, 0.0};

        int numberOfPositive = 0;
        int numberOfNegative = 0;
        int numberOfZero = 0;

        System.out.println("Array: " + Arrays.toString(a));

        for (int i = 0; i < a.length; i++) {
            if (a[i] > 0) {
                numberOfPositive++;
            } else if (a[i] < 0) {
                numberOfNegative++;
            } else {
                numberOfZero++;
            }
        }

        System.out.println("Number of positive elements: " + numberOfPositive
                + "\nNumber of negative elements: " + numberOfNegative
                + "\nNumber of zero elements: " + numberOfZero);
    }
}
