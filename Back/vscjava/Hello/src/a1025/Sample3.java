package a1025;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Sample3 {
    public static void main(String[] args) throws IOException {
        InputStream in = System.in;
        InputStreamReader reader = new InputStreamReader(in);
        // 문자 입력 스트림
        char[] a = new char[3];
        reader.read(a);

        System.out.println(a);
    }
}
