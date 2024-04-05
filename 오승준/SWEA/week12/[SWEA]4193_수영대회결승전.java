import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Solution{
	static int T,N;
	static int[][] map;
	static final int[] dr= {-1,0,1,0};
	static final int[] dc = {0,-1,0,1};
	static int ans;
	
	static int stR,stC,enR,enC;
	static boolean[][] visited;
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws NumberFormatException, IOException {
		T = Integer.parseInt(br.readLine());

        // BFS 방식을 활용한 문제 풀이
        // 근데 소용돌이를 만나면 소용돌이가 없어질 때까지 기다려야 한다
		for(int t=1;t<=T;t++) {
			N = Integer.parseInt(br.readLine());
			map= new int[N][N];
			visited= new boolean[N][N];
			ans = 0;
			for(int i=0;i<N;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<N;j++) {
					 map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			st = new StringTokenizer(br.readLine());
			stR = Integer.parseInt(st.nextToken());
			stC = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			enR = Integer.parseInt(st.nextToken());
			enC = Integer.parseInt(st.nextToken());
			
			BFS(stR,stC);
			
			if(ans == 0) ans = -1;
			bw.write("#"+t+" "+ans+"\n");
			
		}
		bw.flush();
		bw.close();
	}
    
	private static void BFS(int r, int c) {
		Queue<int[]> q = new LinkedList<>();
		int count= 0;
		
		q.add(new int[] {r,c});
		visited[r][c] = true;
		
		while(!q.isEmpty()) {
			int size = q.size();
			count++;
			for(int i=0;i<size;i++) {
				int[] node = q.poll();
				if(node[0]==enR&&node[1]==enC) {
					ans = count-1;
					return;
				}
				for(int j=0;j<4;j++) {
					int nr = node[0]+dr[j];
					int nc = node[1]+dc[j];
					if(nr>=0&&nc>=0&&nr<N&&nc<N&&!visited[nr][nc]) {
						if(map[nr][nc]==0) {
							visited[nr][nc]= true;
							q.add(new int[] {nr,nc});
                            // 앞의 칸이 소용돌이?!?!?
						} else if(map[nr][nc]==2) {
                            // 시간이 3으로 나누어질 때까지 기다려야 한다
                            // 이 때 해당 방향이 아닌 다른 방향으로는 진행이 되야하므로
                            // 해당 지점을 다시 queue에 돌려 놓는다
                            
                            // 그렇게 하면 소용돌이가 아닌 다른 지점은 이동하면서
                            // visited 가 체크되어 다음 깊이에서 해당 노드를 뽑았을 때
                            // 소용돌이 방향만 바라볼 수 있게 된다
							if(count%3==0) {
								visited[nr][nc]= true;
								q.add(new int[] {nr,nc});
							} else {
								q.add(node);
							}
						}
					}
				}
			}
		} 
		
	}
}