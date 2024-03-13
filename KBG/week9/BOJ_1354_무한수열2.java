import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ_1354_무한수열2 {
	static int P, Q, X, Y;
	static HashMap<Long, Long> map;
	static long N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		map = new HashMap<>();
		N = Long.parseLong(st.nextToken()); //N은 1조까지이므로 롱임~ 
		P = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		Y = Integer.parseInt(st.nextToken());
		
		System.out.println(func(N));
	
	}
	
	public static long func(long n) {
		if(n <= 0) {
			return 1;
		}
		if(map.containsKey(n)) {
			return map.get(n);
		}
		long a = (long)Math.floor(n / P) - (long)X;
		long b = (long)Math.floor(n / Q) - (long)Y;
		map.put(n, func(a) + func(b));
		return map.get(n);
	}

}
