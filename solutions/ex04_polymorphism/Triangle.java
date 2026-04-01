package ex04_polymorphism;

public class Triangle extends Shape {
    private double base;
    private double height;
    private double side1;
    private double side2;

    public Triangle(String color, double base, double height, double s1, double s2) {
        super(color);

        this.base = base;
        this.height = height;
        this.side1 = s1;
        this.side2 = s2;
    }

    @Override
    public double calculateArea() {
        return 0.5 * base * height;
    }

    @Override
    public double calculatePerimeter() {
        return base + side1 + side2;
    }
}
