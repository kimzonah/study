import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution {
	static int cnt;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		// [S/W 문제해결 기본] 4일차 - 거듭 제곱
		
		// 변수 TC, N, M 생성
		int TC;
		int N;
		int M;
		
		// TC만큼 반복
		for(int i=1;i<=10;i++) {
			// 반복문 시작 시 N,M 초기화(br로 입력받음)
			cnt = 1;
			TC = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			int result = repeat(N,M);
			// 계산된 내용을 출력
			System.out.println("#" +i+" "+ result);
		}
				
	}
	// 곱하는 재귀 함수 생성
	// int 값 리턴으로, N,M을 인자로 받아서 수행
	// static 카운트 변수=1 생성, 재귀함수 실행시마다 +1
	// M되면 N return ;
	// 그동안은 cnt를 1씩 증가시키며 N*재귀함수 수행
	public static int repeat(int N, int M) {
		if(cnt == M) {
			return N;
		} else {
			cnt++;
			return N*repeat(N,M);
		}
	}
}
