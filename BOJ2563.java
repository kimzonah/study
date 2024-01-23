import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2563 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        boolean[][] arr = new boolean[101][101];
        int mul = 0;

        for(int i = 0; i < T; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            for(int j = a; j < a+10; j++) {
                for (int k = b; k < b + 10; k++) {
                    if (!arr[j][k]) { //이미 색칠이 되어있다면 카운트가 안되는거
                        arr[j][k] = true;
                        mul++;
                    }
                }
            }
        }
        System.out.println(mul);
    }
}
