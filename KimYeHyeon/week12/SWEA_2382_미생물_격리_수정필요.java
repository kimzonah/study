package swexpartacademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class SWEA_2382_미생물_격리_수정필요 {
	// 셀의 개수, 격리 시간, 미생물 군집의 개수, 남은 미생물들의 수
	static int N, M, K, microbeCnt;
	// 미생물 군집들의 정보 배열을 담을 리스트
	static List<int[]> list = new ArrayList<>();

	// 방향 델타 (상: 1, 하: 2, 좌: 3, 우: 4)
	static final int[] dr = { 0, -1, 1, 0, 0 };
	static final int[] dc = { 0, 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int testCase = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= testCase; tc++) {
			// 남은 미생물 수 초기화
			microbeCnt = 0;

			// 조건 입력 받기
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());

			for (int $ = 0; $ < K; $++) {
				st = new StringTokenizer(br.readLine());

				int[] microbialColonyInfo = new int[4];
				// 세로위치
				microbialColonyInfo[0] = Integer.parseInt(st.nextToken());
				// 가로위치
				microbialColonyInfo[1] = Integer.parseInt(st.nextToken());
				// 미생물 수
				microbialColonyInfo[2] = Integer.parseInt(st.nextToken());
				// 이동방향
				microbialColonyInfo[3] = Integer.parseInt(st.nextToken());

				list.add(microbialColonyInfo);
			}

			timeFlow();

			System.out.printf("#%d %d\n", tc, microbeCnt);
		}
	}

	private static void timeFlow() {
		// 시간이 모두 흐르면 종료한다.
		while (M > 0) {
			// 군체 움직여주기
			int size = list.size();
			for (int i = 0; i < size; i++) {
				// 정보 가져오기
				int r = list.get(i)[0];
				int c = list.get(i)[1];
				int num = list.get(i)[2];
				int dir = list.get(i)[3];
				
				int nr = r + dr[dir];
				int nc = c + dc[dir];
				
				// 만약 군체가 영역의 끝부분에 도달했다면
				// 수가 반으로 줄고 방향이 반대로 바뀐다.
				if (nr == 0 || nr == N - 1 || nc == 0 || nc == N - 1) {
					num = num / 2;
					
					if (dir % 2 == 1)
						dir += 1;
					else
						dir -= 1;
				}
				
				System.out.printf("%d %d %d %d\n", nr, nc, num, dir);
				
				// 다시 할당해주기
				list.get(i)[0] = nr;
				list.get(i)[1] = nc;
				list.get(i)[2] = num;
				list.get(i)[3] = dir;
			} // 군체 움직임 for 종료
			
			// 좌표를 확인하여 중복된 곳이 있으면 비교하여 통합 <<<<<<<<<<<<<< 한꺼번에 비교 및 통합하도록 변경해야함
			size = list.size();
			for (int i = 0; i < size; i++) {
				for (int j = i + 1; j < size; j++) {
					// i 정보 가져오기
					int r1 = list.get(i)[0];
					int c1 = list.get(i)[1];
					int num1 = list.get(i)[2];
					// j 정보 가져오기
					int r2 = list.get(j)[0];
					int c2 = list.get(j)[1];
					int num2 = list.get(j)[2];

					// 좌표가 같다면
					if (r1 == r2 && c1 == c2) {
						// 미생물 수 비교하여 어디에 흡수될지 결정
						if (num1 > num2) {
							list.get(i)[2] = num1 + num2;
							list.get(j)[2] = 0;
						} else {
							list.get(j)[2] = num1 + num2;
							list.get(i)[2] = 0;
						}
					}
				}
			} // 군체 통합 for 종료
			
			// 군체 수가 0이라면 리스트에서 빼준다
			for (int i = size - 1; i >= 0; i--) {
				if (list.get(i)[2] == 0)
					list.remove(i);
			} // 군체 정리 for 종료
			M--;
		} // while 종료

		// while이 종료되었으면 미생물들을 세준다.
		int size = list.size();
		for (int i = 0; i < size; i++) {
			microbeCnt += list.get(i)[2];
		}
	}
}
