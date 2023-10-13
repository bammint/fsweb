package a1013.abs;

// 추상클래스
abstract class Shape {
    public abstract double getArea();
}

class Rectangle extends Shape {
    private double line;

    public Rectangle(double line){
        this.line = line;
    }
    public double getArea(){
        return line*line;
    }
}