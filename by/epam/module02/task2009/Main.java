package by.epam.module02.task2009;

import java.util.Arrays;

public class Main {
    //В массиве целых чисел с количеством элементов n найти наиболее часто встречающееся число. Если таких
    //чисел несколько, то определить наименьшее из них.
    public static void main(String[] args) {
        int[] a = {1, 5, 0, 3, 4, 10, 8, 51, 3, -5, 1, 14, 24, 0, 4, 0, 33, 3};
        int theMostCommonNumber;
        int maximumNumberOfRepetitionsOfNumber = 0;
        int currentNumber;
        int numberOfRepetitionsOfCurrentNumber;

        System.out.println("Array : " + Arrays.toString(a));

        theMostCommonNumber = a[0];

        for (int i = 0; i < a.length; i++) {
            currentNumber = a[i];
            numberOfRepetitionsOfCurrentNumber = 1;

            for (int j = i + 1; j < a.length; j++) {
                if (currentNumber == a[j]) {
                    numberOfRepetitionsOfCurrentNumber++;
                }
            }

            if (numberOfRepetitionsOfCurrentNumber > maximumNumberOfRepetitionsOfNumber) {
                maximumNumberOfRepetitionsOfNumber = numberOfRepetitionsOfCurrentNumber;
                theMostCommonNumber = currentNumber;
            } else if (numberOfRepetitionsOfCurrentNumber == maximumNumberOfRepetitionsOfNumber && currentNumber < theMostCommonNumber) {
                theMostCommonNumber = currentNumber;
            }
        }

        System.out.println("The most common number is " + theMostCommonNumber);
    }
}
