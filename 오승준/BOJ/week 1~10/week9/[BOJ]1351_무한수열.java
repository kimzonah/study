import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

class Main {
	// N의 크기가 21억을 넘어가서 long으로 받아줍니다
	static long N, P, Q;

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	// 마찬가지로 N의 크기가 21억을 넘어가서 index를 int형으로 가지는 배열을 못써서 ㅠ
	// Hashmap으로 구해지는 과정의 값만 저장합니다
	static HashMap<Long,Long> A = new HashMap<Long,Long>();

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Long.parseLong(st.nextToken());
		P = Long.parseLong(st.nextToken());
		Q = Long.parseLong(st.nextToken());
		
		A.put(0l, 1l);
		// N이 0일 경우 An = 1이나 밑의 과정을 거치면 An = A0+A0이 되서 2가 되므로 예외를 둡시다
		if(N!=0) {
			func1(N);
		}
		
		bw.write(A.get(N) + "");
		bw.flush();
		bw.close();
	}

	private static void func1(long idx) {
		
		// An을 구성하는 Ai/p와 A/iq를 구합니당
		// memoization하는 hashmap에서 위 두 값이 없다면 재귀 실행
		// i/p를 완료하면 i/q도 똑같이 실행
		if(A.get(idx/P)==null)	func1(idx/P);
		if(A.get(idx/Q)==null) func1(idx/Q);

		// 위의 값이 전부 실행되고 나면 Aidx를 구할 수 있게됩니다
		if(A.get(idx/P)!=null&&A.get(idx/Q)!=null) {
			A.put(idx, A.get(idx/P)+A.get(idx/Q));
			return;
		}
		
	}
}