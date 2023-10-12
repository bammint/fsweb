package a1012.animal1;

public class main1 {
    public static void main(String[] args) {
        Animal animal1 = new Dog();
        Animal animal2 = new Cat();

        animal1.makeSound(); // "강아지가 짖습니다" 출력
        animal2.makeSound(); // "고양이가 야옹합니다" 출력
    }
}
