package generic.exam01_1;

public class GenericMethod {
    public static void main(String[] args) {
        Integer[] intArray = {1,2,3};
        Integer firstInt = Utility.getFirstElement(intArray);
        System.out.println("첫 번째 정수: " + firstInt);
        
        String[] strArray = {"apple", "banana", "cherry"};
        String firstStr = Utility.getFirstElement(strArray);
        System.out.println("첫 번째 문자열: " + firstStr);
    }
}
class Utility{
    public static <T> T getFirstElement(T[] array){
        if(array != null && array.length>0){
            return array[0];
        }
        return null;
    }
}
