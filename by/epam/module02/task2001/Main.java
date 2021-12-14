package by.epam.module02.task2001;


import java.util.Arrays;

public class Main {
    //В массив A [N] занесены натуральные числа. Найти сумму тех элементов, которые кратны данному К.
    public static void main(String[] args) {
        int[] a = {2000000000, 100000000, 5, 4, 10, 20, 51, 3, 12, 14, 24, 55, 33};
        int k;
        int sumOfMultiplesOfK = 0;

        k = 4;
        System.out.println("Array A : " + Arrays.toString(a));
        System.out.println("K = " + k);

        if (k <= 0) {
            System.out.println("K isn't natural!");
            return;
        }

        for (int element : a) {

            if (element % k == 0) {

                if (Integer.MAX_VALUE - element >= sumOfMultiplesOfK) {
                    sumOfMultiplesOfK += element;
                } else {
                    System.out.println("Answer is too big. Last value= " + sumOfMultiplesOfK);
                    return;
                }

            }

        }

        if (sumOfMultiplesOfK != 0) {
            System.out.println("Sum of multiples of K: " + sumOfMultiplesOfK);
        } else {
            System.out.println("There are no multiples of K in the array.");
        }
    }
}
