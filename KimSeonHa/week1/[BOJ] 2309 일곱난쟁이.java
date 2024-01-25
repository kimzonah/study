package im;

import java.util.Arrays;
import java.util.Scanner;

public class Seven_2309 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[] dwarf = new int[9];
		int sum = 0;
		
		for(int i=0; i<9; i++) {
			dwarf[i] = sc.nextInt();
			sum += dwarf[i];
		}
			
		for(int i=0;i<8;i++) {
			for(int j=i+1;j<9;j++) {
				if(dwarf[i] + dwarf[j] == sum-100) {
					dwarf[i] = 0;
					dwarf[j] = 0;
					
					Arrays.sort(dwarf);
					for(int k=2; k<9; k++) {
						System.out.println(dwarf[k]);
					}
					return;
				}
			}
		
		}
		
		
		
		
		
	}
}
