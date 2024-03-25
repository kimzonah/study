import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1182_모든수열의합{
	static int N, S;
	static int[] arr;
	static int ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		arr = new int[N];

		ans = 0;
		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());// 배열에저장
		}

		permu(0, 0);
		
		if(S == 0) {
			ans--;
		}

		System.out.println(ans);

	}

	public static void permu(int cnt, int sum) {
		if (cnt == N) {
			if (sum == S) {
				ans++; // 다안채워도됨
			}
			return;
		}
		permu(cnt + 1, sum + arr[cnt]); //이전 거 더해주기 case1
		permu(cnt + 1, sum); //혼자 혹은 이 때 까지의 합으로도 부분수열이 될 수도 있으므로 case2

	}

}
