import java.util.Scanner;

public class B_2669_직사각형_네개의_합집합의_면적_구하기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int[][] plain = new int[101][101]; // 평면 100 이하
		int start_x = 0;
		int start_y = 0;
		int end_x = 0;
		int end_y = 0;

		for (int i = 0; i < 4; i++) {
			start_x = sc.nextInt();
			start_y = sc.nextInt();
			end_x = sc.nextInt();
			end_y = sc.nextInt();

			for (int x = start_x; x < end_x; x++) {
				for (int y = start_y; y < end_y; y++) {
					plain[x][y] = 1; // 만들어진 사각형의 영역을 1로 바꿔준다
				}
			}
		}

		int area = 0;
		for (int x = 1; x < 101; x++) {
			for (int y = 1; y < 101; y++) {
				if (plain[x][y] == 1) {
					area++;
				}
			}
		}

		System.out.println(area);
	}
}
