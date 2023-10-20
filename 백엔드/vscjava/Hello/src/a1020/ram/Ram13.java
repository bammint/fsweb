package a1020.ram;

@FunctionalInterface
interface JavaCoding3 {
    String nowCoding(String s);
}


// 매개변수가 있고, 리턴값이 있는 람다식
public class Ram13 {
    public static void main(String[] args) {
        // 객체 선언
        JavaCoding3 jc;

        String str1 = " 너의 생각뿐이야";
        String str2 = " 미치겠어";
        String str3 = " 보고 싶어";

        jc = (s) -> {
            return s + str1;
        };
        System.out.println(jc.nowCoding("온통"));

        jc = (s) -> {
            return s + str2;
        };
        System.out.println(jc.nowCoding("나도"));

        jc = s -> s + str3;
        System.out.println(jc.nowCoding("너무"));
    }
}