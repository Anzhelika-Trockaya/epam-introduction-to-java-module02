package by.epam.module02.task2207;

import java.util.Arrays;

public class Main {
    //7. Пусть даны две неубывающие последовательности действительных чисел a1 <= a2 <=...<= an и b1 <= b2 <=...<=bm.
    //Требуется указать те места, на которые нужно вставлять элементы последовательности
    //b1 <= b2 <=...<=bm в первую последовательность так, чтобы новая последовательность оставалась возрастающей.
    public static void main(String[] args) {
        int[] a = {2, 2, 4, 5, 6, 10};
        int[] b = {1, 1, 2, 4, 6, 8, 17, 18, 19};

        System.out.println("Array a: " + Arrays.toString(a));
        System.out.println("Array b: " + Arrays.toString(b));

        int[] indexes = new int[b.length];

        for (int i = 0; i < b.length; i++) {

            if (a[a.length - 1] <= b[i]) {

                indexes[i] = i + a.length;

            } else {

                for (int j = 0; j < a.length; j++) {
                    if (b[i] <= a[j]) {
                        indexes[i] = i + j;
                        break;
                    }
                }

            }
        }

        System.out.println("Indexes: " + Arrays.toString(indexes));

    }

}
