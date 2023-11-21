package a1017;

public class Stringbuffer1 {
    public static void main(String[] args) {
        // StringBuffer str = new StringBuffer("Java");
        StringBuilder str = new StringBuilder("Java");
        System.out.println("원본 문자열: " + str);

        System.out.println(str.append("수업"));
        System.out.println("append() 메소드 호출 후 원본 문자열: " + str);

        // append() -> 원본 문자열의 앞에 옴
        // 원본 문자열이 바뀜
        // 멀티쓰레드?? 쓸때는 빌더는 안씀
        // 버퍼는 차례대로 나오고 빌더는 뒤죽박죽 나올 수 있다
        // 단일쓰레드를 쓸때는 빌더가 더 빠름

        // `StringBuffer`와 `StringBuilder`는 둘 다 Java에서 문자열을 다루는 데 사용되는 클래스입니다. 그러나 그들
        // 사이에 중요한 차이점이 있습니다.

        // 1. **가변성 (Mutability):**
        // - `StringBuffer`: `StringBuffer`는 가변(mutability)입니다. 즉, 문자열을 변경할 수 있습니다. 문자열을
        // 수정하고 연결하는 작업을 수행할 수 있습니다. 이것은 멀티스레드 환경에서 안전합니다.
        // - `StringBuilder`: `StringBuilder`도 가변입니다. 따라서 문자열을 변경하고 연결할 수 있지만,
        // `StringBuilder`는 단일 스레드 환경에서 사용하기를 권장합니다. 멀티스레드 환경에서 안전하지 않습니다.

        // 2. **성능 (Performance):**
        // - `StringBuilder`: `StringBuilder`는 단일 스레드 환경에서 빠릅니다. 이것은 스레드 동기화 오버헤드가 없기
        // 때문입니다. 따라서 단일 스레드 응용 프로그램에서 `StringBuilder`를 선호하는 것이 좋습니다.
        // - `StringBuffer`: `StringBuffer`는 멀티스레드 환경에서 안전하게 사용할 수 있지만, 스레드 동기화 오버헤드가 있기
        // 때문에 단일 스레드 환경에서 `StringBuilder`보다 성능이 떨어질 수 있습니다.

        // 3. **스레드 안전성 (Thread Safety):**
        // - `StringBuilder`: `StringBuilder`는 스레드 동기화를 제공하지 않으므로 멀티스레드 환경에서 안전하지 않습니다.
        // - `StringBuffer`: `StringBuffer`는 스레드 동기화를 제공하여 멀티스레드 환경에서 안전하게 사용할 수 있습니다.

        // 4. **사용 사례 (Use Cases):**
        // - `StringBuilder`는 단일 스레드 환경에서 성능을 최적화하고자 할 때 사용됩니다.
        // - `StringBuffer`는 멀티스레드 환경에서 문자열 조작이 필요한 경우나 스레드 동기화가 필요한 경우 사용됩니다.

        // 일반적으로 단일 스레드 환경에서는 `StringBuilder`를 사용하는 것이 빠르며, 멀티스레드 환경에서는 `StringBuffer`를
        // 사용하여 안전성을 보장할 수 있습니다.
    }
}
