import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ_1351_무한수열 {
	static HashMap<Long, Long> dp;
	static long N;
	static int P, Q;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Long.parseLong(st.nextToken()); //N은 1조까지 가능..
		P = Integer.parseInt(st.nextToken()); //P,Q는 10억까지
		Q = Integer.parseInt(st.nextToken());
		dp = new HashMap<>(); //index와 value 값으로 한 쌍.(A0 , 1 ) 식으로..
		
		System.out.println(func(N));
			
	}
	
	public static long func(long n) {
		if(n == 0) {
			return 1; //A0 구하는거면 1이니까.
		}
		if(dp.containsKey(n)) { //만약, dp맵에 n이포함되어 있으면 바로 리턴
			return dp.get(n);
		}
		long a = (long)Math.floor(n / P); //입력받은 값에서 P로 나눈 몫
		long b = (long)Math.floor(n / Q); //입력받은 값에서 Q로 나눈 몫
		dp.put(n, func(a) + func(b)); //점차 내려가면서 값을 찾는 과정
		return dp.get(n);
	}
	
	

}
