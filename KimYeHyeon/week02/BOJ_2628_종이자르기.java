package Baekjoon;

import java.util.Scanner;

public class BOJ_2628_종이자르기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int paper_width = sc.nextInt();	// 종이의 가로 입력받기
		int paper_length = sc.nextInt(); // 종이의 세로 입력받기
		
		int cut_cnt = sc.nextInt(); // 잘라야하는 점선 줄의 개수 입력받기
		
		int[] vertical = new int[paper_width]; // 세로로 잘릴 부분 (종이의 가로 길이) 배열
		int[] horizontal = new int[paper_length]; // 가로로 잘릴 부분 (종이의 세로 길이) 배열
		
		for (int c = 0; c < cut_cnt; c++) {	
			int cut_direction = sc.nextInt(); // 자르는 방향 입력받기
			int cut_num = sc.nextInt(); // 잘릴 번호 입력받기
			
			switch (cut_direction) {
			case 0: // 자르는 방향이 가로일 때
				horizontal[cut_num] = 1; // 잘리는 부분의 index를 1로 만들어준다
				break;
			case 1: // 자르는 방향이 세로일 때
				vertical[cut_num] = 1; // 얘도 똑같이
				break;
			}
		}
		
//		// 잘린 부분 잘 들어갔는지 확인
//		for (int i : vertical) {
//			System.out.print(i + " ");
//		}
//		System.out.println();
//		for (int i : horizontal) {
//			System.out.print(i + " ");
//		}
//		System.out.println();
		
		int cnt = 0; // 길이 재기
		
		// (종이의 가로) 잘린 부분 사이사이 길이를 재고 가장 큰 부분 찾기
		int verti_max = 0; // 길이가 가장 큰 값(가로)
		for (int i = 0; i < vertical.length; i++) {
			if(vertical[i] == 1) {
				verti_max = Math.max(verti_max, cnt);
				cnt = 0;
			}
			cnt++;
		}
		verti_max = Math.max(verti_max, cnt); // 다 비교 후에도 cnt와 비교해본다.
		
		cnt = 0;
		
		// (종이의 세로) 잘린 부분 사이사이 길이를 재고 가장 큰 부분 찾기
		int hori_max = 0; // 길이가 가장 큰 값(세로)
		for (int i = 0; i < horizontal.length; i++) {
			if(horizontal[i] == 1) {
				hori_max = Math.max(hori_max, cnt);
				cnt = 0;
			}
			cnt++;
		}
		hori_max = Math.max(hori_max, cnt); // 마찬가지
		
		// 가장 긴 (가로 * 세로) 길이가 가장 큰 넓이
		System.out.println((hori_max * verti_max));
	}
}
