package a1020.ram;

@FunctionalInterface
interface MyFactory<T> {
    T create(String name);
}
// 제네릭타입 T를 받고, create를 가지며 문자열 name을 받아
// T타입의 객체를 생성

class Product {
    private String name;

    public Product(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

public class Ram16 {
    public static void main(String[] args) {
        // 람다식 메소드 참조
        MyFactory<Product> factory = Product::new;
        // Product 생성자를 MyFactory<Product> 인터페이스에 연결
        // create 메소드에서 문자열을 인자로 받아 Product 객체를 생성
        Product product = factory.create("Smartphone");
        // factory.create 메소드를 사용하여 "Smartphone" 이름의 Product 객체를 생성
        String productName = product.getName(); // 결과: "Smartphone"
        // Product 객체의 getName 메소드를 호출하여 제품의 이름을 가져옵니다
        System.out.println("제품 이름: " + productName);
    }
}