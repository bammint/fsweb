package a1013.abc;

// 인터페이스는 추상 메서드만을 정의
// 다중 상속이 가능
interface Shape{
    public abstract double getArea();
    public abstract void display();
}
// 인터페이스를 구현하는 클래스
class Circle implements Shape{
    private double radius;

    public Circle(double radius){
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public void display() {
        System.out.println("원의 면적: " + getArea());
    }
}
// 인터페이스를 구현하는 클래스 2
class Rectangle implements Shape {
    private double width;
    private double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    // 인터페이스의 추상 메서드 구현
    public double getArea() {
        return width * height;
    }

    public void display() {
        System.out.println("사각형의 면적: " + getArea());
    }
}

public class InterfaceExample {
    public static void main(String[] args) {
        // Circle 객체 생성
        Circle circle = new Circle(5.0);
        circle.display(); // 인터페이스 메서드 호출

        // Rectangle 객체생성
        Rectangle rectangle = new Rectangle(4.0,6.0);
        rectangle.display(); // 인터페이스 메서드 호출
    }
}
