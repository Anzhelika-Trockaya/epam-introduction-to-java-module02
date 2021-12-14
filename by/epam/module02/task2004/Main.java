package by.epam.module02.task2004;

import java.util.Arrays;

public class Main {
    // Даны действительные числа а1 ,а2 ,..., аn . Поменять местами наибольший и наименьший элементы.
    public static void main(String[] args) {
        double[] a = {1.5, -0.000098, 2.0, -2, -300.25, 3.58, 3.46, 3.0, 8.0, 0, 3.1, 3.05, 0.005, 0.0, 1, 8, 7};
        double max;
        double min;

        System.out.println("Array: " + Arrays.toString(a));

        max = a[0];                             // search minimum and maximum elements
        min = a[0];
        for (int i = 1; i < a.length; i++) {
            if (a[i] > max) {
                max = a[i];
            } else if (a[i] < min) {
                min = a[i];
            }
        }

        System.out.println("Minimum element: " + min + " Maximum element: " + max);

        for (int i = 0; i < a.length; i++) {//replacing the maximum element with the minimum and vice versa
            if (a[i] == max) {
                a[i] = min;
            } else if (a[i] == min) {
                a[i] = max;
            }
        }

        System.out.println("Array after replacement: " + Arrays.toString(a));
    }
}
