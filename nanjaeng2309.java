import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class nanjaeng2309{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] nan = new int[9];
        int sum = 0;

        for(int i = 0; i < 9; i++){
            nan[i] = Integer.parseInt(br.readLine()); //각 키를 배열에 저장한다.
            sum += nan[i];
        }

        for(int i = 0; i < 8; i++){//i는 0부터 7번 인덱스까지.
            for(int j = i+1; j < 9; j++){ //j는 1부터 8번 인덱스까지
                if(sum - nan[i] - nan[j] == 100){ //만약 빼가면서 100인게 있으면 이 두개는 가짜니까
                    nan[i] = 0; //0으로 설정하고
                    nan[j] = 0;
                    Arrays.sort(nan); //정렬(오름차순)
                    for(int k = 2; k < 9; k++){
                        System.out.println(nan[k]); //출력
                    }
                    return;
                }
            }
        }

    }
}
