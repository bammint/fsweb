package a1025;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Sampler8 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("C:/Temp/out.txt"));
        while(true){
            String line = br.readLine();
            if(line==null)break;    // 더 이상 읽을 라인이 없을 경우 while 문을 빠져나옴
            System.out.println(line);
        }
        br.close();
    }
}