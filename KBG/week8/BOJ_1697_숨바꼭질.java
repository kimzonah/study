package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ_1697_숨바꼭질 {
	static int N, K;
	static int[] check;
	static int[] arr;
	static int count = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 해답 : BFS

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		arr = new int[100001];
		check = new int[100001];

		System.out.println(bfs(N));
		

		
	}

	public static int bfs(int n) {
		if(n == K) {
			return 0;
		}

		Deque<Integer> queue = new ArrayDeque<>();// 큐에 먼저 놓고
		queue.add(n);
		check[n] = 1;
		while (!queue.isEmpty()) {// 비지않을 때 까지
			int num = queue.poll(); // 맨 앞에있는거 꺼내주고

			if (num == K) {
				return check[num] - 1; // 만약 K라면 바로 브레이크
			}
			
			if (num - 1 >= 0 && check[num - 1] == 0) {// 아직 방문 안됐으면
				queue.add(num - 1);
				check[num - 1] = check[num] + 1; //한번 더 이동한것이므로 1추가
			}
			if (num + 1 <= 100000 && check[num + 1] == 0) {
				queue.add(num + 1);
				check[num + 1] = check[num] + 1;
			}
			if (num * 2 <= 100000 && check[num * 2] == 0) {
				queue.add(num * 2);
				check[num * 2] = check[num] + 1;
			}
		}
		return -1;
	}

}
