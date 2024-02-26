import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_17281_야구 {
	static int N;
	static int[] hitter; // 타자 순서 정하기 4번타자 == 1번
	static boolean[] check; // 타자 순서가 이미 배정됐는지 확인하는 배열
	static int[][] act; // N이닝에서 타자가 할 행동 저장
	static int score = 0; // 점수 저장용
	static int ans; // 최고 점수낼 수 있는 그 경우 값

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine()); // 이닝 수
		StringTokenizer st;
		act = new int[N + 1][10];
		hitter = new int[10]; // 배열 0은 안씀.
		check = new boolean[10];

		hitter[4] = 1; // 4번타자 == 1번
		check[4] = true; // 타순 정해졌으므로 체크

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= 9; j++) {
				act[i][j] = Integer.parseInt(st.nextToken()); // 해당 이닝에서
				// 타자의 행동 저장
			}
		}
		ans = 0;
		permutation(2); // 2번타자부터 순서 찾기
		System.out.println(ans);

	}

	// 순열을 통해, 타자순서를 구하도록 합시다..
	public static void permutation(int k) {
		if (k == 10) { // 9번까지 다 정하면 ? 게임 시작
			goGame();
			return;
		}

		for (int i = 1; i <= 9; i++) { // 1번부터 9번을 돌면서
			if (check[i]) {
				continue; // 이미 타순이 정해졌으면 넘어가고
			}
			// 아니라면?
			check[i] = true; // 해당 타자는 방문한거니 트루로 바꿔주고
			hitter[i] = k; // 그 해당 자리에 타자 번호를 넣어줌
			permutation(k + 1); // 다음 타자 순회
			check[i] = false; // 순회 끝나면 false해줘야 다른 순열이 진행될 때 방문이 가능
		}
	}

	public static void goGame() {
		score = 0; // 점수 저장용
		int start = 1; // 시작 타자 == 1번
		boolean[] base;// 1루~ 3루까지 0번 == 타자
		
		/*득점의 조건은 안타일 때 해당 득점 가능 베이스에 타자가 무조건 있어야함
		 * 그러므로 항상 if(base[k]) 조건을 걸어주자!!!*/

		for (int i = 1; i <= N; i++) { // 이닝만큼 반복
			int out = 0;
			base = new boolean[4]; // 이닝시작될 때 마다 베이스 초기화
			inning: while (true) { // 해당 이닝의 아웃카운트가 3이 되기 전까지 진행해야함
				for (int j = start; j <= 9; j++) { // 시작부터.. 9번타자까지
					int hitMan = act[i][hitter[j]]; // 해당이닝에서 타자가 할 행동
					switch (hitMan) {
					case 0:
						out++;
						break;
					case 1:
						for (int k = 3; k >= 1; k--) {// 3루부터 내려와서 확인
							if (base[k]) { // 해당 루에 사람이 있을 때
								if (k == 3) { // 그게 3루라면
									score++; // 1점추가
									base[k] = false;
								} else {
									// 1, 2루도 한루씩 올라감
									base[k] = false;
									base[k + 1] = true;
								}
							}
						}
						base[1] = true; // 1루에도 사람추가
						break;
					case 2: // 2루타의 경우
						for (int k = 3; k >= 1; k--) {// 똑같이
							if (base[k]) { //베이스에 사람이 있을 때
								if (k == 3 || k == 2) {
									score++;
									base[k] = false;
								} else { // 1루인 경우 3루로 진루
									base[k] = false;
									base[k + 2] = true;
								}
							}
						}
						base[2] = true;
						break;
					case 3: // 3루타의 경우
						for (int k = 3; k >= 1; k--) {
							if (base[k]) {
								score++;
								base[k] = false;
							}
						}
						base[3] = true;
						break;
					case 4: // 홈런의 경우 그냥 다 점수
						for (int k = 3; k >= 1; k--) {
							if (base[k]) { // 베이스에 사람이 있다면
								score++; // 이번엔 타자까지
								base[k] = false;
							}
						}
						score++;
						break;
					}

					if (out == 3) { // 아웃이 3개 쌓인 경우
						start = j + 1; // 해당 아웃 타자 다음부터 스타트
						if (start == 10) { // 9번이 돌았다면?
							start = 1; // 다시 1번타자로 돌아감
						}
						// 다음이닝으로 가야하므로 while문 탈출해야함
						break inning;
					}
				}
				// 이때, 9번까지 갔는데도 out이 3이 아니면
				// 스타트를 다시 1로 초기화해줘서 재수행할 수 있게 해줌
				/* 시간 초과의 주범 ****************/
				start = 1;
			}
		}

		ans = Math.max(ans, score);

	}

}
