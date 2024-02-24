import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

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
		// 17281 야구 -> 시간초과, 수열로 받는게 아닌가? 받는거만 해도 1초가 지나가네
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
		numbers[4] = 1;
		// 2~9번 타자는 M과 N으로 순서 설정
		selectNum(1);
		
		bw.write(max+"");
		bw.flush();
		bw.close();
	}

	static void selectNum(int count) {
		if (count == 10) {
			// count == 10이면(index 9까지의 순서가 완성되면)
			// 선수들의 순서대로 게임을 시작
			int a = game(numbers);
			if(max<a) {
				max = a;
				
			}
			return;
		}
		for (int i = 2; i < 10; i++) {
			// numbers[4]는 이미 들어가 있으므로 skip
			if (count == 4) {
				selectNum(count + 1);
			}
			// count가 4가 아니라면 visited 보고 DFS 순회
			else if (visited[i] != 1) {
				visited[i] = 1;
				numbers[count] = i;
				selectNum(count + 1);
				visited[i] = 0;
			}
		}
	}

	static int game(int[] number) {
		Stack<Integer> q = new Stack<>();
		// 점수는 queue로 받아볼끼? -> 시간 초과
		// 반대를 stack으로 받음 ? -> 시간 초과
		int score = 0;
		int outcnt = 0;
		// i(이닝수), j(순번)설정
		int j = 0;
		int i = 0;
		while(i!=N) {
			if(arr[i][number[(j%9)+1]]==0) {
				outcnt++;
			} else {
				score++;
			}
			if(outcnt==3) {
				i++;
				outcnt = 0;
			}
			j++;
		}
		return score;
	}
}
// 순서에 맞게 각 타자의 기록에 따라 점수를 기록한다
// 현재 마운드의 상황을 기록하는 1차 배열 생성
// 1 - 0번  배열에 1, 1이 있으면 다음 자리에 1 넘김
// 2 - 1번 배열에 1, 0번에 1있었으면 3, 1,2번에 있었으면 비우고 점수 추가
// 3 - 2번 배열에 1, 0,1,2,에 있었으면 비우고 점수 추가
// 4 - 전부 비우고 1이 있던 만큼 점수 추가
// 0 - 배열은 나두고 out 1추가, 아웃이 3이 되면 다음 이닝의 행을 불러온다
// 주어진 이닝 * 3(아웃카운트)면 게임이 종료되니까 그만큼 반복하면서
// 점수의 최댓값을 구해주면 되겠다
