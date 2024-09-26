package backjun;

import java.io.*;
import java.util.*;

public class Switch {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 스위치 개수 입력 받기
		int n = Integer.parseInt(br.readLine());
		int[] swit = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());

		// 스위치 상태 입력 받기
		for(int i = 0; i < n; i++) {
			swit[i] = Integer.parseInt(st.nextToken());
		}
		
		// 학생 수 입력 받기
		int student = Integer.parseInt(br.readLine());
		
		// 각 학생 성별과 스위치 번호 입력 받기
		for(int i = 0; i < student; i++) {
			st = new StringTokenizer(br.readLine());
			int gender = Integer.parseInt(st.nextToken());
			int switchNum = Integer.parseInt(st.nextToken());
			
			if (gender == 1) { // 남학생
				for(int j = switchNum; j <= n; j++) {
					if(j % switchNum == 0) {
						swit[j - 1] = (swit[j - 1] == 1) ? 0 : 1;
					}
				}
			} else { // 여학생
				swit[switchNum - 1] = (swit[switchNum - 1] == 1) ? 0 : 1; // 가운데 스위치 바꾸는 로직을 미리 처리
				for(int j = 1; j < Math.ceil(n / 2); j++) { // 좌우 대칭으로 검사
					int indP = switchNum + j - 1;
					int indM = switchNum - j - 1;
					if ((indP < n) && (indM >= 0)) { // 인덱스가 배열 범위 내에 있는지 검사
						if(swit[indP] == swit[indM]) { // 좌우 대칭 값이 같다면, 좌우값을 동시에 변경
							swit[indP] = (swit[indP] == 1) ? 0 : 1;
							swit[indM] = (swit[indM] == 1) ? 0 : 1;
						} else { // 좌우 대칭 값이 다른 값을 만나면, break;
							break;
						}
					} else { // 인덱스가 배열 범위 밖이면, break;
						break;
					}
				}
			}	
		}
		int a = 0;

		// 20개씩 끊어 출력
		while(n - a > 20) {
			for (int j = a; j < a + 20; j++) {
				System.out.print(swit[j] + " ");
			}
			a += 20;
			System.out.println();
		} 
		for (int i = a; i < n; i++) {
			System.out.print(swit[i] + " ");
		}
		
	}
}
