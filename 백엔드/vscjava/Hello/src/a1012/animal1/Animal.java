package a1012.animal1;

class Animal {
    void makeSound(){
        System.out.println("동물의 소리를 냅니다");
    }
}
class Dog extends Animal {
    @Override
    void makeSound(){
        System.out.println("강아지가 짖습니다");
    }

}
class Cat extends Animal {
    @Override
    void makeSound(){
        System.out.println("고양이가 야옹합니다");
    }

}
