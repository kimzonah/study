import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        // BufferedReader 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int sum = 0;
        int[][] xy = new int[100][100];

        // 4개의 직사각형 좌표 입력 받기
        for (int i = 0; i < 4; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            // 배열 초기화가 0으로 되어 있기 때문에 입력받은 좌표 내의 좌표들 값을 모두 1로 변경
            for (int x = x1; x < x2; x++) {
                for (int y = y1; y < y2; y++) {
                    xy[x][y] = 1;
                }
            }
        }

        // 배열의 값(1)을 모두 더해 면적을 구함 
        for (int x = 0; x < 100; x++) {
            for (int y = 0; y < 100; y++) {
                sum += xy[x][y];
            }
        }

        System.out.println(sum);
    }
}
