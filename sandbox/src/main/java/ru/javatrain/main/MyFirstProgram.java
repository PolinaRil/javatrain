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
        Point p2 = new Point(6, 1);

        double d = distance(p1, p2);

        System.out.println("Расстояние между точками = " + d);
    }

    public static void hello(String somebody) {
        System.out.println("Hello," + somebody + "!");
    }

   public static double distance (Point p1, Point p2) {
        return Math.sqrt((p1.x - p2.x)*(p1.x - p2.x) + (p1.y - p2.y)*(p1.y - p2.y));
   }
}