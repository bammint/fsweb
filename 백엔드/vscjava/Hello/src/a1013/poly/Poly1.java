package a1013.poly;

import a1013.poly.Archer;

public class Poly1 {
    public static void main(String[] args) {
        Archer archer1 = new Archer("궁수1", "상");
        Archer archer2 = new Archer("궁수2", "중");
        System.out.println(archer1==archer2);
        System.out.println(archer1.equals(archer2));
    }
}
