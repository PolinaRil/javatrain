package ru.javatrain.main;
public class MyFirstProgram {
    public static void main(String[] args) {
        hello("world");
        hello("user");

        Square s = new Square(5);

        System.out.println("Площадь квадрата со стороной " + s.l + "=" + s.area());

        Rectangle r = new Rectangle(4,6);

        System.out.println("Площадь прямоугольника со сторонами " + r.a + " и " + r.b + "=" + r.area());

        Point p1 = new Point(2, 3);

        System.out.println(p1.x);

        p1.x = 10;

        System.out.println(p1.x);

        Point p2 = new Point(6, 1);

        System.out.println(p2.x);
    }

    public static void hello(String somebody) {
        System.out.println("Hello," + somebody + "!");
    }
}