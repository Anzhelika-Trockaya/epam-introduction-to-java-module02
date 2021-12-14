package by.epam.module02.task2317;

public class Main {
    //17. Из заданного числа вычли сумму его цифр. Из результата вновь вычли сумму его цифр и т.д. Сколько таких
    //действий надо произвести, чтобы получился нуль? Для решения задачи использовать декомпозицию.
    public static void main(String[] args) {
        int number;
        number = 100;

        if (number < 1) {
            System.out.println("Number must be natural!");
            return;
        }

        System.out.println("Number of actions = " + numberOfActions(number));
    }

    public static int numberOfActions(int number) {
        int numberOfSubtractions;

        numberOfSubtractions = 0;
        while (number > 0) {
            number -= sumOfDigits(number);
            numberOfSubtractions++;
        }

        return numberOfSubtractions;
    }

    public static int sumOfDigits(int number) {
        int sum = 0;

        while (number > 0) {
            sum += number % 10;
            number /= 10;
        }

        return sum;
    }
}
