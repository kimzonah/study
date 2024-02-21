import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
 
public class Solution {
    // TC 선언
    static int TC;
    // 변수 N 선언
    static int N;
 
    public static void main(String[] args) throws NumberFormatException, IOException {
        // br, bw, st 생성
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        // 우선순위 큐 선언
        PriorityQueue<Integer> pq;
        // TC 입력
        TC = Integer.parseInt(br.readLine());
        // TC 만큼 반복
        for(int T=1;T<=TC;T++) {
            bw.write("#"+T);
            pq = new PriorityQueue<>((a,b) -> {return b-a;} );
            // 변수 N 입력
            N = Integer.parseInt(br.readLine());
            // 변수 N 만큼 반복
            for(int i=0;i<N;i++) {
                st = new StringTokenizer(br.readLine());
                // st로 받고 nextToken이 1이면 add 실행
                if(st.nextToken().equals("1")) {
                    pq.add(Integer.parseInt(st.nextToken()));
                } else {
                    // 2이면 poll 실행
                    // pq가 비어있으면 -1 출력
                    if(pq.size()==0) {
                        bw.write(" "+(-1));
                    } else {                        
                        bw.write(" "+pq.poll());
                    }
                }
            }
            bw.write("\n");
            bw.flush();
        }
        bw.close();
    }
}