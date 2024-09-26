package im;

import java.util.Scanner;

public class Room_13300 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		int student [][] = new int[2][6];
		
		for(int i=0; i<N; i++) {
			int gender = sc.nextInt();
			int grade = sc.nextInt();
			
			student[gender][grade-1]+=1;
		}
		
		int room = 0;
		
		for(int i=0; i<2; i++) {
			for(int j=0; j<6; j++) {
				// 최대 수용안원으로 나눠준 몫을 더하고, 나머지가 있으면 1 추가
				room += (student[i][j])/K;
				if(student[i][j]%K != 0) {
					room += 1;
				}
			}
		}
		System.out.println(room);
		
	}
			
	}

// Math.ceil 올림함수를 써서 나머지 확인하는 절차를 줄일 수 있다,,!