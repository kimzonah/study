import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class room13300 {
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); //학생 수
        int K = Integer.parseInt(st.nextToken()); //방 수
        int[][] arr = new int[2][7]; //[2] = 성별 나누는용, [7] = 학년 나누는 용 크기가 7인이유 : 학년 1~6학년이므로 0을 무시하기 위함
        int count = 0; //방 갯수 확인하는 변수

        //0 여학생, 1 남학생
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken()); //성별
            int Y = Integer.parseInt(st.nextToken()); //학년

            arr[S][Y]++; //입력 받은 성별과 학년에 해당하는 배열의 인덱스에 +1
        }

        for(int i = 0; i < 2; i++){ // 여자, 남자 돌거다
            for(int j = 1; j <= 6; j++){ //1학년부터 6학년까지 돌거다
                if(arr[i][j] == 0){
                    continue; //배열이 비어있으면 굳이 볼 필요 없음.
                }
                if(arr[i][j] % K != 0){ //만약 빈자리가 있다면.
                    count++; //카운트를 증가시켜서 남는 사람이 있는 것을 확인.
                }
                    count += arr[i][j] / K; // 만약에 K 명 초과인 경우에 대비해서..
            }
        }

        System.out.println(count);
    }
}
