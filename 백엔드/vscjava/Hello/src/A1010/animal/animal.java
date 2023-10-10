package A1010.animal;

class ani1 {
    String name = "얼룩이";
    String breed = "카오스";
    int age = 3;
}
class ani2 {
    String name = "고등어";
    String breed = "코숏";
    int age = 2;
}

public class animal{
    public static void main(String[] args) {
        ani1 a1 = new ani1();
        ani2 a2 = new ani2();

        System.out.println("이름: " + a1.name);
        System.out.println("품종: " + a1.breed);
        System.out.println("나이: " + a1.age);

        System.out.println("이름: " + a2.name);
        System.out.println("품종: " + a2.breed);
        System.out.println("나이: " + a2.age);
    }
}