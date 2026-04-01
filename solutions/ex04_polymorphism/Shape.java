package ex04_polymorphism;

public class Shape {
    protected String color;


    public double calculateArea() {
        return 0;
    }

    public double calculatePerimeter() {
        return 0.0;
    }

    public String getColor() {
        return this.color;
    }

    public void displayInfo() {
        System.out.println("Color: " + getColor());
        System.out.println("Area: " + calculateArea());
        System.out.println("Perimeter: " + calculatePerimeter());
    }
}
