package ru.javatrain.main;
public class Sandbox {
    public static void main(String[] args) {
        Point p1 = new Point(2, 3);
        Point p2 = new Point(6, 1);

        double d = Point.distance(p1, p2);

        System.out.println("Расстояние между точками = " + d);
    }
}