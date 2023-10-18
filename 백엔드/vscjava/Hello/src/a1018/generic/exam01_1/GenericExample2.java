package generic.exam01_1;

public class GenericExample2 {
    public static void main(String[] args) {
        Box<Integer> integerBox = new Box<>();
        integerBox.setValue(42);
        int intValue = integerBox.getValue();
        System.out.println("정수 상자의 값: " + intValue);

        Box<String> stringBox = new Box<>();
        stringBox.setValue("Hello, World");
        String strValue = stringBox.getValue();
        System.out.println("문자열 상자의 값: " + strValue);
    }
}
