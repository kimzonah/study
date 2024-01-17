import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> height = new ArrayList<>();
        int sum = 0;

        // 난쟁이들 키 입력 받고
        for (int i = 0; i < 9; i++) {
            height.add(Integer.parseInt(br.readLine()));
        }

        // 모두 더함
        for (int i: height) {
            sum += i;
        }

        out : for (int i : height) {
            for (int j : height) {
                if (i == j) {
                    continue;
                }
                if ((sum - i) - j == 100) { // 두 정수 빼서 100이 되면, List에서 두 정수 삭제
                    height.remove(Integer.valueOf(i));
                    height.remove(Integer.valueOf(j));
								break out;
                }
            }
        }

        Collections.sort(height);

        for (Integer i : height) {
            System.out.println(i);

        }
    }
}
