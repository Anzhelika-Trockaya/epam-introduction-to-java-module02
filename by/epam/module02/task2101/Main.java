package by.epam.module02.task2101;

public class Main {
    //Дана матрица. Вывести на экран все нечетные столбцы, у которых первый элемент больше последнего.
    public static void main(String[] args) {
        int[][] a = {{1, 5, 6, 2, 4, 5}, {-1, 5, 8, -9, 3, 5}, {21, 56, 1, 0, 5, 9}, {9, -10, 5, 6, 3, 2}};

        for (int[] line : a) {
            for (int element : line) {
                System.out.print(element + " ");
            }
            System.out.println();
        }

        System.out.println("Odd columns in which the first element is greater than the last: ");

        for (int j = 0; j < a[0].length; j += 2) {

            if (a[0][j] > a[a.length - 1][j]) {

                for (int i = 0; i < a.length; i++) {
                    System.out.println(a[i][j]);
                }
                System.out.println();

            }

        }
    }
}
