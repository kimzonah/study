import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		// 변수 N 받고
		int N = Integer.parseInt(br.readLine());
		// 수열 넣을 arr 만들고
		int[] arr = new int[N];
		// 올라가는거 내려가는거 따로 구분할라고 변수를 두개 둡니당
		int ccnt=1;
		int dcnt=1;
		int max = Integer.MIN_VALUE;
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			// 배열에 값 넣구
			arr[i] = Integer.parseInt(st.nextToken());
		}
		//올라가는거 먼저 확인
		sp : for(int i=0;i<N-1;i++) {
			ccnt =1;
			// i번째 수부터 쭉 한번 돌면서 어디까지 큰지 세봅니다
			 for(int j=i+1;j<N;j++) {
				if(arr[j]>=arr[j-1]) {
					ccnt++;
				} else {
					// 전번 수보다 j번째 수가 작다면 max값이랑 비교해보고 반복문 탈출
					if(max<ccnt) {
						max = ccnt;
					}
					continue sp;
				}
			}
			 // 마지막값까지 수열에 맞는 경우 else를 벗어나니 반복문 마지막에도 함 넣고
			if(max<ccnt) {
				max = ccnt;
			}
		}
		// ??? 이거 넣어야 마지막 정답인데 왜 넣지 -> N = 1인 경우인듯...
		if(max<ccnt) {
			max = ccnt;
		}
		
		sp2 : for(int i=0;i<N-1;i++) {
			dcnt = 1;
			// 내림차순도 세봅시다
			 for(int j=i+1;j<N;j++) {
				if(arr[j]<=arr[j-1]) {
					dcnt++;
				} else {
					// 전번 수보다 j번째 수가 크다면 max값이랑 비교해보고 반복문 탈출
					if(max<dcnt) {
						max = dcnt;
					}
					continue sp2;
				}
			}
			if(max<dcnt) {
				max = dcnt;
			}
		}
		if(max<dcnt) {
			max = dcnt;
		}
		
		bw.write(max + "");
		bw.flush();
		bw.close();
	}
}
