package a1020.ram;

import java.util.function.Function;

class MyMath{
    public static int multiplyByTwo(int num){
        return num * 2;
    }
}
// 스테틱 메소드 참조
public class Ram14 {
    public static void main(String[] args) {
        Function<Integer, Integer> multiplier = MyMath::multiplyByTwo;
        int result = multiplier.apply(5);   // 결과: 10
        System.out.println("Result: " + result);
    }
}
