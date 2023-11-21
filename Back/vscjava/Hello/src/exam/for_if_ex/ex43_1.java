package exam.for_if_ex;

import java.util.Scanner;

public class ex43_1 {
    public static void main(String[] args) {
        System.out.println("숫자를 한글로 읽기");
		System.out.println("요구사항 : 만이하의 정수 하나를 입력받아");
		System.out.println("만, 천, 백, 십 단위로 읽어내기");
		System.out.println("------------------------");
		System.out.println(" ");

		System.out.println("숫자를 입력해주세요");
		System.out.print(">");

		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		// 스캐너로 정수형태 받기
		String output = Integer.toString(num);
		// 1

		String[] unit = { "", "십 ", "백 ", "천 ", "만 ", "십 ", "백 ", "천 " };

		int out = output.length() - 1;

		for (int i = 0; i < output.length(); i++) {
			//// 문자열의 길이 만큼 반복문 실행
			int n = output.charAt(i) - '0';
			// 2
			
			
			if (read(n) != null) {
				// 숫자가 0일 경우는 출력하지 않음
				System.out.print(read(n));
				// 숫자를 한글로 읽어서 출력
				System.out.print(unit[out]);
               			// 3
			}
			out--;
		}
		System.out.println();
	}

	public static String read(int num) {
		switch (num) {
		case 1:
			return "일";
		case 2:
			return "이";
		case 3:
			return "삼";
		case 4:
			return "사";
		case 5:
			return "오";
		case 6:
			return "육";
		case 7:
			return "칠";
		case 8:
			return "팔";
		case 9:
			return "구";
		}
		return null;
	}
}
