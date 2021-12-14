package by.epam.module02.task2102;

public class Main {
    //2. Дана квадратная матрица. Вывести на экран элементы, стоящие на диагонали.
    public static void main(String[] args) {
        int[][] a = {{1, 5, 6, 2}, {-1, 5, 8, -9}, {21, 56, 1, 0}, {9, -10, 5, 6}};

        for (int[] line : a) {
            for (int value : line) {
                System.out.print(value + " ");
            }
            System.out.println();
        }

        System.out.print("Elements of the primary diagonal: ");

        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i][i] + " ");
        }

        System.out.print("\nElements of the secondary diagonal: ");

        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i][a.length - 1 - i] + " ");
        }
    }
}
