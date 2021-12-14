package by.epam.module02.task2202;

import java.util.Arrays;

public class Main {
    //2. Даны две последовательности a1<= a2 <= ... <= an и b1 <= b2 <= ... <= bm. Образовать из них новую
    // последовательность чисел так, чтобы она тоже была неубывающей. Примечание. Дополнительный массив не использовать
    public static void main(String[] args) {
        int[] a = {2, 2, 4, 5, 6, 10};
        int[] b = {1, 1, 2, 4, 6, 8, 17, 18, 19};

        int[] result = new int[a.length + b.length];
        int indexA = 0;
        int indexB = 0;

        for (int i = 0; i < result.length; i++) {

            if (indexA < a.length && indexB < b.length) {

                if (a[indexA] <= b[indexB]) {

                    result[i] = a[indexA];
                    indexA++;

                } else {

                    result[i] = b[indexB];
                    indexB++;

                }

            } else if (indexA < a.length) {

                result[i] = a[indexA];
                indexA++;

            } else if (indexB < b.length) {

                result[i] = b[indexB];
                indexB++;

            }
        }

        System.out.println(Arrays.toString(result));
    }
}
