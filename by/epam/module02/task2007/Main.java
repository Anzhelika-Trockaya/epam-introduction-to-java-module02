package by.epam.module02.task2007;

import java.util.Arrays;

public class Main {
    //Даны действительные числа a1 a2 ... a2n
    //Найти max(a1+a2n, a2+a2n-1, ..., an+an-1)
    public static void main(String[] args) {
        double[] a = {1.5, -0.000098, 2.0, -2, 2, 3.58, 3.46, 3.0, 8.0, 100, 8.1, 3.05, 0.005, 0.0, 1, 8, 7, 20};
        double max;
        double currentSum;

        if (a.length % 2 != 0) {
            System.out.println("Size of array must be even!");
            return;
        }

        System.out.println("Array: " + Arrays.toString(a));

        max = a[0] + a[a.length - 1];

        for (int i = 1; i < a.length / 2; i++) {

            currentSum = a[i] + a[a.length - 1 - i];

            if (currentSum > max) {
                max = currentSum;
            }

        }

        System.out.println("Maximum of the sum : " + max);
    }
}
