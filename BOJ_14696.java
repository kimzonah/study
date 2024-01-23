import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14696 {

	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // N 입력 받고
		String winner = " ";
		
		
		for(int k = 0; k < N; k++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a= Integer.parseInt(st.nextToken());
			int[] aNum = new int[5];
			int[] bNum = new int[5];
			int drawCount = 0;
			
			for(int i = 0; i < a; i++) {
				aNum[Integer.parseInt(st.nextToken())]++;
			}
			st = new StringTokenizer(br.readLine());
			int b = Integer.parseInt(st.nextToken());
			for(int i = 0; i < b; i++) {
				bNum[Integer.parseInt(st.nextToken())]++;
			}
			
			for(int i = 4; i > 0; i--) {
				if(aNum[i] > bNum[i]) {
					winner = "A";
					break;
				}else if(aNum[i] < bNum[i]) {
					winner = "B";
					break;
				}
				else{
					drawCount++;
					if(drawCount == 4) {
						winner = "D";
					}
					continue;
				}
			}
			
			System.out.println(winner);
		}

	}

}
