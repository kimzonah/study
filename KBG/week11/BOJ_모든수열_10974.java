import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_모든수열_10974 {
	static int N;
	static int[] arr;
	static boolean[] check;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N + 1];
		check = new boolean[N+1];
		check[0] = true;
		
		permutation(1);
		
	}
	
	public static void permutation(int cnt) {
		if(cnt == N + 1) {
			for(int i = 1; i <= N; i++) {
				System.out.print(arr[i] + " ");
			}
			System.out.println();
			return;
		}
		
		for(int i = 1; i <= N; i++) {
			if(!check[i]) {
				check[i] = true;
				arr[cnt] = i;
				permutation(cnt + 1);
				check[i] = false;
				}
			}
	}

}
