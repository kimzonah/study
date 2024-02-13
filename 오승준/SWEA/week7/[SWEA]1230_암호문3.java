import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	// 계단 수 N 선언
	static int N;
	// 계단 점수 배열 선언, N+1로해서 보기 편하게
	static int[] stair;
	// 최댓값 max 생성
	static int max = Integer.MIN_VALUE;

	static BufferedReader br;
	static BufferedWriter bw;

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		// N 입력 후 stair 배열 생성
		N = Integer.parseInt(br.readLine());
		stair = new int[N + 1];
		// N개의 계단에 데이터 입력
		for (int i = 1; i <= N; i++) {
			stair[i] = Integer.parseInt(br.readLine());
		}
		// DSF 실행, 인자는 cnt 1이랑 1번(i값)
		DFS(0, 1, 1);
		// max값 출력
		bw.write(max+"");
		bw.flush();
		bw.close();
	}

	// DSF 함수 실행
	public static void DFS(int sum, int count, int number) {
        if(count ==3){
            return;
        }
		sum += stair[number];
		if (max < sum) {
			max = sum;
		}
		
		// i+1,i+2에 대한 반복 실행
		for (int i = number + 1; i <= number + 2 && i <= N; i++) {
			if (i != number + 1) {
				// j가 i+1 이면 count++;
				DFS(sum, 1, i);
				// DFS 재귀 실행
			} else {
				DFS(sum, ++count, i);
			}
		}
	}
}
