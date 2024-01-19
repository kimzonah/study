package week01;

import java.util.ArrayList;
import java.util.Scanner;

public class Line {

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		
		int N = sc.nextInt();
		int[] person = new int[N + 1];
		ArrayList<Integer> line = new ArrayList<>();

		// 사람 순서대로 이동값 받기
		for (int i = 1; i <= N; i++) {
			person[i] = sc.nextInt();
		}
		
		// 줄 세우기
		for (int i=1; i<=N;i++) {
			if (person[i] == 0) { // 0이면 제자리
				line.add(i);
			} else { // 0이 아니면
				line.add(i-person[i]-1, i); // 뽑은값만큼 앞으로 가서 서기
			}
		}
		
		for(int i: line) {
			System.out.print(i + " ");
		}
	}

}
