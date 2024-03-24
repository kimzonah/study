import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {
	static int N;
	static int[][] arr;
	static int ans;
	static boolean[][] visited;
	static int Ssize = 2;
	static int eatCnt;
	static final int[] dr = { -1, 0, 1, 0 };
	static final int[] dc = { 0, -1, 0, 1 };
	static int startR = 0;
	static int startC = 0;
	static int[] fish;

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(br.readLine());

		arr = new int[N][N];
		visited = new boolean[N][N];
		fish = new int[10];

		// map 입력 받고
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			// 먹이에 대한 BFS 진행
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] == 9) {
					startR = i;
					startC = j;
				}
			}
		}
		// 처음 지점에서 BFS 시작
		BFS(startR, startC);

		// BFS가 끝나면 엄마 호출 => 카운트 입력
		bw.write(ans + "");
		bw.flush();
		bw.close();

	}

	// 먹이를 먹을 때마다 BFS를 실행한다
	private static void BFS(int r, int c) {
		// 다음 BFS를 위한 위치 지정
		int nextR = -1;
		int nextC = -1;

		int count = 0;
		// 넘어갈지 말지(먹을 수 있는지 없는지)
		boolean flag = false;
		visited = new boolean[N][N];
		Queue<int[]> q = new LinkedList<>();

		int[] start = { r, c };
		arr[r][c] = 0;
		q.add(start);
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {

				int[] node = q.poll();

				int a = node[0];
				int b = node[1];
//				System.out.println(a +" "+ b);
				visited[a][b] = true;

				// 노드 내의 물고기가 있고 상어보다 크기가 작다?
				// 잡아먹자!
				if (arr[a][b] > 0 && arr[a][b] < Ssize) {
					flag = true;
					// 노드 중에 잡아먹을 수 있으면 다음 단계로 넘어가기 위한 플래그 true
					// 해당 depth 내에서 사냥 가능한 물고기의 좌표를 저장
					// 가능한 위쪽, 왼쪽으로 설정
					if (nextR != -1 || nextC != -1) {
						if (a < nextR) {
							nextR = a;
							nextC = b;
						}
						else if (a == nextR) {
							if (b < nextC)
								nextC = b;
						}
					} else {
						nextR = a;
						nextC = b;
					}

				}

				for (int j = 0; j < 4; j++) {
					// 배열 범위 내에서 방문하지 않고 상어보다 작거나 같은 물고기가 있으면 이동 가능
					int[] newNode = { a + dr[j], b + dc[j] };
					if (newNode[0] >= 0 && newNode[1] >= 0 && newNode[0] < N && newNode[1] < N
							&& !visited[newNode[0]][newNode[1]] && arr[newNode[0]][newNode[1]] <= Ssize) {
						q.offer(newNode);
					}
				}

			}

			if (flag) {
				// 먹은 만큼 카운트 증가
				eatCnt++;
				// 상어가 잡아먹은 횟수가 size에 도달하면 크기를 키우고 eatCnt 초기화
				if (eatCnt == Ssize) {
					Ssize++;
					eatCnt = 0;
				}
				ans += count;
				// 잡아먹은 후엔 다시 먹을 수 있는 가장 가까운 지점을 찾기 위해 BFS

				BFS(nextR, nextC);
				return;
			}

			// BFS 깊이 만큼 count 증가
			count++;
		}
	

	}

}