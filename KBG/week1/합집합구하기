import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class hapjip2669 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean[][] visited = new boolean[101][101];
        int count = 0;

        int[] arr = new int[4]; //직사각형 좌표 받을 배열
        
        for(int i = 0; i < 4; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int a = 0; a < 4; a++) {
                arr[a] = Integer.parseInt(st.nextToken());//예제 : {1 2 4 4}
            }
            for(int j = arr[1]; j < arr[3]; j++){ //이렇게 하는 이유는 인덱스 x좌표가 0, 2이니까..
                for(int k = arr[0]; k < arr[2]; k++){
                    visited[j][k] = true;
                }
            }
        }

        for(int i = 0; i < 101; i++){
            for(int j = 0 ; j < 101; j++){
                if(visited[i][j] == true){
                    count++;
                }
                
            }
        }
        System.out.println(count);

    }
}
