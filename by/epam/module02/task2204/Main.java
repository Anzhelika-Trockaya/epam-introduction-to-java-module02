package by.epam.module02.task2204;

import java.util.Arrays;

public class Main {
    //4. Сортировка обменами. Дана последовательность чисел a1 >= a2 >= ... >= an.Требуется переставить числа в
    //порядке возрастания. Для этого сравниваются два соседних числаи аi и аi+1. Если ai > ai+1, то делается
    //перестановка. Так продолжается до тех пор, пока все элементы не станут расположены в порядке возрастания.
    //Составить алгоритм сортировки, подсчитывая при этом количества перестановок.
    public static void main(String[] args) {
        int[] a = {19, 19, 18, 17, 8, 6, 4, 2, 2, 1};
        int numberOfTransposition = 0;
        System.out.println(Arrays.toString(a));

        for (int i = a.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {

                if (a[j] > a[j + 1]) {

                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;

                    numberOfTransposition++;
                }

            }
        }

        System.out.println("Sorted array: " + Arrays.toString(a));
        System.out.println("Number of transposition = " + numberOfTransposition);
    }
}
