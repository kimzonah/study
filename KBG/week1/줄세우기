import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class line2605 {

    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); //학생수
        int[] num = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            num[i] = Integer.parseInt(st.nextToken());
        } // 각 학생의 번호를 넣어줌 예제 : {0,1,1,3,2}

        int[] stu = new int[N]; //학생 순서 저장할 배열
        stu[0] = 1;

        for(int i = 1; i < N; i++){
            int index = i - num[i];//다음학생을 넣을 인덱스 찾기
            for(int j = i; j >= index + 1; j--){
                stu[j] = stu[j-1]; //인덱스 전까지 순서를 바꿔야하니 밀어주고
            }
            stu[index] = i+1; //그 밀어낸 빈자리에 해당하는 값을 넣는다.
        }
        
        for(int i = 0; i < N; i++){
            System.out.print(stu[i] + " ");
        }

    }
    
    
}


