package a1026.student;

import java.util.ArrayList;
import java.util.Scanner;

public class DAO {
    Scanner sc = new Scanner(System.in);

    private ArrayList<StudentDTO> slist;

    // file 직접 d: 저장하려면 클래스인 FileClass 만들 예정
    private FileClass file = new FileClass("ex", "studentInfo");

    // 생성자 constructor
    public DAO() {
        slist = new ArrayList<StudentDTO>();

        // 테스트용 데이터
        StudentDTO s1 = new StudentDTO(0, "테스트1", 11, 100, 90, 80);
        StudentDTO s2 = new StudentDTO(1, "테스트2", 22, 90, 89, 91);
        StudentDTO s3 = new StudentDTO(2, "테스트3", 33, 85, 77, 55);
        StudentDTO s4 = new StudentDTO(3, "테스트4", 44, 77, 68, 85);

        slist.add(s1);
        slist.add(s2);
        slist.add(s3);
        slist.add(s4);
    }

    // CRUD
    // Create
    private void insert(StudentDTO s) {
        // 데이터 추가
        slist.add(s);
        // listSize++;
    }

    // Delete
    private void delete(int index) {
        slist.remove(index);
    }

    // Select(검색)
    private StudentDTO select(int index) {
        return slist.get(index);
    }
    // Update
    private void update(int index,StudentDTO s){
        slist.set(index, s);
    }

    // user 메서드: 사용자의 입력값있음.
    // user Insert

    public void userInsert() {
        StudentDTO s = new StudentDTO();
        System.out.println("< 학생 정보입력 >");
        System.out.print("학생번호: ");
        int id = sc.nextInt();
        System.out.print("이름: ");
        String name = sc.next();
        System.out.print("나이: ");
        int age = sc.nextInt();
        System.out.print("국어 점수: ");
        int kor = sc.nextInt();
        System.out.print("영어 점수: ");
        int eng = sc.nextInt();
        System.out.print("수학 점수: ");
        int math = sc.nextInt();

        s.setId(id);
        s.setName(name);
        s.setAge(age);
        s.setKor(kor);
        s.setEng(eng);
        s.setMath(math);

        insert(s);
    }

    // 인덱스 찾기: 키 - 이름
    private int findIndex() {
        System.out.println("학생 이름을 입력하시오: ");
        String name = sc.next();
        for (int i = 0; i < slist.size(); i++) {
            if (slist.get(i).getName().equals(name)) {
                return i;
            }
        }
        return -1;
    }

    // userDelete
    public void userDelete() {
        int index = findIndex();
        if (index != -1) {
            delete(index);
            System.out.println("학생을 삭제했습니다");
        } else {
            // 이름이 없는 경우
            System.out.println("해당 학생이 없습니다");
        }
    }

    // userSelect 멤버 값 리턴하기
    public void userSelect() {
        int index = findIndex();
        if (index != -1) { // 인덱스가 있는 경우
            StudentDTO s = select(index);
            int id = s.getId();
            String name = s.getName();
            int age = s.getAge();
            int kor = s.getKor();
            int eng = s.getEng();
            int math = s.getMath();
            System.out.println("< " + name + " 의 학생정보 >");
            System.out.println(" - 학생번호: " + id);
            System.out.println(" - 이름: " + name);
            System.out.println(" - 나이: " + age);
            System.out.println(" - 국어 점수: " + kor);
            System.out.println(" - 영어 점수: " + eng);
            System.out.println(" - 수학 점수: " + math);
        } else {
            System.out.println("학생이 없습니다");
        }
    }

    // userUpdate
    public void userUpdate(){
        int index = findIndex();
        if(index != -1){
            // 이름이 있는 경우
            StudentDTO s = new StudentDTO();
            s.setId(slist.get(index).getId());
            s.setName(slist.get(index).getName());
            System.out.println("< "+s.getName()+"학생 정보수정 >");
            System.out.println("학생번호: " + s.getId());
            System.out.print("나이: ");
            s.setAge(sc.nextInt());
            System.out.print("국어 점수: ");
            s.setKor(sc.nextInt());
            System.out.print("영어 점수: ");
            s.setEng(sc.nextInt());
            System.out.print("수학 점수: ");
            s.setMath(sc.nextInt());

            update(index, s);
            System.out.println("수정되었습니다");
        }else{
            // 이름이 없는 경우
            System.out.println("해당 학생이 없습니다");
        }
    }

    // ptintAll 전체 리스트 출력
    public void printAll(){
        System.out.println("< 전체 학생 목록 >");
        int index = 1;
        for(int i=0; i<slist.size();i++){
            System.out.println("< "+index+"."+slist.get(i).getName()+"학생 >");
            System.out.println("학생번호: " + slist.get(i).getId());
            System.out.println("나이: " + slist.get(i).getAge());
            System.out.println("국어점수: " + slist.get(i).getKor());
            System.out.println("영어점수: " + slist.get(i).getEng());
            System.out.println("수학점수: " + slist.get(i).getMath());
            index++;
        }
    }

    // File method
    public void dataSave() throws Exception{
        file.create();
        String str = " 번호\t 이름\t 나이\t 국어점수\t 영어점수\t 수학점수\n" + "---------------------------------------\n";
        for(int i=0;i<slist.size();i++){
            str += slist.get(i).toString()+"\n";
        }
        System.out.println("데이터를 저장했습니다");
        file.write(str);
    }

    // Load
    public void dataLoad(){
        try{
            file.read();
        }catch(Exception e){
            System.out.println("읽을 파일이 없습니다");
        }
    }
}
