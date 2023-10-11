package a1010.문제;

public class Square {
    // 1. 필드를 추가하시오
    int length;

    // 2. 메소드를 작성하시오
    int area(){
        return length*length;
    }

    // 3. 메인 메소드를 완성하시오
    public static void main(String[] args) {
        // 객체 생성
        Square s = new Square();

        // 필드 초기화
        s.length = 4;
        
        // 결과 출력
        System.out.printf("한 변의 길이가 %d인 정사각형의 넓이: %d", s.length, s.area());
    }
}

