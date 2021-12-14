package by.epam.module02.task2303;

public class Main {
    //3. Вычислить площадь правильного шестиугольника со стороной а, используя метод вычисления площади
    //треугольника.
    public static void main(String[] args) {
        double a;
        double areaOfTheHexagon;

        a = 0.5;
        System.out.println("Side of a regular hexagon = " + a);

        areaOfTheHexagon = areaOfTheRegularHexagon(a);
        System.out.println("Area = " + areaOfTheHexagon);
    }

    public static double areaOfTheRegularHexagon(double side) {
        if (side > 0) {
            return 6 * areaOfTheRegularTriangle(side);
        } else {
            throw new IllegalArgumentException("Side must be a positive number!");
        }
    }

    public static double areaOfTheRegularTriangle(double side) {
        if (side > 0) {
            return side * side * Math.sqrt(3) / 4;
        } else {
            throw new IllegalArgumentException("Side must be a positive number!");
        }
    }
}
