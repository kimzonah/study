import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int sum = 0;
		int max = -100000000;
		//K 번
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		 
		for(int i = 0; i < N-K+1; i++) {
			for(int j = i; j < i + K; j++) {
				sum += arr[j];
			}
			if(max < sum) {
				max = sum;
			}
			sum = 0;
		}
		
		System.out.println(max);
		
		
	

	}

}
