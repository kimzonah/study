package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Iterator;

public class Bingo {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 5 * 5 빙고 생성
		int[][] arr = new int[5][5];
		int n;
		int count = 0;
		int x = 0;
		int bingo = 0;

		// 빙고판 채우기 ~
		for (int i = 0; i < arr.length; i++) {
			String[] input = br.readLine().split(" ");
			for (int j = 0; j < arr.length; j++) {
				arr[i][j] = Integer.parseInt(input[j]);
			}
		}
		
		// 사회자가 불러주는 숫자 입력 받기
		for (int i = 0; i < 5; i++) {
			String[] input = br.readLine().split(" ");
			for (int j = 0; j < 5; j++) {
				n = Integer.parseInt(input[j]);
				count++;

				// 배열 탐색하며 해당 배열칸에 0 대입
				for (int k = 0; k < 5; k++) {
					for (int l = 0; l < 5; l++) {
						if (arr[k][l] == n) {
							arr[k][l] = 0;
						}
					}
				}
				
				// 빙고 개수 초기화
				bingo = 0;
				
				// 가로체크
				for(int h = 0; h< 5; h++ ) {
					x = 0;
					for (int w = 0; w < 5; w++) {
						if (arr[w][h] == 0) {
							x++;
						}
						if (x == 5) {
							bingo++;
						}
					}	
				}
				
				// 세로 체크
				for(int h = 0; h< 5; h++ ) {
					x = 0;
					for (int w = 0; w < 5; w++) {
						if (arr[h][w] == 0) {
							x++;
						}
						if (x == 5) {
							bingo++;
						}
					}	
				}
				
				// 대각선 체크1
				x = 0;
				for (int d = 0; d < 5; d++) {
					if(arr[d][d] == 0) {
						x++;
					} if(x == 5) {
						bingo++;
					}
				}
				
				// 대각선 체크2
				x = 0;
				for (int d = 0; d < 5; d++) {
					if(arr[d][4-d] == 0) {
						x++;
					} if(x == 5) {
						bingo++;
					}
				}
				
				// 가로, 세로, 대각선 체크해서 빙고가 3개 이상이면 종료
				if(bingo>= 3) {
					System.out.println(count);
					return;
				}
			}
			
		}
		
	}

}
