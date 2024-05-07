import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean[][] arr = new boolean[101][101];
		int a[] = new int[4];
		int cnt = 0;
		
		for (int r =0;r<4;r++) {
			for (int c =0;c<4;c++) {
				a[c]=sc.nextInt();
			}
			for(int i =a[0];i<a[2];i++) {
				for(int j=a[1];j<a[3];j++) {
					arr[i][j] = true;
				}
			}

		}
		for(int i=0;i<arr[0].length;i++) {
			for(int j =0;j<arr[0].length;j++) {
				if (arr[i][j]==true) {
					cnt++;
				}
			}
		}
		System.out.println(cnt);
	}
}
