package week02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 딱지놀이 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // 라운드 수 입력 받기

		for (int i = 0; i < N; i++) { // 라운드 수 만큼 반복
			// A카드의 그림 입력 받기
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()); // 딱지 그림의 수 입력 받기
			int[] cardA = new int[5]; // 그림의 수 체크할 배열 생성(인덱스 1부터 4까지 사용)
			for (int j = 0; j < a; j++) { // 딱지 그림의 수 만큼 반복
				cardA[Integer.parseInt(st.nextToken())]++;
			}

			// B카드의 그림 입력 받기
			st = new StringTokenizer(br.readLine());
			int b = Integer.parseInt(st.nextToken()); // 딱지 그림의 수 입력 받기
			int[] cardB = new int[5]; // 그림의 수 체크할 배열 생성(인덱스 1부터 4까지 사용)
			for (int j = 0; j < b; j++) { // 딱지 그림의 수 만큼 반복
				cardB[Integer.parseInt(st.nextToken())]++;
			}
			
			// 그림 수 비교하기
			if (cardA[4] > cardB[4]) System.out.println("A"); // A의 별그림이 더 많으면 A 출력
			else if (cardA[4] < cardB[4]) System.out.println("B");
			else { // 별그림 수가 같으면 동그라미 비교
				if (cardA[3] > cardB[3]) System.out.println("A");
				else if (cardA[3] < cardB[3]) System.out.println("B");
				else {
					if (cardA[2] > cardB[2]) System.out.println("A");
					else if (cardA[2] < cardB[2]) System.out.println("B");
					else {
						if (cardA[1] > cardB[1]) System.out.println("A");
						else if (cardA[1] < cardB[1]) System.out.println("B");
						else System.out.println("D"); // 전부 같으면 무승부
					}
				}
			}
		}
	}

}
