package a1011.aven;

public class AvengerTest {
    public static void main(String[] args) {
        Avenger thor = new Avenger("토르", 150);
        Avenger thanos = new Avenger("타노스", 160);
        thor.punch(thanos); // thor 메소드 실행의 주체 인스턴스(객체)
        thor.punch(thanos); // Avenger enemy = thanos; enemy에 thanos가 대입
        thanos.punch(thor);
    }
}

class Avenger {
    String name;
    int hp;

    Avenger(String s, int i) {
        name = s;
        hp = i;
    }

    void punch(Avenger enemy) {
        System.out.printf("[%s]의 펀치", name);
        enemy.hp -= 10;
        System.out.printf("-> %s의 체력: %d\n", enemy.name, enemy.hp);
    }
        // void punch(Avenger enemy){
        // System.out.printf("[%s]의 펀치", name);
        // // 실행시키는 주체의 name값이 타노스 일때,
        // if(name.equals("타노스")){
        //     System.out.println("쿵!");
        //     enemy.hp -=30;
        //     // 실행 시키는 주체의 name값이 타노스가 아닐때
        // }else enemy.hp -= 10;
        // System.out.printf("-> %s의 체력 : %d\n", enemy.name, enemy.hp);
        //     }
        // }
}