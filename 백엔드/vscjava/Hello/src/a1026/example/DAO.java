package a1026.example;

import java.util.ArrayList;
import java.util.Scanner;

public class DAO {
    Scanner sc = new Scanner(System.in);

    private ArrayList<MemberDTO> mlist;

    // file 직접 d: 저장하려면 클래스인 FileClass 만들 예정
    private FileClass file = new FileClass("sun", "memberInfo");

    // 생성자 constructor
    public DAO() {
        mlist = new ArrayList<MemberDTO>();

        // 테스트용 데이터
        MemberDTO m1 = new MemberDTO(0, "test1", 11, "서울");
        MemberDTO m2 = new MemberDTO(1, "test2", 22, "대전");
        MemberDTO m3 = new MemberDTO(2, "test3", 33, "대구");
        MemberDTO m4 = new MemberDTO(3, "test4", 44, "부산");

        mlist.add(m1);
        mlist.add(m2);
        mlist.add(m3);
        mlist.add(m4);
    }

    // CRUD
    private void insert(MemberDTO m) {
        // 데이터 추가
        mlist.add(m);
        // listSize++;
    }

    // user 메서드: 사용자의 입력값있음.
    // user Insert

    public void userInsert() {
        MemberDTO m = new MemberDTO();
        System.out.println("< 회원 정보입력 >");
        System.out.print("회원번호: ");
        int id = sc.nextInt();
        System.out.print("이름: ");
        String name = sc.next();
        System.out.print("나이: ");
        int age = sc.nextInt();
        System.out.print("주소: ");
        String ad = sc.next();

        m.setId(id);
        m.setName(name);
        m.setAge(age);
        m.setAddress(ad);

        insert(m);
    }

}
