import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_17070_파이프옮기기1 {
    static int N;
    static int[][] arr;
    static int[] dr = new int[] { 0, 1, 1 };
    static int[] dc = new int[] { 1, 1, 0 }; // 우측, 우측아래, 아래
    static int cnt = 0;

    static boolean[][] check;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        arr = new int[N + 1][N + 1];

        for (int i = 0; i <= N; i++) {
            arr[0][i] = 1;
            arr[i][0] = 1; // 벽으로 만들기
        }

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                arr[j][i] = Integer.parseInt(st.nextToken());
            }
        }

        pipe(1, 1, 1, 2);
        System.out.println(cnt);

    }

    public static void pipe(int c1, int c2, int r1, int r2) {
        if (r2 == N && c2 == N) {
            cnt++;
            return;
        }
        if (c2 == c1 && r2 - r1 == 1) { // 세로
            if (r2 + 1 <= N && arr[r2 + 1][c2] == 0) {
                pipe(c2, c2, r2, r2 + 1); // 세로로 이동
            }
        } else if (c2 - c1 == 1 && r2 == r1) {// 가로
            if (c2 + 1 <= N && arr[r2][c2 + 1] == 0) {
                pipe(c2, c2 + 1, r2, r2); // 가로로 이동
            }
        } else if (c2 - c1 == 1 && r2 - r1 == 1) {// 대각선
            if (r2 + 1 <= N && arr[r2 + 1][c2] == 0) {
                pipe(c2, c2, r2, r2 + 1); // 세로로 이동
            }

            if (c2 + 1 <= N && arr[r2][c2 + 1] == 0) {
                pipe(c2, c2 + 1, r2, r2); // 가로로 이동
            }
        }

        if (r2 + 1 <= N && c2 + 1 <= N && arr[r2 + 1][c2] == 0 && arr[r2][c2 + 1] == 0 && arr[r2 + 1][c2 + 1] == 0) {
            // 대각선 방향
            pipe(c2, c2 + 1, r2, r2 + 1);
        }

    }

}