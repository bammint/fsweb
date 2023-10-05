package A1005;

public class A1005_49 {
    public static void main(String[] args) {
        String[] array = { "apple", "banana", "cherry", "date" };
        String[] arrX = new String[4];

        for (int i = 0; i < arrX.length; i++) {
            arrX[i] = array[array.length - 1 - i];
            // System.out.print(arrY);
            System.out.println("array[" + i + "] : " + arrX[i]);
        }

        // arrX[0] = array[3];
        // arrX[1] = array[2];
        // arrX[2] = array[1];
        // arrX[3] = array[0];

        // String arrY = "";

        // for(int i=0; i<arrX.length; i++){
        // arrX[i] = array[array.length-1-i];
        // arrY += arrX[i];
        // // System.out.print(arrY);
        // System.out.println("array["+i+"] : "+arrX[i]);
        // }

        // --------------------------------------------------------------

        for (int i = 0; i < array.length / 2; i++) {
            String temp = array[i];
            array[i] = array[array.length - 1 - i];
            array[array.length - 1 - i] = temp;
        }

        System.out.println("배열 요소 뒤집기:");
        for (String str : array) {
            System.out.println(str);
        }

    }
}
