import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_11722_가장긴감소하는부분수열 {
	static int[] arr;
	static int N;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i< N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int result = DesCent();
		
		System.out.println(result);

	}
	
	public static int DesCent() {
		int[] dp = new int[N];
		int max = 0;
		for(int i = 0; i < N; i++) {
			dp[i] = 1; //처음은 본인만 수열이므로 1
			for(int j = 0; j < i; j++) {
				if(arr[i] < arr[j] && dp[i] < dp[j] + 1) { //이전항보다 작고, dp에도 저장된 수가 j+1이 더 크면.
					dp[i] = dp[j] + 1;
				}
			}
		}

		for(int i = 0; i < N; i++) {
			max = Math.max(max, dp[i]);//가장 큰 항 값을 리턴하게끔
		}
		
		return max;
	}

}
