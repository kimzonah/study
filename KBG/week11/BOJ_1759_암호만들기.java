import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_1759_암호만들기 {

	static int L, C;
	static char[] ans;
	static char[] word; // 단어 담을거
	static boolean[] check; // 방문 체크
	static List<String> arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		L = Integer.parseInt(st.nextToken()); // 암호 길이
		C = Integer.parseInt(st.nextToken()); // 단어 갯수

		word = new char[C];
		check = new boolean[C];
		ans = new char[L];
		arr = new ArrayList<>();
		StringBuilder sb = new StringBuilder();

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < C; i++) {
			word[i] = st.nextToken().charAt(0); // 단어 담기
		}
		Arrays.sort(word);

		combi(0, 0);

	}

	public static void combi(int c, int idx) { //c는 시작 단어, idx는 배열 갯수
		if (idx == L) {
			if(checkAEIOU()) {
				System.out.println(ans);
			}
			return;
		}

		for (int i = c; i < C; i++) {
				ans[idx] = word[i]; // 문장에 추가해주고
				combi(i + 1, idx + 1);
		}
	}

	public static boolean checkAEIOU() {
		int ja = 0;
		int mo = 0;
		
		for(char k : ans) {
			if(k == 'a' || k == 'e' || k == 'i' || k == 'o' || k == 'u') {
				mo++;
			}
			else {
				ja++;
			}
		}
		
		if(mo >= 1 && ja >= 2) {
			return true;
		}
		else {
			return false;
		}

	}

}
