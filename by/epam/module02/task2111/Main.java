package by.epam.module02.task2111;

public class Main {
    //11. Матрицу 10x20 заполнить случайными числами от 0 до 15. Вывести на экран саму матрицу и номера строк, в
    //которых число 5 встречается три и более раз
    public static void main(String[] args) {
        int[][] a = new int[10][20];
        int count5InTheRow;

        for (int i = 0; i < 10; i++) {//filling the matrix
            for (int j = 0; j < 20; j++) {
                a[i][j] = (int) (Math.random() * 16);
            }
        }

        for (int i = 0; i < 10; i++) {//print matrix
            for (int j = 0; j < 20; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }

        System.out.print("Row numbers where 5 occurs 3 or more times: ");

        for (int i = 0; i < 10; i++) {
            count5InTheRow = 0;

            for (int j = 0; j < 20; j++) {
                if (a[i][j] == 5) {
                    count5InTheRow++;
                }
            }

            if (count5InTheRow > 2) {
                System.out.print(i + " ");
            }
        }
    }
}
