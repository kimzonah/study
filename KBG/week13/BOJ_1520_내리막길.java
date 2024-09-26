import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1520_내리막길 {
	static int M, N;
	static int[][] map, dp;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 }; // 상하좌우

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new int[M][N];
		dp = new int[M][N];
		
		for(int i = 0; i < M; i++) {
			Arrays.fill(dp[i], -1); //dp로 방문 배열 체크...
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		} // 맵에다 넣고..

		int cnt = dfs(0, 0);
		
		System.out.println(cnt);


	}

	public static int dfs(int r, int c) {
		if (r == M - 1 && c == N - 1) {// 끝점이면
			return 1;
		}
		
		if(dp[r][c] != -1) { //방문했으면 필요없음
			return dp[r][c];
		}
		
		int h = map[r][c];
		dp[r][c] = 0;
		// 아직 아니라면 탐방
		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];

			if (nr >= 0 && nr < M && nc >= 0 && nc < N) { // 범위 내일 때
				if (map[r][c] > map[nr][nc]) { // 주변이 높이가 더 높다면
					dp[r][c] += dfs(nr, nc);
				}
			}
		}
		
		return dp[r][c];
	}

}
