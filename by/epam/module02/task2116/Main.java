package by.epam.module02.task2116;

import java.util.Scanner;

public class Main {
    // 16. Магическим квадратом порядка n называется квадратная матрица размера nxn, составленная из чисел
    // 1, 2, 3,...,n^2 так, что суммы по каждому столбцу, каждой строке и каждой из двух больших диагоналей равны между
    //собой. Построить такой квадрат. Пример магического квадрата порядка 3:
    // 6 1 8
    //7 5 3
    //2 9 4
    // private static int[][] magicSquare;
    //private static int n;

    public static void main(String[] args) {
        int[][] magicSquare;
        int n;

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter order of the magical square (n>2) : ");
        n = scanner.nextInt();

        if (n < 3) {
            System.out.println("Incorrect order!");
            return;
        }

        if (n % 2 != 0) {
            magicSquare = generateASquareOfOddOrder(n);//method of Claude Basche de Mesiriac
        } else {
            magicSquare = generateASquareOfEvenOrder(n);//method of framing squares
        }

        printSquare(magicSquare);

        if (isMagicalSquare(magicSquare)) {
            System.out.println("It is a magical square!");
        } else {
            System.out.println("It is not magical square!");
        }
    }

    public static void printSquare(int[][] magicSquare) {
        for (int i = 0; i < magicSquare.length; i++) {
            for (int j = 0; j < magicSquare.length; j++) {
                System.out.print(magicSquare[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int[][] generateASquareOfOddOrder(int n) {
        int[][] magicSquare;
        int[][] tempSquare;

        tempSquare = new int[2 * n - 1][2 * n - 1];

        tempSquare = startFillingTempSquare(tempSquare, n);
        tempSquare = overlayTheUpperTriangle(tempSquare, n);
        tempSquare = overlayTheBottomTriangle(tempSquare, n);
        tempSquare = overlayTheLeftTriangle(tempSquare, n);
        tempSquare = overlayTheRightTriangle(tempSquare, n);

        magicSquare = getMagicSquare(tempSquare, n);

        return magicSquare;
    } //method of Claude Basche de Mesiriac

    private static int[][] startFillingTempSquare(int[][] tempSquare, int n) {
        int theNextValue = 1;

        for (int k = 0; k < n; k++) {
            for (int i = k; i < k + n; i++) {
                tempSquare[i][n - 1 + i - 2 * k] = theNextValue;
                theNextValue++;
            }
        }

        return tempSquare;
    }

    private static int[][] overlayTheUpperTriangle(int[][] tempSquare, int n) {
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < 2 * n - 1; j++) {
                if (tempSquare[i][j] != 0) {
                    tempSquare[n + i][j] = tempSquare[i][j];
                }
            }
        }

        return tempSquare;
    }

    private static int[][] overlayTheBottomTriangle(int[][] tempSquare, int n) {
        for (int i = 2 * n - 1 - n / 2; i < 2 * n - 1; i++) {
            for (int j = 0; j < 2 * n - 1; j++) {
                if (tempSquare[i][j] != 0) {
                    tempSquare[i - n][j] = tempSquare[i][j];
                }
            }
        }

        return tempSquare;
    }

    private static int[][] overlayTheLeftTriangle(int[][] tempSquare, int n) {
        for (int j = 0; j < n / 2; j++) {
            for (int i = 0; i < 2 * n - 1; i++) {
                if (tempSquare[i][j] != 0) {
                    tempSquare[i][n + j] = tempSquare[i][j];
                }
            }
        }

        return tempSquare;
    }

    private static int[][] overlayTheRightTriangle(int[][] tempSquare, int n) {
        for (int j = 2 * n - 1 - n / 2; j < 2 * n - 1; j++) {
            for (int i = 0; i < 2 * n - 1; i++) {
                if (tempSquare[i][j] != 0) {
                    tempSquare[i][j - n] = tempSquare[i][j];
                }
            }
        }

        return tempSquare;
    }

    private static int[][] getMagicSquare(int[][] tempSquare, int n) {
        int[][] magicSquare;

        magicSquare = new int[n][n];

        for (int i = 0; i < n; i++) {
            System.arraycopy(tempSquare[i + n / 2], n / 2, magicSquare[i], 0, n);
        }

        return magicSquare;
    }

    //method of framing squares
    public static int[][] generateASquareOfEvenOrder(int n) {
        int[][] magicSquare;

        magicSquare = new int[n][n];

        magicSquare = fillingTheCenterOfMagicSquareOfEvenOrder(magicSquare);//size 4*4

        for (int order = 6; order <= n; order += 2) {
            if (order % 4 != 0) {
                magicSquare = fillingTheNextFrameOfEvenOddOrder(magicSquare, order);
            } else {
                magicSquare = fillingTheNextFrameOfEvenEvenOrder(magicSquare, order);
            }
        }

        return magicSquare;

    }

    private static int[][] fillingTheCenterOfMagicSquareOfEvenOrder(int[][] magicSquare) {
        int n;
        int[][] magicSquareOfOrder4 = {{1, 10, 15, 8}, {16, 7, 2, 9}, {6, 13, 12, 3}, {11, 4, 5, 14}};

        n = magicSquare.length;

        for (int i = n / 2 - 2; i < n / 2 + 2; i++) {
            for (int j = n / 2 - 2; j < n / 2 + 2; j++) {
                magicSquare[i][j] = magicSquareOfOrder4[i - n / 2 + 2][j - n / 2 + 2];
            }
        }

        return magicSquare;
    }

    private static int[][] fillingTheNextFrameOfEvenEvenOrder(int[][] magicSquare, int order) {
        int n;
        int k;
        int d;
        int m;

        n = magicSquare.length;
        k = (n - order) / 2 + 1;//displacement coefficient
        d = order * order + 1;
        m = order / 2;

        magicSquare = increaseTheCentralElementsOfEvenEvenFrame(magicSquare, order, k);
        magicSquare = fillTheFirstRowOfEvenEvenFrame(magicSquare, k, m, d);
        magicSquare = fillCornersElementsOfEvenEvenFrame(magicSquare, k, m, d);
        magicSquare = fillTheFirstColumnOfEvenEvenFrame(magicSquare, k, m, d);
        magicSquare = fillTheLastRowOfEvenEvenFrame(magicSquare, k, d);
        magicSquare = fillTheLastColumnOfEvenEvenFrame(magicSquare, k, d);

        return magicSquare;
    }

    private static int[][] increaseTheCentralElementsOfEvenEvenFrame(int[][] magicSquare, int order, int k) {
        int n;

        n = magicSquare.length;

        for (int i = k; i < n - k; i++) {
            for (int j = k; j < n - k; j++) {
                magicSquare[i][j] += 2 * (order - 1);
            }
        }

        return magicSquare;
    }

    private static int[][] fillTheFirstRowOfEvenEvenFrame(int[][] magicSquare, int k, int m, int d) {
        int nextIndexOfMagicSquare;

        nextIndexOfMagicSquare = k - 1;

        for (int i = 1; i <= m / 2; i++) {
            magicSquare[k - 1][nextIndexOfMagicSquare] = 4 * i - 3;
            nextIndexOfMagicSquare++;
        }

        for (int i = 1; i <= m / 2; i++) {
            magicSquare[k - 1][nextIndexOfMagicSquare] = 4 * i;
            nextIndexOfMagicSquare++;
        }

        for (int i = 1; i <= m / 2; i++) {
            magicSquare[k - 1][nextIndexOfMagicSquare] = d - 4 * i + 2;
            nextIndexOfMagicSquare++;
        }

        for (int i = 1; i <= m / 2; i++) {
            magicSquare[k - 1][nextIndexOfMagicSquare] = d - 4 * i + 1;
            nextIndexOfMagicSquare++;
        }

        return magicSquare;
    }

    private static int[][] fillCornersElementsOfEvenEvenFrame(int[][] magicSquare, int k, int m, int d) {
        int n;

        n = magicSquare.length;

        for (int j = k - 1; j < n - k; j++) {

            if (m % 4 == 0) {

                if (magicSquare[k - 1][j] == m) {

                    magicSquare[k - 1][j] = magicSquare[k - 1][k - 1];
                    magicSquare[k - 1][k - 1] = m;

                }
                if (magicSquare[k - 1][j] == 1) {

                    magicSquare[k - 1][j] = magicSquare[k - 1][n - k];
                    magicSquare[k - 1][n - k] = 1;

                }

            } else {

                if (magicSquare[k - 1][j] == m + 3) {

                    magicSquare[k - 1][j] = magicSquare[k - 1][k - 1];
                    magicSquare[k - 1][k - 1] = m + 3;

                }
                if (magicSquare[k - 1][j] == 4) {

                    magicSquare[k - 1][j] = magicSquare[k - 1][n - k];
                    magicSquare[k - 1][n - k] = 4;

                }

            }
        }

        magicSquare[n - k][n - k] = d - magicSquare[k - 1][k - 1];
        magicSquare[n - k][k - 1] = d - magicSquare[k - 1][n - k];

        return magicSquare;
    }

    private static int[][] fillTheFirstColumnOfEvenEvenFrame(int[][] magicSquare, int k, int m, int d) {
        int nextIndexOfMagicSquare;

        nextIndexOfMagicSquare = k;

        for (int i = 1; i <= m - 1; i++) {
            magicSquare[nextIndexOfMagicSquare][k - 1] = 2 * m + 2 * i - 1;
            nextIndexOfMagicSquare++;
        }

        for (int i = 1; i <= m - 1; i++) {
            magicSquare[nextIndexOfMagicSquare][k - 1] = d - 2 * m - 2 * i;
            nextIndexOfMagicSquare++;
        }


        return magicSquare;
    }

    private static int[][] fillTheLastRowOfEvenEvenFrame(int[][] magicSquare, int k, int d) {
        int n;

        n = magicSquare.length;

        for (int j = k; j < n - k; j++) {
            magicSquare[n - k][j] = d - magicSquare[k - 1][j];
        }

        return magicSquare;
    }

    private static int[][] fillTheLastColumnOfEvenEvenFrame(int[][] magicSquare, int k, int d) {
        int n;

        n = magicSquare.length;

        for (int i = k; i < n - k; i++) {
            magicSquare[i][n - k] = d - magicSquare[i][k - 1];
        }

        return magicSquare;
    }

    private static int[][] fillingTheNextFrameOfEvenOddOrder(int[][] magicSquare, int order) {
        int n;
        int k;
        int d;
        int m;
        int nextIndexOfMagicSquare;

        n = magicSquare.length;
        k = (n - order) / 2 + 1;//displacement coefficient
        d = order * order + 1;
        m = order / 2;

        magicSquare = increaseTheCentralElementsOfEvenOddFrame(magicSquare, order, k);
        magicSquare = fillCornersElementsOfEvenOddFrame(magicSquare, k, m, d);
        magicSquare = fillTheFirstRowOfEvenOddFrame(magicSquare, k, m, d);
        magicSquare = fillTheFirstColumnOfEvenOddFrame(magicSquare, k, m, d);
        magicSquare = fillTheLastRowOfEvenOddFrame(magicSquare, k, d);
        magicSquare = fillTheLastColumnOfEvenOddFrame(magicSquare, k, d);

        return magicSquare;
    }

    private static int[][] increaseTheCentralElementsOfEvenOddFrame(int[][] magicSquare, int order, int k) {
        int n;

        n = magicSquare.length;

        for (int i = k; i < n - k; i++) {
            for (int j = k; j < n - k; j++) {
                magicSquare[i][j] += 2 * (order - 1);
            }
        }

        return magicSquare;
    }

    private static int[][] fillCornersElementsOfEvenOddFrame(int[][] magicSquare, int k, int m, int d) {
        int n;

        n = magicSquare.length;

        magicSquare[k - 1][n - k] = 1;
        magicSquare[n - k][k - 1] = d - 1;
        magicSquare[k - 1][k - 1] = 3 * m - 1;
        magicSquare[n - k][n - k] = d - 3 * m + 1;

        return magicSquare;
    }

    private static int[][] fillTheFirstRowOfEvenOddFrame(int[][] magicSquare, int k, int m, int d) {
        int nextIndexOfMagicSquare;

        nextIndexOfMagicSquare = k;

        for (int i = 1; i <= m - 2; i++) {
            magicSquare[k - 1][nextIndexOfMagicSquare] = 2 * i + 1;
            nextIndexOfMagicSquare++;
        }

        for (int i = 1; i <= m; i++) {
            magicSquare[k - 1][nextIndexOfMagicSquare] = d - 2 * i;
            nextIndexOfMagicSquare++;
        }

        return magicSquare;
    }

    private static int[][] fillTheFirstColumnOfEvenOddFrame(int[][] magicSquare, int k, int m, int d) {
        int nextIndexOfMagicSquare;

        nextIndexOfMagicSquare = k;

        magicSquare[nextIndexOfMagicSquare][k - 1] = 2 * m - 1;
        nextIndexOfMagicSquare++;

        for (int i = 1; i <= m / 2; i++) {
            magicSquare[nextIndexOfMagicSquare][k - 1] = 3 * m - 1 - i;
            nextIndexOfMagicSquare++;
        }

        for (int i = 1; i <= m / 2 + 1; i++) {
            magicSquare[nextIndexOfMagicSquare][k - 1] = d - 4 * m + 1 + i;
            nextIndexOfMagicSquare++;
        }

        for (int i = 1; i <= m / 2 - 1; i++) {
            magicSquare[nextIndexOfMagicSquare][k - 1] = 3 * m - 1 + i;
            nextIndexOfMagicSquare++;
        }

        for (int i = 1; i <= m / 2 - 1; i++) {
            magicSquare[nextIndexOfMagicSquare][k - 1] = d - 2 * m - i;
            nextIndexOfMagicSquare++;
        }

        return magicSquare;
    }

    private static int[][] fillTheLastRowOfEvenOddFrame(int[][] magicSquare, int k, int d) {
        int n;

        n = magicSquare.length;

        for (int j = k; j < n - k; j++) {
            magicSquare[n - k][j] = d - magicSquare[k - 1][j];
        }

        return magicSquare;
    }

    private static int[][] fillTheLastColumnOfEvenOddFrame(int[][] magicSquare, int k, int d) {
        int n;

        n = magicSquare.length;

        for (int i = k; i < n - k; i++) {//step 6: filling the last column
            magicSquare[i][n - k] = d - magicSquare[i][k - 1];
        }

        return magicSquare;
    }

    //methods to check
    private static boolean isMagicalSquare(int[][] magicSquare) {
        return areTheSumsInTheColumnsAndRowsEqual(magicSquare)
                && areTheSumsInTheDiagonalsEqual(magicSquare)
                && areInTheSquareAllNumbersFrom1ToNSquared(magicSquare);
    }

    private static boolean areTheSumsInTheColumnsAndRowsEqual(int[][] magicSquare) {
        int n;
        int sum;
        int sumInTheRow;
        int sumInTheColumn;

        n = magicSquare.length;
        sum = (n % 2 != 0) ? (n * (n * n + 1) / 2) : (n + ((n + 1) * n * (n - 1) / 2));

        for (int i = 0; i < n; i++) {
            sumInTheRow = 0;
            sumInTheColumn = 0;

            for (int j = 0; j < n; j++) {
                sumInTheRow += magicSquare[i][j];
                sumInTheColumn += magicSquare[j][i];
            }

            if (sumInTheRow != sum || sumInTheColumn != sum) {
                return false;
            }
        }

        return true;
    }

    private static boolean areTheSumsInTheDiagonalsEqual(int[][] magicSquare) {
        int n;
        int sum;
        int sumInTheMainDiagonal = 0;
        int sumInTheSecondaryDiagonal = 0;

        n = magicSquare.length;
        sum = (n % 2 != 0) ? (n * (n * n + 1) / 2) : (n + ((n + 1) * n * (n - 1) / 2));

        for (int i = 0; i < n; i++) {
            sumInTheMainDiagonal += magicSquare[i][i];
            sumInTheSecondaryDiagonal += magicSquare[i][n - 1 - i];
        }

        return sumInTheMainDiagonal == sum && sumInTheSecondaryDiagonal == sum;
    }

    private static boolean areInTheSquareAllNumbersFrom1ToNSquared(int[][] magicSquare) {
        boolean isInTheSquareNumber;
        int n;

        n = magicSquare.length;

        for (int number = 1; number < n * n + 1; number++) {
            isInTheSquareNumber = false;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {

                    if (magicSquare[i][j] == number) {
                        isInTheSquareNumber = true;
                    }

                }
            }

            if (!isInTheSquareNumber) {
                return false;
            }
        }

        return true;
    }

}
