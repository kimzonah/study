import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1012_유기농배추 {
	static int[][] arr;
	static boolean[][] check;
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 }; // 상하좌우
	static int M, N, K; // 가로와 세로길이

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken()); // 가로
			N = Integer.parseInt(st.nextToken()); // 세로
			K = Integer.parseInt(st.nextToken()); // 배추 수
			arr = new int[M][N];
			check = new boolean[M][N];
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				arr[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 1;
				// 입력받은 곳에 1을 넣어 배추가 있다는 것을 알림!
			}

			int max = 0;
			int cnt = 0;
			for (int i = 0; i < M; i++) {
				for (int j = 0; j < N; j++) {
					if (arr[i][j] == 1 && !check[i][j]) { // 1인데 아직 방문하지 않았다면
						cnt++;
						dfs(i, j);
					}
				}

			}

			max = Math.max(max, cnt);
			System.out.println(max);

		}
	}

	public static void dfs(int x, int y) {
		check[x][y] = true;

		for (int d = 0; d < 4; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];

			if (nx < 0 || nx >= M || ny < 0 || ny >= N || check[nx][ny] || arr[nx][ny] == 0) {
				continue;
			}

			dfs(nx, ny); // 계속 탐방
		}
	}

}
