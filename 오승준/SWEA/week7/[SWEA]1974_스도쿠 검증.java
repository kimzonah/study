import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {
	// 변수 T 선언
	static int T;
	// 스도쿠 2차 배열 arr 선언
	static int[][] arr;
	// 스도쿠 내의 가로, 세로 중복 체크를 위한 1차 배열 선언
	static int[] xarr;
	static int[] yarr;
	// 사각형 내의 3*3 값을 계산하기 위한 sum
	static int sum;
	// 변수 result 선언
	static int res;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// br bw 생성, st 선언
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		// T 입력
		T = Integer.parseInt(br.readLine());
		// T 만큼 반복
		for (int TC = 1; TC <= T; TC++) {
			bw.write("#"+TC+" ");
			//배열 초기화
			arr = new int[9][9];
			res = 1;
			
			// 9번 2번 반복하는 2중 for문 선언
			for(int i=0;i<9;i++) {
				xarr = new int[10];
				// i행 st 생성 후 j열에 값 입력
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<9;j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
					// j열에서 가로 중복을 체크
					xarr[arr[i][j]]++;
					if(xarr[arr[i][j]] >= 2) {
						res = 0;
						continue;
					}
				}
			}
			// 2차 반복 하나 더
			// -> xarr 찾을 때 같이 하고 싶었는데 일단 분리...
			for(int i=0;i<9;i++) {
				yarr = new int[10];
				// 세로에서 중복 검증
				for(int j=0;j<9;j++) {
					yarr[arr[j][i]]++;
					if(yarr[arr[j][i]] >= 2) {
						res = 0;
						continue;
					}
				}
			}
			// 2차 반복 하나 더 -> 4차 반복해야될듯...
			for(int i=0;i<3;i++) {
				for(int j=0;j<3;j++) {
					// 가로 3칸, 세로 3칸을 더해준 값이 45면 중복이 없음
					sum = 0;
					for(int k=0;k<3;k++) {
						for(int l=0;l<3;l++) {
							// i/3,j/3 항목을 추가해서 9개 지역에 대한 각 사각형의 지역 값을 비교
							// i,j에 3을 곱하면서 각 지역의 k,j를 활용한 사각형 값을 구해준다
							sum += arr[(3*i)+k][(3*j)+l];
						}
					}
					// 1~9까지의 합이 나오지 않으면 0
					if(sum!=45) {
						res = 0;
						continue;
					}
				}
			}
            // 이상 있으면 0, 없으면 1 출력
			bw.write(res+""+"\n");
					
		}
		bw.flush();
		bw.close();
		

	}
}
