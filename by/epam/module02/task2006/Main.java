package by.epam.module02.task2006;

import java.util.Arrays;

public class Main {
    // Задана последовательность N вещественных чисел. Вычислить сумму чисел, порядковые номера которых
    //являются простыми числами.
    public static void main(String[] args) {
        double[] a = {1, 1, 1, -2, 1, -200, 1, -200, -200, -200, 1, -200, 1, -200, -200, -200, 1};
        double sum = 0;

        System.out.println("Array: " + Arrays.toString(a));

        for (int i = 0; i < a.length; i++) {

            if (isPrimeNumber(i + 1)) {
                sum += a[i];
            }

        }

        System.out.println("The sum of numbers whose ordinal numbers are prime numbers: " + sum);
    }

    public static boolean isPrimeNumber(int n) {
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
