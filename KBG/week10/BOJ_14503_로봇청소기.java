import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14503_로봇청소기 {
	static int N,M;
	static int r,c,d;
	static int[][] cleaner;
	static int[] dx = new int[] {-1, 0, 1, 0};
	static int[] dy = new int[] {0, 1, 0, -1};
	static int count = 1;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken()); //행
		c = Integer.parseInt(st.nextToken()); //열
		d = Integer.parseInt(st.nextToken()); //방향
		//0 정면 1 동쪽 2 남쪽 3 서쪽
		//방향 전환 ==> (d + 3) % 4
		
		cleaner = new int[N][M];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				cleaner[i][j] = Integer.parseInt(st.nextToken());
				//배열에 값 저장
			}
		}
		
		clean(r, c, d);
		System.out.println(count);
	}
	
	public static void clean(int x, int y, int dir) {
		cleaner[x][y] = -1; //청소 끝
		
		for(int i = 0; i < 4; i++) { //이건 90도 꺾이는거
			dir = (dir+3) % 4; //방향 전환
			
			int nx = x + dx[dir];
			int ny = y + dy[dir];
			
			if(nx >= 0 && ny >= 0 && nx < N && ny < M) {
				if(cleaner[nx][ny] == 0) { //청소 계속
					count++; //카운트도 증가하고
					clean(nx, ny, dir);
					return; 
				}
			}
		}
		
		int dir2 = (dir + 2) % 4; //반대 방향
		int br = x + dx[dir2];
		int bc = y + dy[dir2];
		if(br >= 0 && bc >= 0 && br < N && bc < M && cleaner[br][bc] != 1) {//벽이 아니라면
			clean(br, bc, dir); //후진이므로 바라보는 방향은 유지한다.
		}
	}

}
