import java.util.Scanner;

public class Main {
	public static void main(String[] args ) {
		Scanner sc = new Scanner(System.in);
		int height[] = new int[9];
		int sum = 0;
		int num1 = 0;
		int num2 = 0;
		int max = Integer.MIN_VALUE;
		int real[] = new int[9];
		for (int i = 0; i < 9 ; i++ ) {
			height[i] = sc.nextInt();
			sum += height[i];
		}
		//System.out.print(sum);
		for (int i=0;i<9;i++) {
			for (int j=1;j<9;j++) {
				if ((sum-height[i]-height[j])==100) {
					num1 = i;
					num2 = j;
					break;
				}
			}
		}
		for (int i =0 ; i < height.length;i++ ) {
			if (i != num1 && i !=num2) {
				real[i] = height[i];
			}
		}
		for (int i = 0;i < height.length;i++) {
			if(real[i]>max) {
				max = real[i];
			}
		}
		int arr[] = new int[max+1];
		for (int i =0;i<real.length;i++) {
			arr[real[i]]++;
		}
		for (int i = 1 ;i<arr.length;i++ ) {
			if (arr[i]>0) {
				do {
				System.out.println(i);
				arr[i]--;
				}while (arr[i] > 0) ;
			}
		}
	}
}