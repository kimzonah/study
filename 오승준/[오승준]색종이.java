import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] arr1 = new int[1001][1001];
		int[][] arr2 = new int[N][4];
		int[] square = new int[1001];
		
		
		for (int r =0;r<N;r++) {
			for(int c=0;c<4;c++) {
				arr2[r][c] = sc.nextInt();
			}
			for(int i=arr2[r][0];i<arr2[r][0]+arr2[r][2];i++) {
				for(int j=arr2[r][1];j<arr2[r][1]+arr2[r][3];j++) {
					arr1[i][j]=r+1;
				}
			}
		}
		for(int i =0 ; i<1001;i++) {
			for(int j =0; j<1001;j++) {
				for(int d=1;d<=N;d++) {
					if(arr1[i][j]==d)
						square[d]++;
				}
			}
		}
		for(int i= 1;i<=N;i++) {
			System.out.println(square[i]);
		}
	}

}
