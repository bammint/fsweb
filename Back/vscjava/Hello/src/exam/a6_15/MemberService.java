package exam.a6_15;

public class MemberService {
    private String loggedInUser = null;

    // 로그인 메서드
    public boolean login(String id, String password){
        if(id.equals("hong")&& password.equals("12345")){
            loggedInUser = id;
            return true;
        } else {
            return false;
        }
    }
    // 로그아웃 메서드
    public void logout(String id){
        if(id.equals(loggedInUser)){
            System.out.println(id+"님이 로그아웃 되었습니다");
        } else{
            System.out.println("접속중인 사용자가 아닙니다.");
        }
    }
}
