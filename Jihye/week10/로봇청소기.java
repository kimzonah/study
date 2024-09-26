package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 로봇청소기 {
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, -1, 0, 1};
	static int[][] arr;
	static int N, M, r, c, dir, cnt = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		
		// 상, 좌, 하, 우 순으로 다시 정렬
		if (d == 3) dir = 1;
		else if (d == 1) dir = 3;
		else dir = d;
		
		arr = new int[N][M];
		
		for (int r = 0; r < arr.length; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < arr[0].length; c++) {
				arr[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 청소 시작
		clean(r, c, dir);
		System.out.println(cnt);
	}
	
	public static void clean(int r, int c, int dir) {
		// 청소가 되지 않았다면 ?
		if (arr[r][c] == 0) {
			arr[r][c] = -1;
			cnt++;
		}
		
		// 이미 반시계로 회전해서 사방 탐색 시작 
		for (int d = dir + 1; d <= dir + 4; d++) {
			int nr = r + dr[d % 4];
			int nc = c + dc[d % 4];
			
			if (nr < 0 || nr >= N || nc < 0 || nc >= M || arr[nr][nc] == 1) continue;
			if (arr[nr][nc] == 0) {
				clean(nr, nc, d);
				// break;는 왜 안됨 ???
				return;
			}
		}
		
		// 사방 탐색 결과 청소 안된 구역이 없으면 후진
		back(r, c, dir);
	}
	
	private static void back(int r, int c, int dir) {
		int d = (dir + 2) % 4;
		int nr = r + dr[d];
		int nc = c + dc[d];
		if(arr[nr][nc] == 1) {
			return;
		} else {
			clean(nr, nc, dir);
		}
	}
	
}
