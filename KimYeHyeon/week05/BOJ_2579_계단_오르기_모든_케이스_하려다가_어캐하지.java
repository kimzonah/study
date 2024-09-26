package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2579_계단_오르기_모든_케이스_하려다가_어캐하지 {
	public static int[] stairs;
	public static int N;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 계단 개수 입력받기
		N = Integer.parseInt(br.readLine());
		
		// 계단 배열 생성(계단 개수 + 1)
		stairs = new int[N + 1];
		
		// 맨 뒤에 0 추가하기
		stairs[N] = 0;
		
		// 계단 입력 받기
		for (int i = 0; i < N; i++) {
			stairs[i] = Integer.parseInt(br.readLine());
		}
		
		// 모든 경우의 수를 따져본다.
		// 한칸 오르기, 두칸 오르기 후 dps 사용해보자
		int sum1 = 0, sum2 = 0, sum = 0;
		sum1 += ggangchong(0, 0);
		sum2 += ggangchong(1, 0);
		sum = (sum1 > sum2) ? sum1 : sum2;
		
		System.out.println(sum);
	}
	
	public static int ggangchong(int idx, int isDouble) {
		int sum = 0, sum1 = 0, sum2 = 0;
		
		if(idx >= stairs.length)
			return 0;
		
		if (isDouble == 1) {
			sum1 += stairs[idx];
			sum1 += ggangchong(idx + 2, 0);
		} else {
			sum2 += stairs[idx];
			sum2 += ggangchong(idx + 1, 1);
		}
		
		sum += (sum1 > sum2) ? sum1 : sum2;
		
		return sum;
	}
}
