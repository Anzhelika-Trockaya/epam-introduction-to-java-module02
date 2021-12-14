package by.epam.module02.task2305;

import java.util.Arrays;

public class Main {
    //5. Составить программу, которая в массиве A[N] находит второе по величине число (вывести на печать число,
    //которое меньше максимального элемента массива, но больше всех других элементов).
    public static void main(String[] args) {
        int[] a = {-5, 5, 23, 56, 0, -90, 56, 7, 23};

        int result;

        System.out.println("Array: " + Arrays.toString(a));

        result = findSecondMaxNumber(a);

        System.out.println((result > Integer.MIN_VALUE) ?
                ("The second largest number is " + result) : "There is no such number in the array!");
    }

    public static int findSecondMaxNumber(int[] a) {
        int max;
        int resultNumber;

        max = findMaxNumber(a);
        resultNumber = Integer.MIN_VALUE;

        for (int number : a) {
            if (number > resultNumber && number < max) {
                resultNumber = number;
            }
        }

        return resultNumber;
    }

    public static int findMaxNumber(int[] a) {
        int max;

        max = a[0];

        for (int i = 1; i < a.length; i++) {
            if (a[i] > max) {
                max = a[i];
            }
        }

        return max;
    }
}
