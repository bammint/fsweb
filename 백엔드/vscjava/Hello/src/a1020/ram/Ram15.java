package a1020.ram;

import java.util.function.Supplier;

class Person {
    private String name;

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
// 인스턴스 메소드 참조 (object::instanceMethodName)
public class Ram15 {
    public static void main(String[] args) {
        // 람다식 메소드 참조
        Person person = new Person("Alice");
        Supplier<String> getNameSupplier = person::getName;
        String name = getNameSupplier.get(); // 결과: "Alice"
        
        System.out.println("이름: " + name);
    }
}