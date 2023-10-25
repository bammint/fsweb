package a1025;

import java.io.IOException;
import java.io.InputStream;

public class Sample1 {
    public static void main(String[] args) throws IOException {
        // InputStream의 read() 메서드는 1byte 크기의 사용자의 입력을 받아드린다
        // 1byte 크기의 자료형으로 저장 0~255 사이의 정수 값(아스키코드)
        InputStream in = System.in;

        int a;
        a = in.read();

        System.out.println(a);
    }
}
