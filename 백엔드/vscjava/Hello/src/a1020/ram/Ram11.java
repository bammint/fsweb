package a1020.ram;

@FunctionalInterface
interface JavaCoding1 {
    void nowCoding(String str);
}

// 매개변수가 있고, 리턴값이 없는 람다식
public class Ram11 {
    public static void main(String[] args) {
        // 객체 선언
        JavaCoding1 jc;
        String str;

        jc = (a) -> {
            System.out.println(a + " Rolling in the deep");
        };
        str = "하루가 멀다하고";
        jc.nowCoding(str);

        // 람다식 바디{}를 생략하고 한 줄에 작성하기
        jc = (a) -> System.out.println(a + " Babe just only you");
        str = "기다리고 있잖아";
        jc.nowCoding(str);

        // 매개변수가 1개인 경우 () 생략할 수 있음
        jc = a -> System.out.println(a + " 기다리고 있어요");
        jc.nowCoding("온종일 난 그대 생각에");
    }

    // ------------------------------------------------------------------
    // jc = new JavaCoding1() {
    // @Override
    // public void nowCoding(String a) {
    // System.out.println(a + " Rolling in the deep");
    // }
    // };
    // str = "하루가 멀다하고";
    // jc.nowCoding(str);

    // // 익명 내부 클래스를 사용하여 바디를 생략하고 한 줄에 작성하기
    // jc = new JavaCoding1() {
    // @Override
    // public void nowCoding(String a) {
    // System.out.println(a + " Babe just only you");
    // }
    // };
    // str = "기다리고 있잖아";
    // jc.nowCoding(str);

    // // 매개변수가 1개인 경우 ()를 생략할 수 있음
    // jc = new JavaCoding1() {
    // @Override
    // public void nowCoding(String a) {
    // System.out.println(a + " 기다리고 있어요");
    // }
    // };
    // jc.nowCoding("온종일 난 그대 생각에");

}