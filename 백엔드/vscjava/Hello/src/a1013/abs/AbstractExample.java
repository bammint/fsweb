package a1013.abs;

// 추상클래스
abstract class Shape {
    // 추상 메서드(하위클래스에서 구현해야함)
    public abstract double getArea();
}

// Shape 추상 클래스를 상속받는 구채 클래스(하위 클래스)
class Circle extends Shape {

    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getArea() {
        return Math.PI * radius * radius;
    }
}

public class AbstractExample {
    public static void main(String[] args) {
        // Circle 객체 생성
        Circle circle = new Circle(5.0);
        System.out.println("원의 넓이: " + circle.getArea());

        // Rectangle 객체생성
        Rectangle rectangle = new Rectangle(4.0);
        System.out.println("사각형의 넓이: " + rectangle.getArea());
    }
}
