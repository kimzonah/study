import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ_2638_치즈2 {
	static int N, M, time, cheeseCnt;
	static int[][] map;
	static boolean[][] check;
	static ArrayList<Cheese> cheeseList;
	static int[] dr = new int[] {-1, 1, 0, 0};
	static int[] dc = new int[] {0, 0, -1, 1};

	static class Cheese {
		int r, c; // 좌표를 저장하자..

		public Cheese(int r, int c) {
			this.r = r;
			this.c = c;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		cheeseList = new ArrayList<>();
		time = 0;
		cheeseCnt = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1) {
					cheeseList.add(new Cheese(i, j)); // 1이면 등록
					cheeseCnt++;// 치즈 수 증가
				}
			}
		}

		while (cheeseCnt != 0) {
			time++; // 시간 증가
			check = new boolean[N][M]; //방문배열 선언
			checkOutSide(); //외부 공기 체크하고
			melt(); //녹이고
		}
		
		System.out.println(time);

	}

	public static void melt() {//for-each문 썼는데 오류나네..
		int size = cheeseList.size();
		for (int i = size - 1; i >= 0; i--) { // 크기 만큼 반복을 할건데..
			int cnt = 0; // 2번이상이면 녹여야됨

			for (int d = 0; d < 4; d++) {
				int nr = cheeseList.get(i).r + dr[d];
				int nc = cheeseList.get(i).c + dc[d];
				
				if(map[nr][nc] == 2) { //외부공기와 접촉
					cnt++;
				}
			}
			
			if(cnt >= 2) { //2개가 넘으면 녹는거야.
				map[cheeseList.get(i).r][cheeseList.get(i).c]= 0; // 녹아서 0이되었고
				cheeseCnt--; //치즈하나 감소하고
				cheeseList.remove(i); //그 인덱스를 삭제한다.
				//이대로 멈추면 오류 뜨니까 i를 다시 돌려줘야함
			}
		}
	}

	public static void checkOutSide() {
		Deque<Cheese> dq = new ArrayDeque<>();// 큐하나 만들어서..
		dq.add(new Cheese(0, 0)); // 시작점은 0이니까 넣어주고
		check[0][0] = true;
		map[0][0] = 2; // 외부공기 == 2

		while (!dq.isEmpty()) {
			Cheese cheese = dq.poll();

			for (int d = 0; d < 4; d++) {
				int nr = cheese.r + dr[d];
				int nc = cheese.c + dc[d];

				if (nr >= 0 && nr < N && nc >= 0 && nc < M && !check[nr][nc] && map[nr][nc] != 1) { // 외부면..
					map[nr][nc] = 2;
					dq.add(new Cheese(nr, nc)); // 추가해서
					check[nr][nc] = true; // 방문 처리
				}
			}
		}
	}

}