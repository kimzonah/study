import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_10504_덧셈 {
	static final int max_Num = 44720;
	static final int[] arrayNum = new int[max_Num + 1];
	//덧셈이 가능한 최대 영역 44720
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int i = 1; i <= max_Num; i++) {
			arrayNum[i] = arrayNum[i-1] + i;
		}
		//반복문 반복반복..
		for(int tc = 1; tc <= T; tc++) {
			int n = Integer.parseInt(br.readLine()); //입력 받을 수
			int ans = getLength(n);
			//ans 에는 i 가 저장되어있다
			if(ans == -1) {
				sb.append("IMPOSSIBLE").append("\n");
				continue;
			}
			sb.append(n + " = ");
			int value = (n - arrayNum[ans]) / ans; // 몫찾기 (여기를 1 2 3 ...이랑 더해줌)
			
			for(int i = 1 ; i < ans; i++) {
				sb.append((value + i) + " + "); //각 value에 i씩 더한 값을 계속 넣어줘
			}
			sb.append(value + ans).append("\n"); // 마지막엔 +가 붙으면 안되니까 밖으로 빼고
			
		}
		System.out.println(sb);

	}
	public static int getLength(int n) {
		for(int i = 2; i <= max_Num; i++) {
			int num = n - arrayNum[i]; //해당 합을 뺀 값을 함 보자
			if(num < 0) return -1; //만약에 음수가 나온다면 합을 구할 수 없다는 것
			if(num % i == 0) return i; //만약에 나누어 떨어진다면, i개의 합으로 이루어진다는 거임!
		}
		return -1; //양수가 나와버린다면... 합을 못구하는거임
	}

}
