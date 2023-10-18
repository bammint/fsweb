package generic.exam01;

public class GenericExample {
    public static void main(String[] args) {
        // K는 Tv로 대체, M은 String으로 대체
        Product<Tv,String> product1 = new Product<>();

        // Setter 매개값은 반드시 Tv와 String을 제공
        product1.setKind(new Tv());
        product1.setModel("스마트Tv");

        // Getter 리턴값은 Tv와 String이 됨
        Tv tv = product1.getKind();
        String tvModel = product1.getModel();
        System.out.println("Tv의 종류: " + tv);
        System.out.println("Tv의 모델: " + tvModel);
        //------------------------------------------------------------------
        // K는 Car로 대체, M은 String으로 대체
        Product<Car,String> product2 = new Product<>();

        // Setter 매개값은 반드시 Car와 String을 제공
        product2.setKind(new Car());
        product2.setModel("SUV자동차");

        // Getter 리턴값은 Car와 String이 됨
        Car car = product2.getKind();
        String carModel = product2.getModel();
        System.out.println("자동차 종류: " + car);
        System.out.println("자동차 모델: " + carModel);
    }
}
