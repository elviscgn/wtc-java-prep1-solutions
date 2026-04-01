package ex04_polymorphism;

public class Rectangle extends Shape {
    private double length;
    private double height;

    public Rectangle(String color, double l, double h) {
        super(color);
        length = l;
        height = h;
    }

    @Override
    public double calculateArea() {
        return length * height;
    }

    @Override
    public double calculatePerimeter() {
        return 2 * length + 2 * height;
    }
}
