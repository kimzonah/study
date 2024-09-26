
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int R, C, S, dis, dir;
	static StringTokenizer st;
	static BufferedReader br;
	static int[] arr;
	// 풀이법 : 사각형을 1직선으로 생각한다!
	// 좌상단 기준으로 세로는 북쪽부터 남쪽방향이고, 가로는 서쪽부터 북쪽방향이므로
	// 좌상단이 시초(0,0)이라고 볼 수 있다.

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken()); // 가로
		C = Integer.parseInt(st.nextToken()); // 세로
		S = Integer.parseInt(br.readLine()); // 상점 갯수
		arr = new int[S + 1];

		int minDistance = checkDistance();

		System.out.println(minDistance);

	}

	public static int checkDistance() throws IOException { // 최소 거리를 구하는 함수
		int count = 0;
		for (int i = 0; i < S + 1; i++) { // S == 동근이 위치랑 방향
			st = new StringTokenizer(br.readLine());
			dir = Integer.parseInt(st.nextToken());
			dis = Integer.parseInt(st.nextToken());
			int distance = 0;
			// 사각형 직선은 북 -> 동 -> 남 -> 서 순서임
			if (dir == 1) {// 북쪽인 경우
				distance = dis;
			} else if (dir == 2) { // 남쪽인 경우
				distance = R + C + (R - dis);//남쪽의 경우는 변의 오른쪽 부터 들어가니까 R-dis해줘야함.  
			} else if (dir == 3) { // 서쪽인 경우
				distance = R + C + R + (C - dis); // 이 경우, 북쪽부터 길이를 잰거니까
				// 서쪽의 경우 C - dis를 해주어야 본래의 distance가 나온다.
			} else { // 동쪽인 경우
				distance = R + dis;
			}

			arr[i] = distance; // 배열의 값에 각각의 거리 저장한다.
			// 이 때, arr[S] == 동근이의 거리이다.
		}

		for (int i = 0; i < S; i++) {
			int distance1 = Math.abs(arr[i] - arr[S]); // 이어진 부분
			int distance2 = (2 * R + 2 * C) - distance1; // 이어진 부분말고 그 끝점부터 돌아서 다시 끝점 까지의 거리
			count += Math.min(distance1, distance2); // 둘 중 최저 값을 대입해준다.
		}

		return count;
	}

}