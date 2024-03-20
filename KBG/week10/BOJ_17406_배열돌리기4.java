import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_17406_배열돌리기4 {
	static int N, M, K;
	static int[][] cycle, map;
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		map = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		cycle = new int[K][3];

		for (int k = 0; k < K; k++) {
			st = new StringTokenizer(br.readLine());
			cycle[k][0] = Integer.parseInt(st.nextToken()) - 1;
			cycle[k][1] = Integer.parseInt(st.nextToken()) - 1;
			cycle[k][2] = Integer.parseInt(st.nextToken());
		}
		int[] arr = new int[K];
		boolean[] check = new boolean[K];
		permu(0, arr, check);

		System.out.printf("%d", min);

	}

	public static void permu(int cnt, int[] arr, boolean check[]) {
		if (cnt == K) {
			doCycle(arr);
			return;
		}

		for (int i = 0; i < K; i++) {
			if (check[i]) {
				continue;
			}
			check[i] = true;
			arr[cnt] = i;
			permu(cnt + 1, arr, check);
			check[i] = false; // 끝나면 다시 f로
		}
	}

	public static int[][] copyMap() {
		int[][] tmp = new int[N][M];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				tmp[i][j] = map[i][j]; // 원본이 삭제되면 안되므로.
			}
		}
		return tmp;
	}

	public static void doCycle(int[] arr) {
		int[][] tmp = copyMap();

		for (int k = 0; k < K; k++) {
			int r = cycle[arr[k]][0];
			int c = cycle[arr[k]][1];
			int S = cycle[arr[k]][2];

			for (int s = 1; s <= S; s++) {
				// 위
				int upTmp = tmp[r - s][c + s];
				for (int y = c + s; y > c - s; y--) {
					tmp[r - s][y] = tmp[r - s][y - 1];
				}
				// 오른쪽
				int rightTmp = tmp[r + s][c + s];
				for (int x = r + s; x > r - s; x--) {
					tmp[x][c + s] = tmp[x - 1][c + s];
				}
				tmp[r - s + 1][c + s] = upTmp;
				// 아래
				int leftTmp = tmp[r + s][c - s];
				for (int y = c - s; y < c + s; y++) {
					tmp[r + s][y] = tmp[r + s][y + 1];
				}
				tmp[r + s][c + s - 1] = rightTmp;
				// 왼쪽
				for (int x = r - s; x < r + s; x++) {
					tmp[x][c - s] = tmp[x + 1][c - s];
				}
				tmp[r + s - 1][c - s] = leftTmp;
			}
		}

		getAnswer(tmp);
	}

	public static void getAnswer(int[][] tmp) { // 답 얻는 함수, 최소 합의 행..
		for (int i = 0; i < N; i++) {
			int sum = 0;
			for (int j = 0; j < M; j++) {
				sum += tmp[i][j];
			}
			if (min > sum) {
				min = sum;
			}
		}
	}

}
