package exam.a6_18;

public class ShopService {
    // 정적 변수를 사용하여 유일한 인스턴스를 저장
    private static ShopService instance = new ShopService();

    // 생성자를 private 선언하여 외부에서 객체 생성을 막음
    private ShopService(){

    }
    // 정적 메서드를 사용하여 유일한 인스턴스를 반환
    public static ShopService getInstance(){
        return instance;
    }
}
