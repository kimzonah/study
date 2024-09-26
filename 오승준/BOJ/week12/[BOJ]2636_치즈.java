import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[][] arr;
	static boolean[][] visited;
	static int[] dr = { 0, -1, 0, 1 };
	static int[] dc = { -1, 0, 1, 0 };
	static Queue<int[]> q;

	static int count;
	static int cheeze;
	static int a, b;
	static int ans;

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		// 풀이 과정
		// 1. 전체 배열을 생성
		// 2. (0,0)부터 BFS 시작, 1을 만나면 3으로 변경
		// 3. BFS가 완료된 후 3인 지점을 모두 0으로 변경,
		// 이때 3인 지점의 수가 녹아 없어진 치즈의 수고, 카운트는 1증가
		// 4. 3으로 변한 지점이 0일 경우 카운트와 이전 치즈 값을 반환
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		arr = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
        //1. 배열 생성 및 초기화
		q = new LinkedList<>();
		visited = new boolean[N][M];
		ans = 0;
		cheeze = -1;

			// 2.BFS 시작
		BFS(0, 0);

		
        // 카운트가 비어있을 때도 한번 돌아서 -1해주면 끝
		bw.write((count - 1) + "\n" + ans);
		bw.flush();
		bw.close();

	}

	private static void BFS(int r, int c) {
		Queue<int[]> q2 = new LinkedList<>();
		q.add(new int[] { r, c, });

		while (!q.isEmpty()) {

			int size = q.size();
			for (int i = 0; i < size; i++) {
				int[] node = q.poll();
				visited[node[0]][node[1]] = true;
				for (int j = 0; j < 4; j++) {
					int nr = node[0] + dr[j];
					int nc = node[1] + dc[j];
					if (nr >= 0 && nc >= 0 && nr < N && nc < M && !visited[nr][nc]) {
						visited[nr][nc] = true;
						if (arr[nr][nc] == 0) {
							// 0인 지점을 모두 탐색하며 visited 진환
							q.add(new int[] { nr, nc });
						} else if (arr[nr][nc] == 1) {


							// 치즈를 만나면 다른 queue에 저장 
							q2.add(new int[] {nr,nc});


						}
					}
				}
			}
			// 4. 모든 인접 노드를 돌았으면 q2(3을 넣었던 큐)를 비운다
            // q2에 있는 만큼 치즈가 녹았다!!
			if (q.isEmpty()) {
				count++;
				cheeze= 0;
				while(!q2.isEmpty()) {
					int[] ang = q2.poll();
					arr[ang[0]][ang[1]]=0;
					q.add(ang);
					cheeze++;
				}
			} 
            // 치즈가 0이면 더 이상 map에 남은 치즈가 없었다는 뜻이므로
            // ans 갱신해주면 안돼. 갱신은 치즈가 녹았을 때만 해주ㅓ어
			if (cheeze != 0) {
				ans = cheeze;
			}
		}

	}
}