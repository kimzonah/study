import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1106_호텔 {
	static int C, N;
	static int[] dp;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		C = Integer.parseInt(st.nextToken()); //구해야하는 인원수
		N = Integer.parseInt(st.nextToken()); //홍보 가능한 도시
		
		dp = new int[C + 101]; //최대 C + 100명을 구할 수 있음
		Arrays.fill(dp, (C+100) * 100); //최댓 값으로 치환
		dp[0] = 0; //0의 비용 -> 0명
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int cost = Integer.parseInt(st.nextToken()); //비용
			int customer = Integer.parseInt(st.nextToken()); //고객 수
			for(int j = customer; j < C + 101; j++) {//최소 고객 수부터, 최대 구할 수 있는 수 까지
				dp[j] = Math.min(dp[j], dp[j-customer] + cost);
				//홍보하지 않는 경우(dp[j])와, 이전에 홍보 후 여기서 다시 홍보하는 경우(dp[j-customer] + cost)
				//비교하여, 최소로 넣어주기
			}
		}
		int minCost = (C + 100) * 100;
		for(int i = C; i < C + 101; i++) {
			minCost = Math.min(minCost, dp[i]);
		}
		
		System.out.println(minCost);
		
		
	
		

	}
	

}


