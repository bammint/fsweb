package a1011.single;

public class Person {
    private String name;
    private int age;
    private static Person instance;

    private Person(){
        // private 생성자
    }
    public static Person getInstance(){
        if(instance == null){
            instance = new Person();
        }
        return instance;
    }

    public void setPersonInfo(String name, int age){
        this.name = name;
        this.age = age;
    }

    public void displayPersonInfo(){
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }
}
