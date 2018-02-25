package ru.stqa.pft.sandbox;

public class MyFirstProgram {
    public static void main(String[] args) {
        hello("world!");
        hello("user!");
        Square square = new Square(5.0);

        System.out.println("Площадь квадрата со стороной " + square.l + " = " + square.area());

        Rectangle r = new Rectangle(4.0, 5.0);
        System.out.println("Площадь прямоугольника со стороной " + r.a + " и " + r.b + " = " + r.area());
    }

    public static void hello(String somebody) {
        System.out.println("Hello, " + somebody);
    }


}