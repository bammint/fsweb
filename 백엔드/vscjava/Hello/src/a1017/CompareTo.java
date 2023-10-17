package a1017;

public class CompareTo {
    public static void main(String[] args) {
        String str = new String("abcd");
        System.out.println("원본 문자열: " + str);
        
        System.out.println(str.compareTo("bcef"));
        System.out.println(str.compareTo("abcd"));
        System.out.println(str.compareTo("Abcd"));
        System.out.println(str.compareToIgnoreCase("Abcd"));

        // 일치하면 0
    }
}
