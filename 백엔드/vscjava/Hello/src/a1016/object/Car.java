package a1016.object;

// public class Car {
//     private String modelName;
//     private int modelYear;
//     private String color;
//     private int maxSpeed;

//     Car(String modelName, int modelYear, String color, int maxSpeed) {
//         this.modelName = modelName;
//         this.modelYear = modelYear;
//         this.color = color;
//         this.maxSpeed = maxSpeed;
//         // this 참조 변수는 인스턴스가 바로 자기 자신을 참조하는 데 사용하는 변수
//     }
//     Car() {
//         this("아반떼", 2016 "흰색", 200);
//     }
//     public String getModel(){
//         return this.modelYear + "년식" + this.modelName + " " + this.color;
//     }


//     // this() 메소드는 생성자 내부에서만 사용할 수 있으며, 같은 클래스의 다른 생성자를 호출할 때 사용합니다
// }
public class Car {
    private String modelName;
    private int modelYear;
    private String color;
    private int maxSpeed;

    public Car(String modelName, int modelYear, String color, int maxSpeed){
        this.modelName = modelName;
        this.modelYear = modelYear;
        this.color = color;
        this.maxSpeed = maxSpeed;
        //this 참조 변수는 인스턴스가 바로 자기 자신을 참조하는데 사용하는 변수
    }
    Car() {
        this("아반떼", 2016, "흰색", 200);
    }
    public String getModel(){
        return this.modelYear + "년식" + this.modelName + " " + this.color;
    }
    @Override
    public String toString(){
        return this.modelYear + "년식 " + this.modelName + " " + this.color + " " + this.maxSpeed + "km";
    }
    
    //this() 메소드는 생성자 내부에서만 사용할 수 잇으며, 같은 클래스의 다른 생성자를 호출할 때 사용한다.
}
