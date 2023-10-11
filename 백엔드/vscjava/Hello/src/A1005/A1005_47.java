package a1005;

public class A1005_47 {
    public static void main(String[] args) {
        int[] array = {10,5,8,21,3};

        int max = 0;
        for(int i=0; i<array.length; i++){
            if(array[i]>max){
                max = array[i];
            }
        }
        System.out.println("max: " + max);

        int min = 0;
        for(int i=0; i<array.length; i++){
            if(array[i]<max){
                min = array[i];
            }
        }
        System.out.println("min: " + min);

        // for (int i = 1; i < array.length; i++) {
        //     if (array[i] > max) {
        //         max = array[i];
        //     }
        //     if (array[i] < min) {
        //         min = array[i];
        //     }
        // }
    }
}
