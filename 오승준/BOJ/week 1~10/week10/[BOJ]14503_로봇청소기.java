import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int r, c;
	static int dir;
	static int[][] map;		//북 동 남 서
	static final int[] dr = { -1, 0, 1, 0 };
	static final int[] dc = { 0, 1, 0, -1 };
	static int count;
	static boolean check;
	static boolean flag;

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

	public static void main(String[] args) throws NumberFormatException, IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		dir = Integer.parseInt(st.nextToken());

		map = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// while문으로 불가능할 때까지 진행
		while (!flag) {
			check = false;
			// 내 자리가 0이면 청소
			if (map[r][c] == 0) {
				map[r][c] = 2;
				count++;
				// 내 자리가 2이면 2번 3번 진행
			} else {
				// 0 있는지 확인
				for (int i = 0; i < 4; i++) {
					
					if ( map[r + dr[i]][c + dc[i]] == 0) {
						check = true;
					}
				}
				if (check) {
					// 동서남북 중에 0이 있으면
					// 90도 회전하고 방향이 0이면 이동하는 메서드 실행
					rotate();
				} else {
					// 동서남북이 모두 0보다 크면
					// 뒤로 후진 가능한지 확인
					// 가능하면 후진하고
					// 벽이면 종료
					goBack();
				}
			}
		}
		bw.write(count + "");
		bw.flush();
		bw.close();

	}

	private static void rotate() {
        // 90도 반시계방향 회전, 델타 배열 순서 중요!
		dir--;
		if (dir == -1) {
			dir = 3;
		}
        // 먼저 회전하고, 앞 방향이 0이면 이동
		if ( map[r + dr[dir]][c + dc[dir]] == 0) {
			r = r + dr[dir];
			c = c + dc[dir];
		}
	}

	private static void goBack() {
        // 반대 방향 지정
		int backDir = dir - 2;
        // 북,동(0,1)의 경우에는 음수가 되니까 4 더해주면 딱 된다
		if (backDir < 0) {
			backDir = backDir + 4;
		}
        // 뒤방향이 1이 아니면 이동
		if ( map[r + dr[backDir]][c + dc[backDir]] != 1) {
			r = r + dr[backDir];
			c = c + dc[backDir];
		} else {
            // 뒷방향이 1이면 위의 while문을 종료
			flag = true;
		}
	}
}
