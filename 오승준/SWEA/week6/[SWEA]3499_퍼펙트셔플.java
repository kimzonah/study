import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		// 퍼펙트 셔플
		// TC, N, 문자열의 배열 K 선언
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int TC = Integer.parseInt(br.readLine());
		int N;
		String[] arr;
		// 문자열의 절반 나눠 담을 queue 두개 선언
		Queue<String> af = new LinkedList<>();
		Queue<String> bf = new LinkedList<>();
		// TC 만큼 반복
		for(int i=1;i<=TC;i++) {
			// M,K 데이터 입력
			System.out.print("#"+i+" ");
			N = Integer.parseInt(br.readLine());
			arr = new String[N];
			st= new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				arr[j] = st.nextToken();
				// if로 N/2 전후 queue에 데이터 옮겨 담음
				if((N-1)/2<j) {
					bf.add(arr[j]);
				} else {
					af.add(arr[j]);
				}
			}
			// 반복문을 통해 queue에서 번갈아 poll 및 출력
			while(!bf.isEmpty()) {
				System.out.print(af.poll()+" "+bf.poll()+" ");
			}
			if(!af.isEmpty()) {
				System.out.print(af.poll());
			}
			System.out.println();
			
		}
	}
}
