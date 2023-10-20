package a1020.ram;

interface Calculator{
    int sum(int a, int b);
}
class MyCalculator implements Calculator{
    public int sum(int a, int b){
        return a+b;
    }
}

public class Ram1 {
    public static void main(String[] args) {
        MyCalculator mc = new MyCalculator();
        int result = mc.sum(3, 4);
        System.out.println(result);
    }
}
