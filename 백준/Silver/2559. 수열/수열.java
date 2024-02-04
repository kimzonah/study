import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int sumArr = 0;
		//K 번
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] sum = new int[N-K+1]; 
		
		for(int i = 0; i < sum.length; i++) {
			for(int j = i; j < i + K; j++) {
				sumArr += arr[j];
			}
			sum[i] = sumArr;
			sumArr = 0;
		}
		
		Arrays.sort(sum);
		
		System.out.println(sum[sum.length-1]);
	

	}

}
