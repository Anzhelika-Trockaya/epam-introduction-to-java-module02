package by.epam.module02.task2203;

import java.util.Arrays;

public class Main {
    //3. Сортировка выбором. Дана последовательность чисел a1 <= a2 <= ... <= an .Требуется переставить элементы так,
    //чтобы они были расположены по убыванию. Для этого в массиве, начиная с первого, выбирается наибольший
    //элемент и ставится на первое место, а первый - на место наибольшего. Затем, начиная со второго, эта процедура
    //повторяется. Написать алгоритм сортировки выбором.
    public static void main(String[] args) {
        int[] a = {1, 1, 2, 4, 6, 8, 17, 18, 19, 19};
        int indexOfMax;
        int max;

        System.out.println(Arrays.toString(a));

        for (int i = 0; i < a.length - 1; i++) {
            max = a[i];
            indexOfMax = i;

            for (int j = i + 1; j < a.length; j++) {

                if (a[j] > max) {
                    max = a[j];
                    indexOfMax = j;
                }

            }

            a[indexOfMax] = a[i];
            a[i] = max;
        }

        System.out.println("Sorted array: " + Arrays.toString(a));
    }
}
