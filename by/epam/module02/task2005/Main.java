package by.epam.module02.task2005;

import java.util.Arrays;

public class Main {
    //Даны целые числа а1 ,а2 ,..., аn . Вывести на печать только те числа, для которых аi > i.
    public static void main(String[] args) {
        int[] a = {1, 5, 3, -3, 4, 10, 8, -51, 3, -1, 14, 24, 4, 33};
        System.out.println("Array : " + Arrays.toString(a));

        System.out.print("Numbers for which аi > i: ");

        for (int i = 0; i < a.length; i++) {
            if (a[i] > i + 1) {
                System.out.print(a[i]+" ");
            }
        }
    }
}
