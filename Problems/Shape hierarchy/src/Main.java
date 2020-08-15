abstract class Shape {

    abstract double getPerimeter();

    abstract double getArea();
}
class Triangle extends Shape {
    double a;
    double b;
    double c;
    public Triangle(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;

    }
    @Override
    public double getPerimeter() {
        return a + b + c;
    }
    @Override
    public double getArea() {
        double p = getPerimeter();
        return p/2 * (p/2 - a) * (p/2 - b) * (p/2 - c);
    }
}

class Rectangle extends Shape {
    double a;
    double b;
    public Rectangle(double a, double b) {
        this.a = a;
        this.b = b;
    }
    @Override
    public double getPerimeter() {
        return (a + b)*2;
    }
    @Override
    public double getArea() {
        return a*b;
    }
}

class Circle extends Shape {
    double radius;
    public Circle(double radius) {
        this.radius = radius;
    }
    @Override
    public double getPerimeter() {
        return Math.PI * radius * 2;
    }
    @Override
    public double getArea() {
        return Math.PI * radius *radius;
    }
}