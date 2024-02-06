import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 스위치 숫자 N 입력
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		// 스위치 초기 상태 확인을 위한 arr 배열
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		// 학생 수 num 입력
		int num = Integer.parseInt(br.readLine());
		// 학생 성별 및 스위치 위치 받는 std 변수
		int[][] std = new int[2][num];
		for (int i = 0; i < num; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 2; j++) {
				std[j][i] = Integer.parseInt(st.nextToken());
			}
			// 학생 성별 별로 스위치 변경 하도록 슉슉
			// 남자가 쉬우니까 남자부터, std[1][i] 값의 배수면 스위칭
			if (std[0][i] == 1) {
				for (int j = 0; j < N; j++) {
					// 배열은 0번부터 시작하니까 j+1로 계산하구용
					if ((j + 1) % std[1][i] == 0) {
						if (arr[j] == 1) {
							arr[j] = 0;
						} else {
							arr[j] = 1;
						}
					}
				}
			} else if (std[0][i] == 2) { // 여자는 까다로우니까 심호흡 함 하고
				if (arr[std[1][i] - 1] == 1) {
					arr[std[1][i] - 1] = 0;
				} else {
					arr[std[1][i] - 1] = 1;
				}
				int M = std[1][i]; // M,m 설정 후 한칸씩 옮겨가면서 대칭 상태 확인
				int m = std[1][i] - 2;
				while (M<N&&m>=0&&arr[M] == arr[m]) { // 인덱스가 N보다 크거나 m이 0보다 작은 상태에서
					if (arr[M] == 1) {// M과 m의 스위치가 똑같다면 스위칭
						arr[M] = 0;
						arr[m] = 0;
						M++;			// 다음 인덱스 확인을 위해 M,m 값 변견
						m--;
					} else {
						arr[M] = 1;
						arr[m] = 1;
						M++;
						m--;
					}

				}
			}
		}
		for (int j = 0; j < N; j++) {	// 출력하면 끝~
			System.out.print(arr[j] + " ");
            if((j+1)%20==0) {
				System.out.println();
			}
		}

	}
}
