import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		boolean[][] arr1 = new boolean[101][101]; // 종이가 있는 부분은 true로 설정하기 위해 boolean 배열
		int cnt = 0;
		for (int i =0;i<N;i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			for(int j =x;j<x+10;j++) {	// x,y값 입력 받고 종이 넓이가 10이니까 넓이만큼 true 처리~
				for(int k=y;k<y+10;k++) {
					arr1[j][k] = true;
				}
			}
		}

		for(int i= 0;i<101;i++) {
			for(int j =0;j<101;j++) {
				if(arr1[i][j]==true) {  // arr한번 돌리면서 true 체크하고 카운팅하면 넓이 구해져요~
					cnt++;
				}
			}
		}
		System.out.println(cnt);
	}

}
