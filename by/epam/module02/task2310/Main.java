package by.epam.module02.task2310;

import java.util.Arrays;

public class Main {
    //10. Дано натуральное число N. Написать метод(методы) для формирования массива, элементами которого
    //являются цифры числа N.
    public static void main(String[] args) {
        int number;
        int[] array;

        number = 123456789;

        array = getDigitsArray(number);
        System.out.println("Array of the digits of the number " + number + " : " + Arrays.toString(array));
    }

    public static int[] getDigitsArray(int number) {
        int[] array;

        if (number < 1) {
            return null;
        }

        array = new int[Integer.toString(number).length()];

        for (int i = 0; i < array.length; i++) {
            array[array.length - 1 - i] = number % 10;
            number /= 10;
        }

        return array;
    }
}
