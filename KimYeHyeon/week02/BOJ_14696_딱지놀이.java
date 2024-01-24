package Baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_14696_딱지놀이 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int round = sc.nextInt(); // 라운드 수

		for (int n = 0; n < round; n++) {
			
			int A_figure_num = sc.nextInt(); // A가 내는 딱지에 나온 그림의 총 개수
			int[] A_strangth = new int[5]; // A의 카드 모양 종류 세어주는 배열 생성
			for (int i = 0; i < A_figure_num; i++) {
				int num = sc.nextInt();
				A_strangth[num]++; // 입력받은 모양 인덱스 +1
			}

			int B_figure_num = sc.nextInt(); // B가 내는 딱지에 나온 그림의 총 개수
			int[] B_strangth = new int[5]; // B의 카드 모양 종류 세어주는 배열 생성
			for (int i = 0; i < B_figure_num; i++) {
				int num = sc.nextInt();
				B_strangth[num]++; // 입력받은 모양 인덱스 +1
			}
			
//			// 출력 테스트
//			for(int i = 0; i < 5; i++) {
//				System.out.print(A_strangth[i] + " ");
//			}
//			System.out.println();
//			for(int i = 0; i < 5; i++) {
//				System.out.print(B_strangth[i] + " ");
//			}
//			System.out.println();
//			System.out.println(A_strangth == B_strangth);
//			System.out.println(A_strangth.equals(B_strangth));
			
			// A와 B 딱지 힘 겨루기
			if (Arrays.equals(A_strangth, B_strangth)) { // 비겼을 경우
				System.out.println("D");
				continue;
			}
			
			for (int i = 4; i > 0; i--) { // 비기지 않았을 경우는 큰 순서대로 비교하여 승패를 결정
				// 별부터 순서대로 비교했을 때 큰 모양이 있다면 승패 결정!
				if (A_strangth[i] > B_strangth[i]) { // A가 큰 경우
					System.out.println("A");
					break;
				} else if (A_strangth[i] < B_strangth[i]){ // B가 큰 겅우
					System.out.println("B");
					break;
				}
			}
			// else if로 하지 않고 else로 했을 경우, i--가 dead code가 되는데 이유를 모르겠다...
		}
	}
}
