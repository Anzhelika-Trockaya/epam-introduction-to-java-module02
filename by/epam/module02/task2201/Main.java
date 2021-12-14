package by.epam.module02.task2201;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    //1. Заданы два одномерных массива с различным количеством элементов и натуральное число k. Объединить их в
    //один массив, включив второй массив между k-м и (k+1) - м элементами первого, при этом не используя
    //дополнительный массив.
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 6};
        int[] b = {11, 12, 13, 14, 15, 16, 17, 18, 19};
        int k;
        int[] result;

        @SuppressWarnings("resourse")
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter k: ");
        k = scanner.nextInt();

        if (k < 1 || k > a.length - 1) {
            System.out.println("Exception! Incorrect k.");
            return;
        }

        result = new int[a.length + b.length];

        for (int i = 0; i < k; i++) {
            result[i] = a[i];
        }

        for (int i = 0; i < b.length; i++) {
            result[k + i] = b[i];
        }

        for (int i = k; i < a.length; i++) {
            result[i + b.length] = a[i];
        }

        System.out.println(Arrays.toString(result));
    }
}
