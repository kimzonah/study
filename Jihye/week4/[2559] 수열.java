package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 수열2559 {
	public static void main(String[] args) throws IOException{
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 StringTokenizer st = new StringTokenizer(br.readLine());
		 
		 int N = Integer.parseInt(st.nextToken());
		 int K = Integer.parseInt(st.nextToken());
		 
         // int 배열 만들기
		 int[] arr = new int[N];
		 st = new StringTokenizer(br.readLine());

		 arr[0] = Integer.parseInt(st.nextToken());
		 
         // 누적합 구하기
		 for (int i = 1; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken()) + arr[i-1];
		 }

         // 첫번째 K개의 합을 max로 담기
		 int max = arr[K-1];

		 int sum;
		 
         // 인덱스 K부터 시작해서, k개 이전의 값들을 빼주기
		 for (int i = K; i < arr.length; i++) {
			sum = arr[i] - arr[i - K];
            // 최댓값보다 더 크다면, max 값 갱신해주기
            if (max < sum) max = sum; 
		 }
		 
		 System.out.println(max);
		 
	}
}