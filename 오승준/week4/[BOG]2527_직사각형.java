import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] arr = new int[8];
		// (1)x y p q (2) x y p q
		// 4번만 받는다니까 T는 4까지만~
		for (int T = 0; T < 4; T++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			// 값 넣어줍니다
			for (int i = 0; i < 8; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			// 밑에 함수에서 값나오는대로 쇽쇽~
			System.out.println(checkIn(arr));
		}
	}

	public static char checkIn(int[] arr) {
		// 1번째와 2번째 사각형의 모서리 부분의 값의 차이로 계산합니다.
		// 똑같은 위치의 꼭지점 값의 차이를 변수로 둘게용
		int x = arr[4] - arr[2];
		int y = arr[5] - arr[3];
		int p = arr[6] - arr[0];
		int q = arr[7] - arr[1];
		
		// 이제 각 사각형의 꼭지점의 차이를 보는데, 사각형1의 x,y 시작좌표와
		// 사각형 2의 끝좌표의 차이가 양의 값을 가지면 절대 만나지 않습니다.
		if (x>0||p<0 || y > 0||q<0) {
			// 그래서 요놈들을 먼저 d로 쳐내고
			return 'd';
		} else if (x==0||p==0) {
			// 가로 세로 중 하나만 값이 일치하면 선, 둘다 일치하면 점으로 만나요
			if (y == 0||q==0) {
				// 둘다 0이 하나라도 있으면 c
				return 'c';
			} else {
				// 하나만 0이 있으면 선이니까 b
				return 'b';
			}
		} else if (y == 0||q==0) {
			// 가로축은 내부에 있는데 세로 축이 0이면 선으로 만나니 b
			return 'b';
			// 나머지는 결국 사각형이 안쪽에서 겹치고 있으므로 a입니다
		} else {
			return 'a';
		}
	}

}
