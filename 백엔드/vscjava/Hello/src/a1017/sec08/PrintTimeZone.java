package a1017.sec08;

import java.util.TimeZone;

public class PrintTimeZone {
    public static void main(String[] args) {
        String[] availableIDs = TimeZone.getAvailableIDs();
        for(String id : availableIDs){
            System.out.println(id);
        }
    }
}
