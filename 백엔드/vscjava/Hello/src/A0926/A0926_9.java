package A0926;

public class A0926_9 {
    public static void main(String[] args) {
        int x = 10;
        int y = 10;
        int z;

        x++;
        ++x;
        System.out.println("x=" + x);
        System.out.println("-------------------------");

        y--;
        --y;
        System.out.println("y=" + y);
        System.out.println("-------------------------");

        z = x++;
        System.out.println("z=" + z);
        System.out.println("x=" + x);

        z = ++x;
        System.out.println("z=" + z);
        System.out.println("x=" + x);
        System.out.println("-------------------------");
        //14 14
        z = ++x + y++;
        System.out.println("z=" + z);
        System.out.println("x=" + x);
        System.out.println("y=" + y);
        // 23 = 15 + 8++
    }
}
