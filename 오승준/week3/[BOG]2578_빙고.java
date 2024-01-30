import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[][] arr = new int[5][5]; // 빙고판 설정
		StringTokenizer st;
		int a; // 사회자가 부르는 수 저장
		int cnt = 0; // 빙고 체크할 cnt 저장, 3되면 빙고에요!
		int xcnt = 5; // 가로세로대각선 빙고 확인용
		int ycnt = 5;
		int c1cnt = 5;
		int c2cnt = 5;
		int token = 0; // 사회자가 몇번째 숫자를 불렀는지를 물어보네 ;;;
		for (int i = 0; i < 5; i++) { // 빙고에 숫자 넣구요~
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		ht: for (int i = 0; i < 5; i++) {
			st = new StringTokenizer(br.readLine()); // 라인 받고
			for (int j = 0; j < 5; j++) {
				a = Integer.parseInt(st.nextToken());// 토큰 나누고
				token++;
				for (int k = 0; k < 5; k++) {
					for (int l = 0; l < 5; l++) { // 빙고 값이랑 비교해서 0으로 처리
						if (arr[k][l] == a) {
							arr[k][l] = 0;
						}
						// 이제 빙고를 x,y,대각선으로 체크합니다. 저는 이거 하나씩 했는데 더 깔끔한 방법 있음 알려주세요!
						for (int x = 0; x < 5; x++) {			// x좌표
							for (int y = 0; y < 5; y++) {
								if (arr[x][y] == 0) {
									xcnt--;
									if (xcnt == 0) {
										cnt++;
									}
								}
							}
							xcnt = 5;							// 한번씩 훑고 나면 초기화 필수입니덩
						}
						for (int x = 0; x < 5; x++) {			// y좌표
							for (int y = 0; y < 5; y++) {
								if (arr[y][x] == 0) {
									ycnt--;
									if (ycnt == 0) {
										cnt++;
									}
								}
							}
							ycnt = 5;
						}
						for (int x = 0; x < 5; x++) {			//대각선1
							if (arr[x][x] == 0) {
								c1cnt--;
								if (c1cnt == 0) {
									cnt++;
								}
							}
						}
						c1cnt =5;
						for (int x = 0; x < 5; x++) {			//대각선 2
							if (arr[x][4-x] == 0) {
								c2cnt--;
								if (c2cnt == 0) {
									cnt++;
								}
							}
						}
						c2cnt =5;

						if (cnt >= 3) { // cnt 3이상되면
							System.out.print(token); // 토큰 출력해주면 끝입니다~
							break ht;
						} else {
							cnt = 0;
						}
					}
				}
			}
		}
	}
}
