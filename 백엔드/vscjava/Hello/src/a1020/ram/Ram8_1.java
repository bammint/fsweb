package a1020.ram;

interface Greeting{
    void greet();
}

public class Ram8_1 {
    public static void main(String[] args) {
        // 익명 클래스를 사용하여 Greeting 인터페이스의 구현체를 생성
        Greeting lambdaGreeting =  () -> System.out.println("안녕하세요, 람다식으로 생성된 객체입니다");

        // 익명 클래스로 생성된 객체의 메서드 호출
        lambdaGreeting.greet();
    }
}
