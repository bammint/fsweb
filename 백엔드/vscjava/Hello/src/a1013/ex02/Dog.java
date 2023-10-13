package a1013.ex02;

public class Dog extends Animal {
    // 추상 메소드 재정의
    @Override
    public void sound(){
        System.out.println("멍멍");
    }
}
