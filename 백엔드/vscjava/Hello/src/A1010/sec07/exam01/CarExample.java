package A1010.sec07.exam01;

public class CarExample {
    public static void main(String[] args) {
        //Car 객체 생성
        Car myCar = new Car("그랜저","검정",160);
        Car myCar1 = new Car("K5","은색",150);
        //Car 객체의 필드값 읽기
        System.out.println("모델명" + myCar.model);
        System.out.println("색깔" + myCar.color);
        System.out.println("최고속도" + myCar.maxSpeed);
        System.out.println("모델명" + myCar1.model);
        System.out.println("색깔" + myCar1.color);
        System.out.println("최고속도" + myCar1.maxSpeed);

    }
}
