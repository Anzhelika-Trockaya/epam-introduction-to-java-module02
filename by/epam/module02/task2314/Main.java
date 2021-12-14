package by.epam.module02.task2314;

import java.util.*;

public class Main {
    //14. Натуральное число, в записи которого n цифр, называется числом Армстронга, если сумма его цифр,
    //возведенная в степень n, равна самому числу. Найти все числа Армстронга от 1 до k. Для решения задачи
    //использовать декомпозицию.
    public static void main(String[] args) {
        long k;
        long[] armstrongNumbers;

        k = Long.MAX_VALUE;
        armstrongNumbers = armstrongNumbers(k);

        if (armstrongNumbers != null) {
            System.out.println("Armstrong numbers: ");
            for (long num : armstrongNumbers) {
                System.out.println(num);
            }
        } else {
            System.out.println("Incorrect k : " + k);
        }
    }

    public static long[] armstrongNumbers(long k) {
        long[] result;
        Set<Long> numbers;
        int maxNumbersLength;
        long[][] degreesOfDigits;

        int[] currentDigits;
        int[] currentDigitsArrayValue;
        long currentValueOfPowerFunction;

        if (k < 1) {
            return null;
        }

        numbers = new TreeSet<>();
        maxNumbersLength = Long.toString(k).length();
        degreesOfDigits = fillDegreesOfDigits(maxNumbersLength + 1);

        currentDigits = new int[maxNumbersLength];
        currentDigits[maxNumbersLength - 1] = 1;

        while (currentDigits != null) {
            currentDigitsArrayValue = currentDigits.clone();

            for (int i = sizeOfNumber(currentDigits); i <= maxNumbersLength; i++) {

                currentValueOfPowerFunction = powerFunctionValue(currentDigits, i, degreesOfDigits);

                if (Long.toString(currentValueOfPowerFunction).length() == i
                        && digitsOfTheFunctionValueAreTheSameAsTheDigitsOfTheNumber(currentValueOfPowerFunction, currentDigits)) {

                    numbers.add(currentValueOfPowerFunction);

                }

            }

            currentDigits = nextDigitsArrayValue(currentDigitsArrayValue);
        }

        result = numbers.stream().filter((x) -> (x <= k)).mapToLong(i -> i).sorted().toArray();

        return result;
    }

    private static long[][] fillDegreesOfDigits(int size) {
        long[][] degreesOfDigits;

        degreesOfDigits = new long[10][size];

        for (int i = 1; i < 10; i++) {
            degreesOfDigits[i][0] = 1;
            degreesOfDigits[i][1] = degreesOfDigits[i - 1][1] + 1;

            for (int j = 2; j < degreesOfDigits[0].length; j++) {
                degreesOfDigits[i][j] = degreesOfDigits[i][j - 1] * degreesOfDigits[i][1];
            }

        }

        return degreesOfDigits;
    }

    private static boolean digitsOfTheFunctionValueAreTheSameAsTheDigitsOfTheNumber(long functionValue, int[] digits) {
        int[] functionValueDigits;

        if ((functionValueDigits = digitsArray(functionValue, digits.length)) == null) {
            return false;
        }

        Arrays.sort(functionValueDigits);

        for (int i = 0; i < digits.length; i++) {
            if (digits[i] != functionValueDigits[i]) {
                return false;
            }
        }

        return true;
    }


    private static int sizeOfNumber(int[] digits) {
        int size;

        size = digits.length;

        for (int i = 0; i < digits.length - 1; i++) {

            if (digits[i] == 0) {
                size--;
            } else {
                return size;
            }

        }

        return size;
    }

    private static int[] digitsArray(long number, int arrayLength) {
        int[] digits;

        if (Long.toString(number).length() > arrayLength) {
            return null;
        }

        digits = new int[arrayLength];

        for (int i = arrayLength - 1; number > 0 && i >= 0; i--) {
            digits[i] = (int) (number % 10L);
            number /= 10;
        }

        return digits;
    }

    private static int[] nextDigitsArrayValue(int[] prev) {

        if (prev[prev.length - 1] < 9) {

            prev[prev.length - 1]++;
            return prev;

        }

        for (int i = prev.length - 2; i >= 0; i--) {

            if (prev[i] + 1 <= prev[i + 1]) {
                prev[i]++;

                for (int j = i + 1; j < prev.length; j++) {
                    prev[j] = prev[i];
                }

                return prev;
            }

        }

        return null;
    }

    private static long powerFunctionValue(int[] digits, int numberSize, long[][] degreesOfDigits) {
        long sum = 0;

        for (int i = digits.length - 1; i >= 0; i--) {
            sum += degreesOfDigits[digits[i]][numberSize];
        }

        return sum;
    }
}
