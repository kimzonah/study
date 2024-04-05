import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

class Solution {
	static int T, D, W, K;
	static int[][] film;
	static int[][] copy;
	static boolean[] change;
	static int ans;

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

	public static void main(String[] args) throws NumberFormatException, IOException {
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			D = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());

			film = new int[D][W];
			copy = new int[D][W];
			change = new boolean[D];
			ans = Integer.MAX_VALUE;

			for (int i = 0; i < D; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < W; j++) {
					film[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			if (!functionTest(film)) {
			makeOrder(0);
			}

			if (ans == Integer.MAX_VALUE) {
				bw.write("#" + t + " 0" + "\n");
			} else {
				bw.write("#" + t + " " + ans + "\n");

			}
		}
		bw.flush();
		bw.close();
	}

	private static boolean functionTest(int[][] arr) {

		// TODO Auto-generated method stub
		for (int i = 0; i < W; i++) {
			boolean flag = false;
			int count = 0;
			for (int j = 1; j < D; j++) {
				// 이전 숫자와 비교했을 때 같은 숫자면 카운트를 더해주는데,
				// 카운트가 2가 되면 같은 숫자가 3개이므로, 성능검사를 통과한다
				if (arr[j][i] == arr[j - 1][i]) {
					count++;
					if (count == K - 1) {
						flag = true;
						continue;
					}
				} else
					count = 0;
			}
			// 한 줄에서 테스트가 실패했을 경우 false를 반납
//			if (!test[i])
				//flag = false;
			if (!flag) return false;
		}
		// System.out.println(Arrays.toString(test));
		return true;
	}

	private static void chemicalTreat(int idx, int count) {
		if (count >= ans)
			return;

		if (idx == D) {
			if (functionTest(copy) && count < ans) {
				ans = count;
			}
			return;
		}

			// 타입에 따라 약품 처리(2는 아무 처리 하지 않음)
		if (change[idx]) {
            // A, B를 투입하는 경우 모두 처리해야 한다
			Arrays.fill(copy[idx], 0);
			chemicalTreat(idx + 1, count + 1);
			Arrays.fill(copy[idx], 1);
			chemicalTreat(idx + 1, count + 1);
		} else {
			chemicalTreat(idx + 1, count);
		}

	}

    // 조합이긴 한데 그냥 열 순서대로 약품 처리를 할지 말지를 결정하는 거
	private static void makeOrder(int idx) {
		if (idx == D) {
            // 배열을 사용해야 해서 깊은 복사로 배열 생성
			for (int i = 0; i < D; i++) {
				for (int j = 0; j < W; j++) {
					copy[i][j] = film[i][j];
				}
			}
			chemicalTreat(0, 0);
			return;
		}

		change[idx] = false;
		// 해당 인덱스를 변경하지 않음
		makeOrder(idx + 1);
		change[idx] = true;
		// 해당 인덱스를 변경
		makeOrder(idx + 1);

	}

}