package by.epam.module02.task2312;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    //12. Даны натуральные числа К и N. Написать метод(методы) формирования массива А, элементами которого
    //являются числа, сумма цифр которых равна К и которые не большее N.
    public static void main(String[] args) {
        int k;
        int n;

        k = 6;
        n = 51;

        if (k < 1 || n < 1) {
            System.out.println("Numbers must be natural!");
            return;
        }

        System.out.println("Array of numbers whose sum of digits is equal to " + k
                + " and which are not more than " + n + ": ");

        System.out.println(Arrays.toString(arrayOfNumbers(k, n)));

    }

    public static int[] arrayOfNumbers(int digitsSum, int maxNumber) {
        Set<Integer> numbers;
        int[] result;
        int[] digits;
        int minImpossibleNumber;

        numbers = new TreeSet<>();


        digits = initialDigits(digitsSum, maxNumber);

        if (digits == null) {
            return null;
        }

        minImpossibleNumber = digitsToNumber(digits);

        if (minImpossibleNumber <= maxNumber) {

            numbers = fillRecursiveNumbers(digits, numbers, maxNumber);
            result = numbers.stream()
                    .mapToInt(x -> x)
                    .sorted()
                    .toArray();

        } else {

            result = new int[0];

        }

        return result;
    }

    private static int[] initialDigits(int digitsSum, int maxValue) {
        int[] digits;

        digits = new int[Integer.toString(maxValue).length()];

        for (int i = digits.length - 1; i >= 0; i--) {

            if (digitsSum >= 9) {

                digits[i] = 9;
                digitsSum -= 9;

            } else if (digitsSum > 0) {

                digits[i] = digitsSum;
                digitsSum = 0;
                break;
            }

        }

        if (digitsSum > 0) {
            return null;
        }

        return digits;
    }

    private static int digitsToNumber(int[] digits) {
        int number = 0;

        for (int i = 0; i < digits.length; i++) {
            number += digits[digits.length - i - 1] * Math.pow(10, i);
        }

        return number;
    }

    private static Set<Integer> fillRecursiveNumbers(int[] digits, Set<Integer> numbers, int maxValue) {
        int currentValue;

        currentValue = digitsToNumber(digits);
        numbers.add(currentValue);

        for (int i = digits.length - 1; i >= 1; i--) {

            if (digits[i] > 0) {

                for (int j = i - 1; j >= 0; j--) {

                    if (digits[j] < 9) {

                        digits[j]++;
                        digits[i]--;
                        digits = sortEndOfDigitsAfterPosition(digits, j);
                        currentValue = digitsToNumber(digits);

                        if (maxValue >= currentValue) {
                            numbers.add(currentValue);
                            fillRecursiveNumbers(digits, numbers, maxValue);
                        }

                    }

                }

            }

        }

        return numbers;
    }

    private static int[] sortEndOfDigitsAfterPosition(int[] digits, int position) {
        int temp;

        for (int i = 1; i <= (digits.length - 1 - position) / 2; i++) {
            temp = digits[position + i];
            digits[position + i] = digits[digits.length - i];
            digits[digits.length - i] = temp;
        }

        return digits;
    }
}