import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2578_빙고 {


    static int[][] bingo;
    static int count;
    static int bingoNum = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bingo = new int[5][5];

        for (int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                bingo[i][j] = Integer.parseInt(st.nextToken());
            }//각 배열에 부른 숫자 넣어주는거
        }

        for (int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                int ans = Integer.parseInt(st.nextToken()); //하나씩 입력해서 비교한다.
                for (int k = 0; k < 5; k++) {
                    for (int l = 0; l < 5; l++) {
                        if (bingo[k][l] == ans) {
                            bingo[k][l] = 0; //0으로 만들어서 부른 숫자임을 확인
                        }
                    }
                }
                rowCheck();
                colCheck();
                leftCrossCheck();
                rightCrossCheck();//각각 빙고 상태를 체크
                if (count >= 3) {
                    System.out.println(bingoNum);
                    System.exit(0); //오류없이 탈출!
                }
                count = 0; //초기화 안시키면 누적되서 잘못 탈출함
                bingoNum++; //부른 숫자 갯수 증가
            }
        }


    }

    //각 배열 비교 함수
    public static void rowCheck() {
        for (int i = 0; i < 5; i++) {
            int zeroCount = 0;
            for (int j = 0; j < 5; j++) {
                if (bingo[i][j] == 0) {
                    zeroCount++;
                }
                if (zeroCount == 5) {
                    count += 1;
                }
            }
        }
    }

    public static void colCheck() {
        for (int i = 0; i < 5; i++) {
            int zeroCount = 0;
            for (int j = 0; j < 5; j++) {
                if (bingo[j][i] == 0) {
                    zeroCount++;
                }
                if (zeroCount == 5) {
                    count += 1;
                }
            }
        }
    }

    public static void leftCrossCheck() {
        int zeroCount = 0;
        for (int i = 0; i < 5; i++) {
            if (bingo[i][i] == 0) {
                zeroCount++;
            }
            if (zeroCount == 5) {
                count += 1;
            }
        }
    }

    public static void rightCrossCheck() {
        int zeroCount = 0;
        for (int i = 0; i < 5; i++) {
            if (bingo[i][4 - i] == 0) {
                zeroCount++;
            }
            if (zeroCount == 5) {
                count += 1;
            }
        }
    }
}


