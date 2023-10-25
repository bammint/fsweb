package a1025;

import java.io.FileWriter;
import java.io.IOException;

public class Samplew3 {
    public static void main(String[] args) throws IOException {
        FileWriter fw = new FileWriter("C:/Temp/out.txt");
        for(int i=1;i<11; i++){
            String data = i + " 번째 줄입니다.\r\n"; // 줄바꿈
            fw.write(data);
        }
        fw.close();
    }
}