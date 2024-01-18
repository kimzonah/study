package week01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Room {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[][] students = new int[2][7]; // 남여 학년 별 배열 만들기
		int room = 0; // 방 개수
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int S = Integer.parseInt(st.nextToken());
			int Y = Integer.parseInt(st.nextToken());
			++students[S][Y]; // 학생 정보 입력받아 맞는 칸에 1추가
		}

		for (int i = 0; i < 2; i++) {
			for (int j = 1; j < 7; j++) {
                room += (students[i][j] / K); // 각 원소를 최대인원으로 나누고 몫을 저장
                if (students[i][j] % K != 0) room++; // 나머지가 있으면 1추가
			}
		}
		
		System.out.println(room);
	}
}

