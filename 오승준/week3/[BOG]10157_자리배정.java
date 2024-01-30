package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		// 변수 다 받아용
		int C = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(br.readLine());

		// 좌석 배열 만들구요 (1,1)부터 시작하게 +1씩
		int[][] arr = new int[R + 1][C + 1];

		// 좌표별로 끝에 도달하는 상황에 방향 틀어야 돼요
		int xmax = C;
		int ymax = R;
		int xzr = 1;
		int yzr = 1;
		// 요기는 while 문 시작하는 변수
		int i = 1;
		int x = 1;
		int y = 1;

		while (i <= C * R) {
			// 초기 시작 (1,1)부터 시작, 일단 y좌표로 움직입니다.
			if (x == xzr && y == yzr) {
				for (int j = yzr; j <= ymax; j++) {
					arr[j][xzr] = i;
					i++;
				}
				y = ymax;
				continue;
			}
			// y좌표로 끝까지 갔으면 x로 움직여야쥬? xzr값은 이미 값이 찼으니까 시작은 xzr+1부터
			if (x == xzr && y == ymax) {
				for (int j = xzr + 1; j <= xmax; j++) {
					arr[ymax][j] = i;
					i++;
				}
				x = xmax;
				continue;
			}
			// x끝, y끝에 도착하면 y를 초기값으로 줄여야 합니다, 근데 이미 ymax 좌표는 값이 있으니까
			// 반복 시작을 ymax-1부터
			if (x == xmax && y == ymax) {
				for (int j = ymax - 1; j >= yzr; j--) {
					arr[j][xmax] = i;
					i++;
				}
				xzr++; // 이제 x초기값으로 돌아가야 하는데, 이미 원래 초기값은 자리가 찼으니
				y = yzr;	// 2부터 돌아가기 위해서 xzr를 조정해줍니당
				continue;
			}
			// (2,1)까지 돌아갑시다~
			if (x == xmax && y == yzr) {
				for (int j = xmax - 1; j >= xzr; j--) {
					arr[yzr][j] = i;
					i++;
				}
				xmax--;
				ymax--;
				yzr++; // 한바퀴를 돌았으니 xzr 올린것 처럼 안쪽 바퀴를 돌기 위해 변수값을 조정해주면 끝!
				x = xzr;
				y = yzr;
				continue;
			}
		}

		if (N > C * R) {				// 대기인원이 자리수보다 많으면 0나와야하고
			System.out.println(0);
		} else {
			for (int j = R; j >= 0; j--) {	// 아니면 좌표별로 대기 번호 찍어주면 끝
				for (int k = 0; k <= C; k++) {
					if (arr[j][k] == N) {
						System.out.println(k + " " + j); // k,j값은 저기 반복문에 넣으면 좋은데 귀찮아서ㅋㅎ
						break;
					}

				}
			}
		}

	}
}
