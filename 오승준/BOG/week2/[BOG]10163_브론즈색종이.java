import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] arr1 = new int[1001][1001]; //좌표 1001까지 생성
		int[][] arr2 = new int[N][4];		//N개로 주어지는 사각형의 정보 보관
		int[] square = new int[1001];		//넓이 보관 (개수 몰라서 1001개 넣음)
		
		
		for (int r =0;r<N;r++) {
			for(int c=0;c<4;c++) {			
				arr2[r][c] = sc.nextInt();	// 사각형 좌표랑 크기 받고~~
			}
			for(int i=arr2[r][0];i<arr2[r][0]+arr2[r][2];i++) {	//좌표 시작점부터 높이/너비 크기를 구하는 2중 배열
				for(int j=arr2[r][1];j<arr2[r][1]+arr2[r][3];j++) {
					arr1[i][j]=r+1;								// 입력되는 순서대로 숫자 기입-> 이러면 나중 숫자가 덮어요
				}
			}
		}
		for(int i =0 ; i<1001;i++) {
			for(int j =0; j<1001;j++) {		// arr1 좌표 훑으면서 N까지의 숫자들 전부 카운트
				for(int d=1;d<=N;d++) {
					if(arr1[i][j]==d)		// 1번째 사각형은 1, 2번째사각형은 2 이런식으로 숫자들 카운팅하면 되죵
						square[d]++;		
				}
			}
		}
		for(int i= 1;i<=N;i++) {	
			System.out.println(square[i]);	//마지막은 프린트로
		}
	}

}
