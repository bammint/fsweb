package exam.a7_6;

public class ParentExample {
    class Parent {
        public String name;

        public Parent(String name) {
            this.name = name;
        }
    }

    class Child extends Parent {
        public int studentNo;

        public Child(String name, int syudentNo) {
            super(name);
            this.studentNo = studentNo;
        }
    }
}
