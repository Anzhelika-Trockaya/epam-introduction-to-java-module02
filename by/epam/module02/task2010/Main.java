package by.epam.module02.task2010;

import java.util.Arrays;

public class Main {
    //Дан целочисленный массив с количеством элементов п. Сжать массив, выбросив из него каждый второй
    //элемент (освободившиеся элементы заполнить нулями). Примечание. Дополнительный массив не использовать.
    public static void main(String[] args) {
        int[] a = {1, 5, 0, 3, 4, 10, 8, 51, 3, -5, 1, 14, 24, 0, 4, 0, 33, 3};
        System.out.println("Array : " + Arrays.toString(a));

        int nextIndexOfCompressedArray = 1;//new index

        for (int i = 2; i < a.length; i++) {
            if ((i + 1) % 2 == 0) {//skip every second element
                continue;
            }
            a[nextIndexOfCompressedArray] = a[i];
            nextIndexOfCompressedArray++;
        }

        for (int i = nextIndexOfCompressedArray; i < a.length; i++) {//filling the remainder of zeros
            a[i] = 0;
        }

        System.out.println("Array after compression: " + Arrays.toString(a));
    }
}
