import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		// [S/W 문제해결 기본] 7일차 - 암호생성기
		// TC =10 N, 문자열의 배열 K 선언
		// cnt 변수 선언
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N;
		int cnt;
		// 문자열 담을 queue 선언
		Queue<Integer> af = new LinkedList<>();
		// TC 만큼 반복
		for (int i = 1; i <= 10; i++) {
			N = Integer.parseInt(br.readLine());
			// 8개의 문자열을 queue에 입력
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 8; j++) {
				af.add(Integer.parseInt(st.nextToken()));
			}
			// tmp 변수 선언, 이후 poll 진행 시 다시 add할 값을 저장한다
			// cnt 변수 초기화, poll 횟수만큼 ++;
			int tmp = af.peek();
			cnt = 1;
			// tmp 변수가 0이 될때까지 while문을 통해 poll 수행
			while (tmp != 0) {
				tmp = af.poll();
				// poll된 수는 tmp에 저장후 cnt만큼 빼지고 다시 add 된다
				tmp -= cnt;
				cnt = (cnt%5) +1 ;
				if (tmp < 0) {
					tmp = 0;
				}
				af.add(tmp);
			}

			// isEmpty 명령어로 queue가 빌때까지 출력한다
			System.out.print("#" + i + " ");
			while (!af.isEmpty()) {
				System.out.print(af.poll()+" ");
			}
			System.out.println();
		}
	}
}
