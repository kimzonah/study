import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1303_전쟁_전투 {
	static int N, M;
	static char[][] field;
	static int wP, bP;
	static int power = 0; // 힘을 저장할 변수
	static boolean[][] check; // 방문 표시
	static int[] dx = new int[] { 0, 1, 0, -1 }; // 상,하,좌,우
	static int[] dy = new int[] { 1, 0, -1, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		field = new char[M][N];
		check = new boolean[M][N];
		//직사각형 배열 M이랑 N 개헷갈립니다...................
		//N이 가로니까 2번째에 가야하고
		//M이 세로니까 1번째에 가야함....
		for (int i = 0; i < M; i++) {
			String str = br.readLine(); // 문자열 받고
			for (int j = 0; j < N; j++) {
				field[i][j] = str.charAt(j); // 여기에 charAt을 이용해 저장
			}
		}

		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) { //반복문을 돌다가
				if (field[i][j] == 'W' && !check[i][j]) { //W를 만나면
					power = dfs(i, j, 'W'); //W에 대한 dfs 시행하는데, power(병사수)를 세줌
					wP += (int)Math.pow(power, 2); //제곱한 값 더해주고
					power = 0; //다음에 W가 또 있을수도 있으니 0으로 초기화해줌
					
				} else if (field[i][j] == 'B' && !check[i][j]) {
					power = dfs(i, j, 'B'); //똑같은 방식인데, B를 만날때 수행
					bP += (int)Math.pow(power, 2);
					power = 0;
				}
			}
		}
		
		System.out.println(wP + " " + bP); //마지막 출력
		

	}

	public static int dfs(int x, int y, char ch) {
		check[x][y] = true;
		power++; //만날때마다 카운트해준다
		for (int d = 0; d < 4; d++) {// 4방 탐색
			int nx = x + dx[d];
			int ny = y + dy[d]; // 한방향씩 이동하고.
			if (nx >= 0 && nx < M && ny >= 0 && ny < N && !check[nx][ny] && field[x][y] == field[nx][ny]) {
				dfs(nx, ny, ch); //같은 문양을 계속 만나면 dfs 지속적으로 수행
			}
		}

		return power;

	}

}
