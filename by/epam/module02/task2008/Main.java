package by.epam.module02.task2008;

import java.util.Arrays;

public class Main {
    //Дана последовательность целых чисел a1, a2, ..., an.
    //Образовать новую последовательность, выбросив из исходной те члены, которые равны min(a1, a2, ..., an).
    public static void main(String[] args) {
        int[] a = {-1, 5, 0, -3, -2, 10, 8, 51, -3, 1, 14, 24, 0, 3, 33};
        int[] newA;
        int newIndex;
        int min;
        int numberOfMinimumElements;

        System.out.println("Array : " + Arrays.toString(a));

        min = a[0];

        for (int i = 1; i < a.length; i++) { // search minimum element
            if (a[i] < min) {
                min = a[i];
            }
        }

        numberOfMinimumElements = 0;

        for (int i = 0; i < a.length; i++) {// counting the number of minimum element
            if (a[i] == min) {
                numberOfMinimumElements++;
            }
        }

        System.out.println("Min = " + min);
        System.out.println("Number of min elements: " + numberOfMinimumElements);

        newA = new int[a.length - numberOfMinimumElements];
        newIndex = 0;

        for (int i = 0; i < a.length; i++) {
            if (a[i] != min) {
                newA[newIndex] = a[i];
                newIndex++;
            }
        }

        System.out.println("New Array : " + Arrays.toString(newA));


    }
}
