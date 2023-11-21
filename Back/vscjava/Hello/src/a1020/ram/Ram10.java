package a1020.ram;

@FunctionalInterface
interface JavaCoding {
    void nowCoding();
}

// 매개변수가 없고, 리턴값도 없음
public class Ram10 {
    public static void main(String[] args) {
        // 객체 선언
        JavaCoding jc;

        // {} 실행코드 뒤에 세미콜론(;)을 붙여야한다
        jc = () -> {
            System.out.println("Rollin' Rollin' Rollin' Rollin'");
        };
        jc.nowCoding();

        // {} 실행코드가 1줄인경우 {} 생략가능
        jc = () -> System.out.println("Rollin' Rollin' Rollin' Rollin'");
        jc.nowCoding();
        // -------------------------------------------------------------
        // 익명 내부 클래스
        // jc = new JavaCoding() {
        //     @Override
        //     public void nowCoding() {
        //         System.out.println("Rollin' Rollin' Rollin' Rollin'");
        //     }
        // };
        // jc.nowCoding();

        // // 익명 내부 클래스 (한 줄 코드)
        // jc = new JavaCoding() {
        //     @Override
        //     public void nowCoding() {
        //         System.out.println("Rollin' Rollin' Rollin' Rollin'");
        //     }
        // };
        // jc.nowCoding();

    }
}