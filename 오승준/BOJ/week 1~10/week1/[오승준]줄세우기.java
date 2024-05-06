import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] num = new int[n];
		int[] line = new int[n+1];
		for(int i = 0 ; i<n;i++) {
			num[i] = sc.nextInt();
			if(i==0) {
				line[n] = i+1;
			} else {
				if (num[i]>0) {
					if (line[n-num[i]]>0) {
						for(int d = 0;d<n-num[i];d++) {
							line[d]=line[d+1];
						}
						line[n-num[i]] = i+1;						
					} else {
						line[n-num[i]] = i+1;
					}
				} else if (num[i] == 0){
						for(int d = 0;d<n;d++) {
							line[d]=line[d+1];
						}
						line[n-num[i]] = i+1;	
				}
			}
		}
		for (int i = 0 ; i<=n;i++) {
			if (line[i]!=0) {
				System.out.print(line[i]+" ");
			}
		}
	}
}
