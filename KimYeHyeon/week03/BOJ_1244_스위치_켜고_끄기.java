package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_1244_스위치_켜고_끄기 {
	// 스위치의 상태 입력 받을 List 생성(switchState 줄여서)
	public static List<Integer> sws = new ArrayList<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 스위치의 개수 입력받기(없어도 될 것 같지만 맨 처음 입력을 처리하기 위함)
		int countOfSwitch = Integer.parseInt(br.readLine());

		// 스위치 상태 입력받기
		StringTokenizer st = new StringTokenizer(br.readLine());

		// 스위치 상태 입력하기
		while (st.hasMoreTokens())
			sws.add(Integer.parseInt(st.nextToken()));
		
		// 스위치의 index는 1부터 시작하므로 맨 앞에 sws 값 -1 추가해준다
			sws.add(0, -1);
			
		// 학생수 입력받기
		int studentNum = Integer.parseInt(br.readLine());

		// 성별과 받은 수 입력받기
		for (int n = 0; n < studentNum; n++) {
			st = new StringTokenizer(br.readLine());
			
			// 4번째 줄의 첫 숫자를 입력받아서 성별을 파악
			String gender = st.nextToken();
			
			// 4번째 줄의 두 번째 숫자를 입력받기
			int num =  Integer.parseInt(st.nextToken());
			
			switch (gender) {
			case "1":
				MaleCase(num); // 남학생의 경우를 실행
				break;
			case "2":
				FemaleCase(num); // 여학생의 경우를 실행
				break;
			}
		}

		// 반영이 완료된 스위치 상태 출력(1부터)
		for (int i = 1; i < sws.size(); i++) {
			System.out.print(sws.get(i) + " ");
			
			// 스위치 20개마다 개행
			if (i % 20 == 0)
				System.out.println();
		}
		sws.clear();
	}

	// 남학생의 경우
	public static void MaleCase(int num) {
		for (int i = 0; i < sws.size(); i++) {
			if (i % num == 0) { // 스위치 번호의 배수가 i라면
				if (sws.get(i) == 0) { // 불이 꺼져있다면
					sws.set(i, 1); // 불을 켠다
				} else if (sws.get(i) == 1) {
					sws.set(i, 0); // 그렇지 않으면 불을 끈다.
				}
			}
		}
	}

	// 여학생의 경우
	public static void FemaleCase(int num) {
		// 스위치 번호의 양 옆이 같다면
		// sws의 범위 내에서
		for (int i = 0; (num + i < sws.size()) && (num - i > 0); i++) {
			// 대칭이 맞지 않으면 종료한다.
			if (sws.get(num - i) != sws.get(num + i)) {
				return;
			}
			
			// 대칭이므로 하나만 검사해서 바꿔준다.
			if (sws.get(num - i) == 0) { // 꺼져있으면
				sws.set(num - i, 1); // 둘다 켜고
				sws.set(num + i, 1);
			} else if (sws.get(num - i) == 1) {
				sws.set(num - i, 0); // 둘다 켜져 있는 경우엔 끈다.
				sws.set(num + i, 0);
			}
		}
	}
}
