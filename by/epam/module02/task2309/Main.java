package by.epam.module02.task2309;

import java.util.Scanner;

public class Main {
    //9. Даны числа X, Y, Z, Т — длины сторон четырехугольника. Написать метод(методы) вычисления его площади,
    //если угол между сторонами длиной X и Y— прямой.
    public static void main(String[] args) {
        double x, y, z, t;
        double square;

        x = 15;
        y = 6;
        z = 7;
        t = 10;

        square = findTheSquareOfAQuadrangleWithARightAngle(x, y, z, t);

        System.out.println("X = " + x);
        System.out.println("Y = " + y);
        System.out.println("Z = " + z);
        System.out.println("T = " + t);
        System.out.println(square > 0 ? "Square of the quadrangle = " + square : "Quadrangle does not exist!");

    }

    public static double findTheDiagonalOfARightTriangle(double a, double b) {
        return Math.sqrt(a * a + b * b);
    }

    public static double findTheSquareOfARightTriangle(double a, double b) {
        return a * b / 2;
    }

    public static double findTheSquareOfATriangleBy3Sides(double a, double b, double c) {//this method return -1 if the triangle does not exist
        double p;

        if (a + b < c || a + c < b || c + b < a) {
            return -1;
        }

        p = (a + b + c) / 2;

        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }

    public static double findTheSquareOfAQuadrangleWithARightAngle(double x, double y, double z, double t) {
        double squareOfTheRightTriangle;
        double squareOfOtherTriangle;

        squareOfTheRightTriangle = findTheSquareOfARightTriangle(x, y);
        squareOfOtherTriangle = findTheSquareOfATriangleBy3Sides(z, t, findTheDiagonalOfARightTriangle(x, y));

        if (squareOfOtherTriangle < 0) {
            return -1;
        }

        return squareOfTheRightTriangle + squareOfOtherTriangle;
    }

}
