package by.epam.module02.task2316;

import java.util.Scanner;

public class Main {
    //16. Написать программу, определяющую сумму n - значных чисел, содержащих только нечетные цифры.
    //Определить также, сколько четных цифр в найденной сумме. Для решения задачи использовать декомпозицию.
    public static void main(String[] args) {
        int n;
        long sum;

        n = 2;

        if (n < 1) {
            System.out.println("Number must be natural!");
            return;
        }

        sum = sumOfNumbers(n);
        System.out.println("Sum of numbers = " + sum);
        System.out.println("Number of even digits = " + numberOfEvenDigits(sum));

    }

    public static long sumOfNumbers(int n) {
        long sum;
        int[] digits;

        if (n > 9) {
            return -1;
        }

        digits = digitsArrayInitialValue(n);

        sum = 0;
        while (digits != null) {
            sum += digitsArrayToNumber(digits);
            digits = nextDigitsArrayValue(digits);
        }

        return sum;
    }

    private static int[] digitsArrayInitialValue(int n) {
        int[] digits;

        digits = new int[n];

        for (int i = 0; i < n; i++) {
            digits[i] = 1;
        }

        return digits;
    }

    private static int digitsArrayToNumber(int[] digits) {
        int number = 0;

        for (int i = 1; i <= digits.length; i++) {
            number += digits[digits.length - i] * Math.pow(10, i - 1);
        }

        return number;
    }

    private static int[] nextDigitsArrayValue(int[] prev) {
        for (int i = prev.length - 1; i >= 0; i--) {

            if (prev[i] < 9) {
                prev[i] += 2;

                for (int j = i + 1; j < prev.length; j++) {
                    prev[j] = 1;
                }

                return prev;
            }

        }

        return null;
    }

    public static int numberOfEvenDigits(long number) {
        int numOfEvenDigits = 0;
        int currentDigit;

        while (number > 0) {

            currentDigit = (int) number % 10;
            number /= 10;

            if (currentDigit % 2 == 0) {
                numOfEvenDigits++;
            }

        }

        return numOfEvenDigits;
    }
}
