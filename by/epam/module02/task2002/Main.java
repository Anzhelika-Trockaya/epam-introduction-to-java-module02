package by.epam.module02.task2002;

import java.util.Arrays;

public class Main {
    //. Дана последовательность действительных чисел а1 ,а2 ,..., ап. Заменить все ее члены, большие данного Z, этим
    //числом. Подсчитать количество замен.
    public static void main(String[] args) {
        double[] a = {1.5, 2.0, 3.58, 3.46, 3.0, 3.1, 3.05, 1, 8, 7};
        double z;
        int numberOfReplacements = 0;

        z = 3.46;
        System.out.println("A sequence of real numbers a1, a2, ..., an : " + Arrays.toString(a));
        System.out.println("Z = " + z);

        for (int i = 0; i < a.length; i++) {
            if (a[i] > z) {
                a[i] = z;
                numberOfReplacements++;
            }
        }

        System.out.println("A sequence of real numbers a1, a2, ..., an : " + Arrays.toString(a));
        System.out.println("Number of replacement : " + numberOfReplacements);
    }
}
