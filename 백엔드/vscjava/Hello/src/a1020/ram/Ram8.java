package a1020.ram;

interface Greeting{
    void greet();
}

public class Ram8 {
    public static void main(String[] args) {
        // 익명 클래스를 사용하여 Greeting 인터페이스의 구현체를 생성
        Greeting anonymusGreeting = new Greeting() {
            @Override
            public void greet(){
                System.out.println("안녕하세요, 익명 클래스로 생성된 객체입니다");
            }
        };
        // 익명 클래스로 생성된 객체의 메서드 호출
        anonymusGreeting.greet();
    }
}
