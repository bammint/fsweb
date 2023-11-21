package a1020.ram;

@FunctionalInterface
interface JavaCoding2 {
    String nowCoding();
}

// 매개변수는 없고 리턴값은 있는 람다식
public class Ram12 {
    public static void main(String[] args) {
        // 객체 선언
        JavaCoding2 jc;

        String str1 = "그 날을 잊지 못해 baby";
        String str2 = "날 보며 환히 웃던 너의 미소에";
        String str3 = "홀린 듯 I'm fall in love";

        jc = () -> {
            return str1;
        };
        System.out.println(jc.nowCoding());

        jc = () -> {
            return str2;
        };
        System.out.println(jc.nowCoding());

        // 실행코드가 return 만 있는 경우 {}와 return문 생략가능
        jc = () -> str3;
        System.out.println(jc.nowCoding());
    }
    // --------------------------------------------------------------------
    // jc = new JavaCoding2() {
    // @Override
    // public String nowCoding() {
    // return str1;
    // }
    // };
    // System.out.println(jc.nowCoding());

    // jc = new JavaCoding2() {
    // @Override
    // public String nowCoding() {
    // return str2;
    // }
    // };
    // System.out.println(jc.nowCoding());

    // jc = new JavaCoding2() {
    // @Override
    // public String nowCoding() {
    // return str3;
    // }
    // };
    // System.out.println(jc.nowCoding());

}