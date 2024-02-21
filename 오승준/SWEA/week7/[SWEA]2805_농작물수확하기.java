import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {
	// TC,N 선언
	static int TC;
	static int N;
	static String a;
	// 농작물 가치 저장 2차 배열 arr 선언
	static int[][] arr;
	// 농작물의 가치를 포함하는 변수 sum 선언
	static int sum;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// br, bw, 생성, st 선언
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw  = new BufferedWriter(new OutputStreamWriter(System.out));
		// TC 만큼 반복
		TC = Integer.parseInt(br.readLine());
		for(int T=1;T<=TC;T++) {
			// N 입력
			N = Integer.parseInt(br.readLine());
			// arr 생성
			arr = new int[N][N];
			sum = 0;
			// N 만큼 2중 반복문으로 가치 입력 및 총 가치 합산
			for(int i=0;i<N;i++) {
				a = br.readLine();
				for(int j=0;j<N;j++) {
					arr[i][j] = a.charAt(j)-'0';
					sum += arr[i][j];
				}
			}
			// 마름포의 가치는 총 사각형에서 꼭지점 4개의 가치를 뺀 값이다
			// 2중 반복문으로 0에서 N/2까지 i,j 진행
			for(int i=0;i<N/2;i++) {
				// j는 N/2-i만큼 이동
				for(int j=0;j<N/2-i;j++) {
					// [0][0],[0][N-1]에서 j방향으로 i 만큼 이동하며 총 가치에서 사각형의 가치를 뺀다
					sum -= arr[i][j]+arr[i][N-1-j];
					// [N-1][0],[N-1][N-1]에서는 N에서 N/2-1에서 N/2-1-i만큼 이동하며 가치를 뺀다
					sum -= arr[N-1-i][j]+arr[N-1-i][N-1-j];
				}
			}
			// 남은 sum 출력
			bw.write("#"+T+" "+sum+"\n");
		}
		bw.flush();
		bw.close();
	}
}
