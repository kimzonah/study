import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ2628 {

	public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(br.readLine());
        int[] row = new int[N]; //가로 자르기.
        int[] col = new int[N]; //세로 자르기
        int maxR = 0; //세로길이 
        int maxC = 0; //가로길이
        int result = 0;

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int rC = Integer.parseInt(st.nextToken());
            if(rC == 0){
                row[i] = Integer.parseInt(st.nextToken());
            }else{//rC가 0이면 가로배열에, 아니면 새로배열에 저장.
                col[i] = Integer.parseInt(st.nextToken());
            }
        }
        Arrays.sort(row); // 0 2 3 8
        Arrays.sort(col); //순서대로 정렬 // 0 4 10

        for(int i = 1; i < row.length; i++){
            result = row[i] - row[i-1];
            if(result > maxR){
                maxR = result;
            }
        }

        for(int i = 1; i < col.length; i++){
            result = col[i] - col[i-1];
            if(result > maxC){
                maxC = result;
            }
        }
        maxR = Math.max(maxR, C - row[N-1]);
        maxC = Math.max(maxC, R - col[N-1]);

        System.out.println(maxR * maxC);

        
    
    }

}
