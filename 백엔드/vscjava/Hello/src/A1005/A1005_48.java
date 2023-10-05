package A1005;

public class A1005_48 {
    public static void main(String[] args) {
        double[] array = {2.5,3.0,1.5,4.0,2.0};
        
        double arrSum = 0;
        for(int i=0; i<array.length; i++){
            arrSum += array[i];
        }

        double arrAvg = arrSum / array.length;

        System.out.println(arrAvg);
    }
}
