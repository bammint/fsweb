package exam2;

public class Member_ex {
    String name;
    String id;
    String password;
    int age;

    public String getName() {
        return name;
    }

    public void setName(String n) {
        name = n;
    }

    public String getId() {
        return id;
    }

    public void setId(String i) {
        id = i;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String pw) {
        password = pw;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int a) {
        age = a;
    }

    public void setMember(String n, String i) {
        name = n;
        id = i;
    }

}
