import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1244_스위치켜고끄기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int switchNumber = Integer.parseInt(br.readLine()); //스위치의 갯수
        int[] swit = new int[switchNumber]; // 스위치 상태를 저장할 배열
        StringTokenizer st = new StringTokenizer(br.readLine());
        //switch = [0,1,2,3,4,5,6,7]
        for (int i = 0; i < switchNumber; i++) {
            swit[i] = Integer.parseInt(st.nextToken());
        }

        int student = Integer.parseInt(br.readLine());

        for (int i = 0; i < student; i++) {
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken()); // 성별
            int N = Integer.parseInt(st.nextToken()); // 스위치 숫자
            if (S == 1) {
                for (int j = 0; j < switchNumber; j++) {
                    if ((j + 1) % N == 0) {
                        swit[j] = swit[j] == 0 ? 1 : 0;
                    }
                }
            } else {
                swit[N - 1] = swit[N - 1] == 0 ? 1 : 0; //그 당사자 비교해서 바꿈
                for (int j = 1; j < switchNumber; j++) {
                    if (N - 1 - j < 0 || N - 1 + j >= switchNumber) {
                        break;
                    }

                    if (swit[N - 1 - j] == swit[N - 1 + j]) {
                        swit[N - 1 - j] = swit[N - 1 - j] == 0 ? 1 : 0;
                        swit[N - 1 + j] = swit[N - 1 + j] == 0 ? 1 : 0;
                    } else {
                        break;
                    }
                }
            }
        }

        for (int i = 0; i < switchNumber; i++) {
            System.out.print(swit[i] + " ");
            if ((i + 1) % 20 == 0) {
                System.out.println();
            }
        }
    }
}
//남자 : 스위치 번호의 배수 상태 반대로
//여자 : 스위치 중심으로 좌우가 같으면 그 범위 전부다 전환, 같은게 또 있다면 계속 전환
//여자 : 이때, 좌우가 다르면 자기만 바꿈
