import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 변수 받는데만 20줄 ㅠ
		StringTokenizer st = new StringTokenizer(br.readLine());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(br.readLine());
		// 입력받는 값을 받는 배열, 근데 어차피 동근이도 같은 형식으로 받을 거니까 N+1로 받고
		// 마지막 값을 비교해줍니다
		int[][] arr = new int[N + 1][2];
		int[][] map = new int[N + 1][2];
		// 거리 별 합계
		int sum = 0;
		for (int i = 0; i < N + 1; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 2; j++) {
				// 2차원 배열로 우선 값을 다 받아줍니다
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
			// 받은 값마다 규칙 정하기 귀찮아서 그냥 x,y 좌표로 수정해줍니다.
			// 1번 방향이 x, 4번 방향을 y로 잡으면 4방향에 대한 사각형 좌표로 수정할 수 있습니다
			if (arr[i][0] == 1) {
				map[i][1] = 0;
				map[i][0] = arr[i][1];
			} else if (arr[i][0] == 2) {
				map[i][1] = y;
				map[i][0] = arr[i][1];
			} else if (arr[i][0] == 3) {
				map[i][0] = 0;
				map[i][1] = arr[i][1];
			} else if (arr[i][0] == 4) {
				map[i][0] = x;
				map[i][1] = arr[i][1];
			}
		}
		for (int i = 0; i < N; i++) {
			int distance = 0;
			//방향 별로 상대 위치를 잡아줍니다
			if (Math.abs(map[N][0] - map[i][0]) == x) {
				// 가게랑 동근이는 모서리에 있을 수 없음을 활용해서
				// 먼저 동근이의 위치와 반대되는 지점의 거리를 먼저 구해줍니다
				// (0,0)과 (x,y)를 기준으로 가까운 지점을 찾아줘서 맞는 거리를 구해주면 됩니다
				distance = (map[N][1] + map[i][1] < y) ? (x + map[N][1] + map[i][1]) : (x + 2*y - map[N][1] - map[i][1]);
				// 조건은 (a+b) ? (2y -a -b)를 정리한거에요
			} else if (Math.abs(map[N][1] - map[i][1]) == y) {
				// 위에거는 동근이가 3,4번 위치에 있을 때고 여기는 1,2번 위치에 있을 때
				distance = (map[N][0] + map[i][0] < x) ? (y + map[N][0] + map[i][0]) : (y + 2*x - map[N][0] - map[i][0]);
			} else if (map[N][0] == map[i][0]) {
				// 동근이가 3,4번 위치에 있을 때 같은 방향에 있으면 그냥 차이값이 거리입니다.
				distance = Math.abs(map[N][1] - map[i][1]);
			} else if (map[N][1] == map[i][1]) {
				// 1,2번 ㅇㅇ
				distance = Math.abs(map[N][0] - map[i][0]);
			} else {
				// 마지막으로 수직 위치에 있을 때의 경우인데
				// x,y좌표로 수정하면 그냥 x값과 y값을 서로 빼준 값이 거리입니다
				distance = Math.abs(map[N][0] - map[i][0]) + Math.abs(map[N][1] - map[i][1]);
			}
			//System.out.println(distance);
			//쯕쯕 더해주면 총 거리 나와요~
			sum += distance;
		}
		System.out.println(sum);
	}
}
