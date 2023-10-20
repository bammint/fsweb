package a1020.ram;

interface Calculator{
    int sum(int a, int b);
}

public class Ram2 {
    public static void main(String[] args) {
        Calculator mc = (int a,int b) -> a+b;
        int result = mc.sum(3, 4);
        System.out.println(result);
    }
}
