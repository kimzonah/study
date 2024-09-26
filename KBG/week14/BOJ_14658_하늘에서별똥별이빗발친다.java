import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_14658_하늘에서별똥별이빗발친다 {
	static int N, M, L, K;
	static int cnt, max; // 별똥별이 구역내에 몇개있나..(구역별 별 갯수)
	static ArrayList<Node> star;

	static class Node {
		int x, y;

		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken()); // 가로
		M = Integer.parseInt(st.nextToken()); // 세로
		L = Integer.parseInt(st.nextToken()); // 한번의 길이!
		K = Integer.parseInt(st.nextToken()); // 별똥별 수

		star = new ArrayList<>();
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			star.add(new Node(x, y)); // 좌표들을 추가한다.
		}
		max = 0;
		int ans = 0;
		for (Node n1 : star) { // x좌표만 뽑을놈
			for (Node n2 : star) { // y좌표 뽑을놈
				ans = Math.max(ans, cycle(n1.x, n2.y));
			}
		}
		
		System.out.println(K - ans);

	}

	public static int cycle(int x, int y) {
		cnt = 0;
		for(Node n3 : star) {
			if(x <= n3.x && n3.x <= x + L && y <= n3.y && n3.y <= y + L){
				cnt++;
			}
		}
		return cnt;
	}

}
