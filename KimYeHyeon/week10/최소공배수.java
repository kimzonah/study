package learning;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 최소공배수 {
	// 최대공약수 결과
	static int resultGCD = 0;
	// 최소공배수 결과
	static int resultLCM = 0;
	static List<Integer> arr = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.println("최소공배수를 구할 숫자들을 엔터로 구분지어서 입력하세요.");
		System.out.println("0 이하의 수를 입력하면 결과가 표시됩니다.");

		int num = 0;
		while (true) {
			num = Integer.parseInt(br.readLine());

			if (num <= 0)
				break;

			arr.add(num);
		}

		// List 정렬
		Collections.sort(arr);

		/*
		 * a < b 라면 최소공배수 = a * b / 최대공약수
		 * 최대공약수 = b % a = r1
		 * a % r1 = r2 r1 % r2 = r3 ...
		 * 를 하여 r의 값이 0이 되면 그것이 최대 공약수이다.
		 */
		
		// 첫번째 최대공약수와 최소공배수를 구해준다.
		int a = arr.get(0);
		int b = arr.get(1);
		GCD(a, b);
		resultLCM = a * b / resultGCD;
		
		System.out.println(arr);
//		System.out.println("1번째 최대공약수, 최소공배수: " + resultGCD + " " + resultLCM);
		
		
		// 최대공배수
		for (int i = 2; i < arr.size(); i++) {
			LCM(resultLCM, arr.get(i));
//			System.out.println(i + "번째 최대공약수, 최소공배수: " + resultGCD + " " + resultLCM);
		}

		// 최대 공약수는 공통으로 구해지지는 않는다. 구하려면 따로 구해야한다.
//		System.out.println("최대공약수: " + resultGCD);
		System.out.println("최대공배수: " + resultLCM);
	}

	/**
	 * 최대공배수 구하기
	 * 
	 * @param a
	 * @param b
	 */
	private static void LCM(int a, int b) {
		GCD(a, b);
		
		resultLCM = a * b / resultGCD;
	}

	/**
	 * 최소공배수와 다른 수의 최대 공약수 구하기
	 * 
	 * @param a
	 * @param b
	 */
	private static void GCD(int a, int b) {
		int cal = a % b;
//		System.out.println(a + " " + b + " " + cal);
		if (cal == 0) {
			resultGCD = b;
			return;
		}

		GCD(b, cal);
	}
}
