package a1019.sec04.exam01;

import java.util.HashMap;
import java.util.Map;

public class HashMap2 {
    public static void main(String[] args) {
        Map<String, Integer> studentScores = new HashMap<>();

        // 학생 아름과 점수 추가
        studentScores.put("Mike", 85);
        studentScores.put("Bob", 92);
        studentScores.put("Charlie", 78);
        studentScores.put("David", 95);
        studentScores.put("Eva", 88);

        // 학생 이름과 점수 추가
        String studentName = "Bob";
        if(studentScores.containsKey(studentName)){
            int score = studentScores.get(studentName);
            System.out.println(studentName + "의 점수: " + score);
        } else {
            System.out.println(studentName + "의 점수를 찾을 수 없습니다");
        }
        // 모든 학생의 이름과 점수 출력
        for(Map.Entry<String,Integer> entry : studentScores.entrySet()){
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
