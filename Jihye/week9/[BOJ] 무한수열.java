package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class 무한수열 {
	private static long N, P, Q;
	
	private static Map<Long, Long> map = new HashMap<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		map.put(0l, 1l);
		
		N = Long.parseLong(st.nextToken());
		P = Long.parseLong(st.nextToken());
		Q = Long.parseLong(st.nextToken());
		
		dp(N);
		
		System.out.println(map.get(N));
	}
	
	public static void dp(long i) {
		if (i == 0) {
			return;
		}
		
		
		// 모든 가지를 검사할 때 까지 dp 수행
		while(!map.containsKey(i)) {
			long a1 = i / P;
			long a2 = i / Q;
			
			if (map.containsKey(a1) && map.containsKey(a2)) {
				map.put(i, map.get(a1) + map.get(a2));
				return;
			}
			
			if (!map.containsKey(a1)) {
				dp(a1);
			}
			
			if (!map.containsKey(a2)) {
				dp(a2);
			}
		
		}
	}
}
