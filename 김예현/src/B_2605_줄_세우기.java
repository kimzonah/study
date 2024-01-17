import java.util.Scanner;

public class B_2605_줄_세우기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int num = sc.nextInt();	// 학생 수
		int[] line = new int[num];	// 줄 서는 배열
		int pickup = 0;
		
		for (int i = 1; i <= num; i++) {
			pickup = sc.nextInt();	// 투표 용지 입력받기
			for (int j = num - 1; j > pickup; j--) {	// 끝부분에 끝부분 - 1 의 값을 복사
				line[j] = line[j - 1];
			}
			line[pickup] = i;	// 투표한 부분에 학생 투입
			
//			// 잘 진행되는지 확인
//			for(int j = 0; j < num; j++) {
//				System.out.print(line[j] + " ");
//			}
//			System.out.println();
		}
		
		for (int i = num - 1; i >= 0; i--) {	// 역순 출력
			System.out.print(line[i] + " ");
		}
	}
}
