package by.epam.module02.task2304;

import java.util.ArrayList;
import java.util.List;

public class Main {
    //4. На плоскости заданы своими координатами n точек. Написать метод(методы), определяющие, между какими
    //из пар точек самое большое расстояние. Указание. Координаты точек занести в массив.
    public static void main(String[] args) {
        double[][] points;
        double[][][] pointPairsWithMaximumDistanceBetween;

        points = new double[][]{{101, -50}, {101, 0}, {90, -50}, {90, 0}, {0, 0}};

        System.out.println("Points: ");
        for (double[] point : points) {
            System.out.println("(" + point[0] + " ; " + point[1] + ")");
        }

        pointPairsWithMaximumDistanceBetween = getPairOfPointsWithMaximumDistanceBetween(points);

        System.out.println("Pairs of points with maximum distance between: ");

        for (double[][] pointPair : pointPairsWithMaximumDistanceBetween) {
            for (double[] point : pointPair) {
                System.out.print("(" + point[0] + " ; " + point[1] + ")  ");
            }

            System.out.println();
        }
    }

    public static double distanceBetweenPoints(double[] a, double[] b) {
        return Math.sqrt(Math.pow(b[0] - a[0], 2) + Math.pow(b[1] - a[1], 2));
    }

    public static double findMaxDistance(double[][] points) {
        double currentDistance;
        double maxDistance = 0;

        for (int i = 0; i < points.length - 1; i++) {
            for (int j = i + 1; j < points.length; j++) {

                if ((currentDistance = distanceBetweenPoints(points[i], points[j])) > maxDistance) {
                    maxDistance = currentDistance;
                }

            }
        }

        return maxDistance;
    }

    public static double[][][] getPairOfPointsWithMaximumDistanceBetween(double[][] points) {
        double maxDistance;
        List<double[][]> pointPairsWithMaxDistance = new ArrayList<>();

        maxDistance = findMaxDistance(points);

        for (int i = 0; i < points.length - 1; i++) {
            for (int j = i + 1; j < points.length; j++) {

                if (distanceBetweenPoints(points[i], points[j]) == maxDistance) {

                    pointPairsWithMaxDistance.add(new double[][]{points[i], points[j]});

                }
            }
        }

        return pointPairsWithMaxDistance.toArray(new double[pointPairsWithMaxDistance.size()][2][2]);
    }
}
