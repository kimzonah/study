import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class BOJ_1038_감소하는수 {
	static int N;
	static ArrayList<Long> descent; // 감소하는 수 저장하는 곳

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		descent = new ArrayList<>();
		// 최대사이즈 == 1022, 최대 수 == 9876543210 => 열자리수
		for (int i = 0; i < 10; i++) { // 0부터 9 까지..
			des(i, 1);
		}
		Collections.sort(descent);

		if (N + 1> descent.size()) {
			System.out.println(-1);
		} else {
			System.out.println(descent.get(N));
		}
	}

	public static void des(long num, int idx) {// num은 1~9 숫자, idx는 자릿수
		if (idx > 10) {
			return;
		}

		descent.add(num);// num을 추가하고
		for (int i = 0; i < num % 10; i++) { // 자기보다 작은 숫자만 반복해서..
			des((num * 10) + i, idx + 1);
		}
	}

}
