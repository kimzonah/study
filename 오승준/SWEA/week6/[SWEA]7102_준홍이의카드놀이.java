import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		//7102. 준홍이의 카드놀이
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		// TC 입력, N, M 변수 선언
		// Queue 선언
		// M+N의 빈도수를 알기 위한 arr선언
		int TC = Integer.parseInt(br.readLine());
		int N;
		int M;
		int[] arr;
		Queue<Integer> queue = new LinkedList<>();
		int max = Integer.MIN_VALUE;
		// TC 만큼 반복
		for(int i=1;i<=TC;i++) {
			// M,N 입력
			// arr 생성, 길이는 M+N+1
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			arr = new int[M+N+1];
			max =0;
			System.out.print("#"+i+" ");
			// 2중 for 문으로 N+M을 더해주고 그 값을 arr에 넣어줌
			for(int j=1;j<=N;j++) {
				for(int k=1;k<=M;k++) {
					arr[k+j]++;
					if(arr[k+j]>max) {
						max=arr[k+j];
					}
				}
			}
			//arr배열의 최대값을 구하고, 그 값을 가지는 인덱스를 출력
			for(int j=1;j<=M+N;j++) {
				if(arr[j]==max) {
					System.out.print(j+" " );
				}
			}
			System.out.println();
			
		}
	}
}
