package a1017;

public class Case {
    public static void main(String[] args) {
        String str = new String("Java");

        System.out.println("원본 문자열 : " + str);

        System.out.println(str.toLowerCase());

        System.out.println(str.toUpperCase());

        System.out.println("두 메소드 호출 후 원본 문자열 : " + str);
    }
    // length() - 문자길이
    // isEmpty() - 해당 문자열의 길이가 0이면 true를 반환하고, 아니면 false를 반환함
}
