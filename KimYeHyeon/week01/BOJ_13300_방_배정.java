import java.util.Scanner;

public class B_13300_방_배정 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt(); // 학생 수
		int K = sc.nextInt(); // 최대 인원 수
		int S = -1; // 성별
		int Y = 0; // 학년
		int roomNum = 0; // 출력 - 방 숫자
		int[] f_count = new int[7];	// 여학생 중복되는 학년 카운트
		int[] m_count = new int[7];	// 남학생 중복되는 학년 카운트

		for (int i = 0; i < N; i++) {
			S = sc.nextInt();
			Y = sc.nextInt();
			
			switch (S) {	// 성별에 따른 분기점
			case 0:	// 여학생
				for (int j = 1; j <= 6; j++) {
					if (Y == j) {	// 중복되는 학년 확인하여
						f_count[j]++;	// j 학년 카운트를 하나 올린다
					}
				}
				break;
			case 1:	// 남학생
				for (int j = 1; j <= 6; j++) {
					if (Y == j) {
						m_count[j]++;
					}
				}
				break;
			}
			
			for(int j = 1; j <= 6; j++) {
				if (f_count[j] == K) {	// 여학생의 방 수용수가 되었으면
					roomNum++;	// 방 개수를 늘리고
					f_count[j] = 0;	// j 학년 여학생수는 다시 세어라
				}
				if (m_count[j] == K) {	// 남학생의 방 수용수가 되었으면
					roomNum++;	// 방 개수를 늘리고
					m_count[j] = 0;	// j 학년 남학생수는 다시 세어라
				}
			}

			S = -1; // 성별 초기화
			Y = 0; // 학년 초기화
		}
		
		for (int i = 1; i <= 6; i++) {	// 남은 사람들 방 추가
			if(f_count[i] != 0) {
				roomNum++;
			}
			if(m_count[i] != 0) {
				roomNum++;
			}
		}

		System.out.println(roomNum);
	}
}
