import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Solution{
	static int T,N;
	static int ans;
	static int[] dr = {0,1,0,-1}; // 동 남 서 북  (시계)
	static int[] dc = {1,0,-1,0};
	
	static int stR,stC;
	static int[][] map;
	static List<int[]>[] worm;
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws NumberFormatException, IOException {
		T = Integer.parseInt(br.readLine());
		for(int t=1;t<=T;t++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N+2][N+2];
			// 웜홀은 리스트에 넣고 확인하자
			worm = new ArrayList[11];
			for(int i=6;i<=10;i++) {
				worm[i] = new ArrayList<>();
			}
			ans = 0;
			stR = 0;
			stC = 0;
			
			for(int i=0;i<N+2;i++) {
				// 벽도 반대 방향으로 튀기니까 +2해서 가벽을 설정한다
				map[0][i] = 5;
				map[N-1][i] = 5;
				map[i][0] = 5;
				map[i][N-1] = 5;
			}
			
			for(int i=1;i<=N;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=1;j<=N;j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					// 6 이상의 값은 리스트로 저장
					if(map[i][j]>5) {
						worm[map[i][j]].add(new int[] {i,j});
					}
				}
			}
			
			// 어디서 시작해야 최고점인지 모르겠는데.. 일단 모든 점에서 찾아보자
			for(int i=1;i<=N;i++) {
				for(int j=1;j<=N;j++) {
					if(map[i][j]==0) {
						stR = i;
						stC = j;
						for(int k=0;k<4;k++) {
							findPath(stR,stC,2,0,k);
						}
					}
				}
			}
			
			bw.write("#"+t+" "+ans+"\n");
		}
		bw.flush();
		bw.close();
		
	}
	private static void findPath(int i, int j, int over, int score, int dir) {
		if(!(i>=0&&j>=0&&i<=N+1&&j<=N+1))return;
		if((i==stR&&j==stC)||map[i][j]==-1) {
			// 맨 처음 스타트 지점에서 시작해서 over를 2로 설정하고
			// 다시 스타트 지점이나 -1(블랙홀)을 만나면 over를 감소시킨다
			// over가 0이 되면 지금까지의 스코어를 ans와 비교한다
			over--;
			if(over==0) {
				if(ans<score) ans = score;
				return;
			}
		}
		// over가 아직 1인 경우는 방향에 따라서 이동한다
		
		// 정해진 방향으로 이동하는데 0이나 블랙홀이면 그냥 이동
		// 벽에 따라서는 방향을 다르게 준다
		if(map[i][j]<=0) {
			findPath(i+dr[dir],j+dc[dir],over,score,dir);
		} else if(map[i][j]==1) {
			// 도착한 지점이 벽인 경우 score를 1늘려주고, 벽에 따라 방향을 다르게 준다
			// 동,북 방향이면 반대 방향, 서,남 방향이면 90도 회전
			if(dir==0||dir==3) findPath(i+dr[(dir+2)%4],j+dc[(dir+2)%4],over,score+1,(dir+2)%4);
			else if(dir==1) findPath(i+dr[(dir-1)%4],j+dc[(dir-1)%4],over,score+1,(dir-1)%4);
			else findPath(i+dr[(dir+1)%4],j+dc[(dir+1)%4],over,score+1,(dir+1)%4);
			
		} else if(map[i][j]==2) {
			if(dir==0||dir==1) findPath(i+dr[(dir+2)%4],j+dc[(dir+2)%4],over,score+1,(dir+2)%4);
			else if(dir== 2) findPath(i+dr[(dir-1)%4],j+dc[(dir-1)%4],over,score+1,(dir-1)%4);
			else findPath(i+dr[(dir+1)%4],j+dc[(dir+1)%4],over,score+1,(dir+1)%4);
			
		} else if(map[i][j]==3) {
			if(dir==1||dir==2) findPath(i+dr[(dir+2)%4],j+dc[(dir+2)%4],over,score+1,(dir+2)%4);
			else if(dir== 3) findPath(i+dr[(dir-1)%4],j+dc[(dir-1)%4],over,score+1,(dir-1)%4);
			else findPath(i+dr[(dir+1)%4],j+dc[(dir+1)%4],over,score+1,(dir+1)%4);
			
		} else if(map[i][j]==4) {
			if(dir==2||dir==3) findPath(i+dr[(dir+2)%4],j+dc[(dir+2)%4],over,score+1,(dir+2)%4);
			else if(dir== 0) findPath(i+dr[(dir+3)%4],j+dc[(dir+3)%4],over,score+1,(dir+3)%4);
			else findPath(i+dr[(dir+1)%4],j+dc[(dir+1)%4],over,score+1,(dir+1)%4);
		
		} else if(map[i][j]==5) {
			findPath(i+dr[(dir+2)%4],j+dc[(dir+2)%4],over,score+1,(dir+2)%4); // 전부 반대로
		} else {
			// 5 이상은 웜홀, 쌍을 지으니 list에 있는 값과 비교하여 진행한다
			if(worm[map[i][j]].get(0)[0]==i&&worm[map[i][j]].get(0)[1]==j) {
				findPath(worm[map[i][j]].get(1)[0]+dr[dir],worm[map[i][j]].get(1)[1]+dc[dir],over,score,dir);
			} else findPath(worm[map[i][j]].get(0)[0]+dr[dir],worm[map[i][j]].get(0)[1]+dc[dir],over,score,dir);
		}
	}
}