package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 유기농배추 {
	// 2차원 boolean 배열로 만들겁니다.
	static boolean[][] arr, visited;
	static int cnt, T, M, N, K, nr, nc;
	
	// 델타 배열 만들기
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int x, y;
		
		T = Integer.parseInt(br.readLine());
		
		for (int testCase = 0; testCase < T; testCase++) {
			cnt = 0;
			
			// M, N, K 입력 받기
			st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			arr = new boolean[M][N];
			visited = new boolean[M][N];
			
			// arr 배열 값 채워넣기
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				x = Integer.parseInt(st.nextToken());
				y = Integer.parseInt(st.nextToken());
				arr[x][y] = true; 
			}
			
			// for문을 돌면서 탐색해요
			for (int i = 0; i < M; i++) {
				for (int j = 0; j < N; j++) {
					// 배열이 true면서 방문한 적 없으면 dfs
					if (arr[i][j] && !visited[i][j]) {
						dfs(i, j);
					}
				}
			}
			sb.append(cnt).append("\n");
		}
		System.out.println(sb);
	}
	
	static void dfs(int r, int c) {
		// 방문 처리
		visited[r][c] = true;
		
		// 4방 탐색
		for (int d = 0; d < 4; d++) {
			nr = r + dr[d];
			nc = c + dc[d];
			
			// 인덱스 값 범위 처리
			if (nr >= 0 && nr < M && nc >= 0 && nc < N) {
				if (arr[nr][nc] && !visited[nr][nc]) { 
					dfs(nr, nc);
					return;
				}
			}
		}
		cnt++;
	}
}
