import java.util.Arrays;
import java.util.Scanner;

public class B_2309_일곱_난쟁이 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[] height = new int[9];	// 아홉 난쟁이의 키
		int sum = 0;
		int check_hundred = 0;
		
		for (int i = 0; i < 9; i++) {
			height[i] = sc.nextInt();
		}
		
		for (int i : height) {	// 아홉 난쟁이 키 총합 구하기
			sum += i;
		}
		
		int k = 1;
		int temp = 0;
		for (int i = 0; i < height.length - 2; i++) {	// index 0 ~ 7 차례대로
			for (int j = k; j < height.length; j++) {	// index 1 ~ 8, 2 ~ 8 ... 차례대로
				check_hundred = sum - (height[i] + height[j]);	// 빼고 총합이 100이 되는 둘을 찾기
				if (check_hundred == 100) {	
					height[i] = 0;	//해당하는 아이 0으로 만들기
					height[j] = 0;	//해당하는 아이 2222
					break;
				}
			}
			if (check_hundred == 100) {	// 완전히 탈출하기
				break;
			}
			k++;	// j 초기값 늘려주기
		}
		
		Arrays.sort(height);	// 두 아이 0으로 만들었으니 오름차순 정렬 후
		
		for (int i : height) {	// 0 초과하는 아이들만 출력
			if (i > 0) {
				System.out.println(i);
			}
		}
	}
}
