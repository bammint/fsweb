package a1020.ram;

import java.util.Arrays;
import java.util.Comparator;

public class Ram5 {
    public static void main(String[] args) {
        int[] data = { 5, 6, 4, 2, 3, 1, 1, 2, 2, 4, 8 };
        int[] result = Arrays.stream(data)
                .boxed()
                .filter((a) -> a % 2 == 0)
                .distinct()
                .sorted(Comparator.reverseOrder())
                .mapToInt(Integer::intValue)
                .toArray();
    }
    // 1. Arrays.stream(data) 로 정수 배열을 IntStream으로 생성
    // 2. .boxed() IntStream을 Integer의 Stream으로 변경
    // 뒤에서 사용할 Comparator.reverseOrder 원시타입인 int 대신 Integer를 사용해야한다
    // .distinct()로 스트링에서 중복을 제거한다
    // .sorted(Comparator.reverseOrder()) 역순 정렬
    // .mapToInt(Integer::intValue)로 Integer의 Stream을 IntStream으로 변경
    // .toArray()를 호출하여 IntStream의 배열인 int[] 배열을 리턴한다
}
