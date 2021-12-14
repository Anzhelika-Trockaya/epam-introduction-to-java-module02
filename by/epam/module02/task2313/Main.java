package by.epam.module02.task2313;

public class Main {
    //13. Два простых числа называются «близнецами», если они отличаются друг от друга на 2 (например, 41 и 43).
    //Найти и напечатать все пары «близнецов» из отрезка [n,2n], где n - заданное натуральное число больше 2. Для
    //решения задачи использовать декомпозицию.
    public static void main(String[] args) {
        int n;

        n = 100;

        printTwins(n);
    }

    public static void printTwins(int n) {
        if (n <= Integer.MAX_VALUE / 2 && n > 2) {

            System.out.println("Twins from segment [" + n + ";" + (2 * n) + "] :");

            for (int number = n; number <= 2 * n - 2; number++) {
                System.out.println(number + " - " + (number + 2));
            }

        } else if (n <= 2) {

            System.out.println("Incorrect n.");

        } else {

            System.out.println("n is too big.");

        }
    }
}
