import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;
// [BOJ]17281_야구40,60,78번줄 수정사항 update
class Main {
	static int N;
	static int[][] arr;

	static int[] numbers;
	static int[] visited;
	static int max = Integer.MIN_VALUE;

	static BufferedReader br;
	static BufferedWriter bw;
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		// 17281 야구
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());
		arr = new int[N][10];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= 9; j++) {
				// 각 이닝 별 타자의 점수를 입력
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		numbers = new int[10];
		visited = new int[10];
		// idx = 1인 타자가 4번에 고정
		//(수정) 범규처럼 visited설정하고 넘겼어
		// 수정) 수열 정하는 부분에서 if가 하나 더 생겨서 그런지 시간초과 발생
		numbers[4] = 1;
		visited[4] = 1;
		// 2~9번 타자는 M과 N으로 순서 설정
		selectNum(2);

		bw.write(max + "");
		bw.flush();
		bw.close();
	}

	static void selectNum(int count) {
		if (count == 10) {
			game();
			return;
		}
		for (int i = 1; i < 10; i++) {
			// numbers[4]는 이미 들어가 있으므로 skip
			// count가 4가 아니라면 visited 보고 DFS 순회
			// (수정) 여기서도 visited[4] 보고 넘어감, 시간초과 발생했어서
			if (visited[i] != 1) {
				visited[i] = 1;
				numbers[i] = count;
				selectNum(count + 1);
				visited[i] = 0;
			}
		}
	}

	static void game() {
		int score = 0;
		int outcnt = 0;
		boolean[] mound = new boolean[3];

		int i = 0;
		int j = 1;
		// (수정)범규처럼 상황별 케이스를 다 입력했으 ㅠ
		// (수정)j는 따로 for문 없이 마지막에 더해주면서 10되면 초기화하는 식으로
		while (i != N) {
			if (arr[i][numbers[j]] == 0) {
				outcnt++;
			} else if (arr[i][numbers[j]] == 1) {
				for (int k = 2; k >= 0; k--) {
					if (mound[k]) {
						if (k == 2) {
							score++;
							mound[k] = false;
						} else {
							mound[k] = false;
							mound[k + 1] = true;
						}
					}
				}
				mound[0] = true;
			} else if (arr[i][numbers[j]] == 2) {
				for (int k = 2; k >= 0; k--) {
					if (mound[k]) {
						if (k == 2 || k == 1) {
							score++;
							mound[k] = false;
						} else {
							mound[k] = false;
							mound[k + 2] = true;
						}
					}
				}
				mound[1] = true;
			} else if (arr[i][numbers[j]] == 3) {
				for (int k = 2; k >= 0; k--) {
					if (mound[k]) {
						score++;
						mound[k] = false;
					}
				}
				mound[2] = true;
			} else {
				for (int k = 2; k >= 0; k--) {
					if (mound[k]) {
						score++;
						mound[k] = false;
					}
				}
				score++;
			}
			if (outcnt == 3) {
				mound = new boolean[3];
				i++;
				outcnt = 0;
			}
			j++;
			if (j == 10)
				j = 1;
		}
		max = Math.max(max,score);

	}

}
