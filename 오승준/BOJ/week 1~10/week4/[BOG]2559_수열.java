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
		StringTokenizer st = new StringTokenizer(br.readLine());
		// 변수 받고
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		// 수열도 arr로 만들어서 받아줍니다
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		// 연속값을 받으니 K길이 만큼의 첫번째 수열 합을 구하고, 맨앞이랑 맨뒤만 빼주고 더함 될듯합니다
		int sum =0 ;
		int max = Integer.MIN_VALUE;
		// K번까지는 수열을 그냥 더해주다가 K번부터는 맨 앞에 수부터 지워주심 됩니당
		for(int i =0;i<N;i++) {
			sum += arr[i];
			// 최대값 구하는게 K부터면 k-1일때가 안구해져서 하나 추가요 ㅎㅎ...
			if(i==K-1) {
				if(max<sum) {
					max =sum;
				}
			}
			if (i>=K) {
				sum -= arr[i-K];
				System.out.println(sum);
				//그러다가 최대값나오면 바꿔주세용		
				if(max<sum) {
					max =sum;
				}
			}
		}
		//출료료룍
		bw.write(max+"");
		bw.flush();
		bw.close();
	}
}
