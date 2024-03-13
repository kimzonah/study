import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_11055_가장큰증가하는부분수열 {
	static int N, result;
	static int[] arr;//원래 값 저장하는 배열과 dp배열 생성

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		/* 1. dp를 사용하여 각 수열의 번호를 정한다.
		 * 2. 만약에 수열의 번호가 올라간다면, 그 값을 따로 저장한다.
		 * */
		N = Integer.parseInt(br.readLine()); //수열 크기
		arr = new int[N]; //N크기.
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		result = LIS(arr); //알아서 돌리고.
		
		System.out.println(result);
	}
	
	public static int LIS(int[] arr) { //최장 증가수열
		int[] sum = new int[N];
		int max = arr[0]; //증가하지 못하는 수열일 수도 있으므로 최대는 arr[0]
		sum[0] = arr[0]; //합 배열을 sum에 저장해주고.
		for(int i = 1; i < N; i++) {
			for(int j = 0; j < i; j++) {//이전값 까지 반복하는데
				if(arr[i] > arr[j]) {
					//만약, 이전값 보다 arr[i]가 더 크면.. 
					sum[i] = Math.max(sum[i], sum[j]);
				}
			}
			sum[i] += arr[i];
			max = Math.max(sum[i], max);
		}
		
		
		return max;
	}

}
