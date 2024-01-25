import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();		// 종이 x 좌표
		int y = sc.nextInt();		// 종이 y 좌표	
		int[][] arr = new int[x+1][y+1];  // 1부터 시작하고 싶어서 +1 했습니당
		int N = sc.nextInt();		// 자르는 숫자 받고~
		int[] xcut = new int[x+1]; int[] ycut = new int[y+1];		// x, y 선 상에 어디 위치에서 자르는지 표기
		int xcnt = 0; int ycnt = 0;				// 자른 만큼 반복문 써야되서 cnt 변수~
		int xpoint =0; int ypoint = 0;				// 자른 지점 확인할라고 point 변수 ~.~

		
		for(int i=1;i<=N;i++) {
			int a = sc.nextInt();
			if (a == 0) {
				int b = sc.nextInt();			// 처음 입력 받는 값에 따라 x, y 자를 지 판단
				ycut[b]++;
				ycnt++;
			} else if (a == 1) {
				int b = sc.nextInt();
				xcut[b]++;
				xcnt++;
			}
		}
		int max = Integer.MIN_VALUE;				// 최대 크기 구합시다
		
		for(int x1=1;x1<x+1;x1++) {
			if(xcut[x1]==0 && x1 != x) {			// x,y 자른 지점에서 넓이 계산 + x1 변수의 마지막에서도 넓이 재게 x1 !=x 넣었구요 ㅎ
				continue;
			} else if(xcut[x1] > 0 || x1 == x){
				int q = x1 - xpoint;			// x1이 1인 지점에서 마지막 체크포인트까지 길이를 구해줍니다
				
				for(int y1=1;y1<y+1;y1++) {
					if(ycut[y1]==0 && y1 !=y) {	// x에서 한거 y도 해주고
						continue;
					} else if (ycut[y1]>0 || y1 ==y) {
						int p = y1-ypoint;   
						if (max<(p*q)) {	// x,y길이인 p,q 곱해주고 max값인지 확인 ~.~
							max = (p*q);
							//System.out.println(p +" "+q);
						}
						ypoint = y1;            // 길이를 구했으면 다음 자르는 지점까지 체크포인트 저장합니다
					}
				}
			
			}
			xpoint = x1;	// x도 체크 포인트 저장!
			ypoint = 0;	// y는 x 저장하면 처음부터 다시 돌려야되서 초기화!

		}
		System.out.print(max);
	}
}
