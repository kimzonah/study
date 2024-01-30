package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Seat {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = (br.readLine()).split(" ");
		
		// 공연장 크기 입력 받기
		int xLen = Integer.parseInt(str[0]);
		int yLen = Integer.parseInt(str[1]);
		
		// 대기번호 K 입력 받기
		int K = Integer.parseInt(br.readLine());
		
		if (xLen * yLen < K) {
			System.out.println(0);
			return;
		}
		
		// 배열 크기 설정 (-1로 감싸기 위해 +2 해주기)
		int[][] arr = new int[xLen+2][yLen+2];
		
		// 테두리 -1로 감싸기
		for(int i = 0; i < xLen +2; i++) {
			arr[i][0] = -1;
			arr[i][yLen+1] = -1;
		}
		for(int i = 1; i < yLen+1; i++) {
			arr[0][i] = -1;
			arr[xLen+1][i] = -1;
		}
		
		// 초기값 세팅
		int x = 1;
		int y = yLen;
		
		// 방향 설정
		int dir = 0; // 0:상, 1:우, 2:하, 3:좌
		
		// 대기번호 위치 찾기
		int count = 1;
		while(count < K) {
			arr[x][y] = count++;
			if(dir == 0) { // 위로 가야할 때
				if (arr[x][y-1] == 0) {
					y--;
					continue;
				} else {
					dir = 1;
					x++;
					continue;
				}
			} else if (dir == 1) {
				if (arr[x+1][y] == 0) {
					x++;
					continue;
				} else {
					dir = 2;
					y++;
					continue;
				}
			} else if (dir == 2) {
				if (arr[x][y+1] == 0) {
					y++;
					continue;
				} else {
					dir = 3;
					x--;
					continue;
				}
			} else {
				if (arr[x-1][y] == 0) {
					x--;
					continue;
				} else {
					dir = 0;
					y--;
					continue;
				}
			}
		}
		System.out.println(x + " " + (yLen - y + 1));
	}
}
