import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] xy = new int[1001][1001];
        int N = Integer.parseInt(br.readLine());
        int answer[] = new int[N];

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int x0 = Integer.parseInt(st.nextToken());
            int y0 = Integer.parseInt(st.nextToken());
            int width = Integer.parseInt(st.nextToken());
            int length = Integer.parseInt(st.nextToken());

            for (int x = x0; x < x0 + width; x++) {
                for (int y = y0; y < y0 + length; y++) {
                    xy[x][y] = i;
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            for (int x = 0; x < 1001; x++) {
                for (int y = 0; y < 1001; y++) {
                    if (xy[x][y] == i) {
                        answer[i - 1] += 1;
                    }
                }
            }
        }
        for (int i = 0; i < N; i++) {
            System.out.println(answer[i]);
        }
    }
}
