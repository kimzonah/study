import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;


class Main {
	static int D, P;
	static int[] L, C;
	static int[] ans;

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

	public static void main(String[] args) throws NumberFormatException, IOException {
		st = new StringTokenizer(br.readLine());
		D = Integer.parseInt(st.nextToken());
		P = Integer.parseInt(st.nextToken());
		
		L = new int[P];
		C = new int[P];
		// DP로 각 길이에서의 최댓값을 저장
		ans = new int[D+1];
		
		
		for(int i=0;i<P;i++) {
			st = new StringTokenizer(br.readLine());
			// 길이
			L[i] = Integer.parseInt(st.nextToken());
			// 용량
			C[i] = Integer.parseInt(st.nextToken());
		}
		
		// 저장하는 값은 파이프 중 가장 작은 값의 최댓값
		// 먼저 파이프의 값 중 최솟값을 찾아야 하므로 ans[0]을 max값으로 설정
		ans[0]= Integer.MAX_VALUE;
		for(int i=0;i<P;i++) {
			// 파이프의 길이 L이 주어졌을 때, 해당 파이프가 영향을 줄 수 있는 경우는
			// 필요 길이 D에서 해당 길이를 뺀 값임(길이가 늘어나니까~~)
			// 근데 값을 L[i]에서 부터 바꾸면 j가 증가하면서 그 바뀐 값에 다시 영향을 받음
			// 그래서 D부터 내려가면서 L[i]까지 변화를 확인
			for(int j=D;j>=L[i];j--) {
				// 일단 들어갈 수 있는 값은 현재 파이프의 용량값과 현재 전체 파이프 중 최소값 중 작은값
				// 그 값 중 최대 값이 들어가야 하므로
				// 먼저 C[i]와 ans[j-L[i]](현재 파이프가 들어가기 전의 최솟값 중 최댓값(...))비교
				// 그리고 현재의 파이프 길이까지 더해진 j값에서 최댓값을 구한다
				
				// ## 맨 처음에는 DFS로 풀려고 했다가 시간 초과
				//    -> 파이프가 350개까지인데 그럼 시간이 최대 2^350까지 간다
				// ## 그 다음에는 dp가 진행되는 파이프의 길이만을 추출하기 위해 리스트를 만들었는데
				// ## 치즈 문제도 그렇고 꺼내고 다시 넣는 과정이 더 많은 시간을 소요하는 듯
				// ## 최대한 뭘 꺼내거나 넣는걸 줄여야 할것 같다
				if(ans[j]<Math.min(C[i], ans[j-L[i]])) {
					ans[j]=Math.min(C[i], ans[j-L[i]]);
				}
			}
		}
		// 전부 끝난 후 D값을 구하면 됨
		bw.write(ans[D]+"");
		bw.flush();
		bw.close();
	}
}