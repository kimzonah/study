import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();		// 딱지 놀이하는 횟수 받구요
		
		for(int i=0;i<n;i++) {
			int[] cnt1 = new int[5];       	 // 모양(숫자)나온 횟수 카운팅합니다 1부터 셀거니까 길이는 5로~        						
			int a = sc.nextInt();        	// 모양 개수 나오구요
			int[] arr1 = new int[a];     	// 값을 받아주는 arr1 변수 넣습니다. 근데 이거 없어도 카운트만 있어도 됬겠어요 ㅎ
		for (int r=0;r<a;r++) {  
				arr1[r] = sc.nextInt();  
				cnt1[arr1[r]]++;        // arr1[r] 값 그대로 카운팅에 넣어주심 됩니당
			}
                                        
			int b = sc.nextInt();
			int[] cnt2 = new int[5]; 	// B친구 카드 뽑아야죠 
			int[] arr2 = new int[b];
			for (int c=0;c<b;c++) {
				arr2[c] = sc.nextInt();
				cnt2[arr2[c]]++;
			}
			
			for (int x=4;x>0;x--) {         //이제 4부터 역순으로 세면서 먼저 더 많이 가진 놈이 이깁니다
				if(cnt1[x]>cnt2[x]) {
					System.out.println("A");
					break;
				} else if (cnt1[x]<cnt2[x]) {
					System.out.println("B");
					break;
				} else if (cnt1[x]==cnt2[x] && x>1) { // x==1일때를 정해줘야 비긴걸 내주드라구요
					continue;
				} else {
					System.out.println("D");
				}
			}
			
		}
	}

}
