import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {
    static int T, N;
    static String ans;

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    // [BOJ]10504_덧셈
    public static void main(String[] args) throws IOException {
        // 풀이과정

        // 홀수 = (N/2) +(N/2+1)
        // 2의 제곱수 = IMPOSSIBE(같은 수로 나누어져서 불가능)
        // 다른 짝수 = 2로 나눠서 홀수가될 때까지 나눔
        // 이 때 2로 나눈 만큼 +1, -1 더하면서 수 추가
        // -1이 되는 2의 수가 많아져서 맨 처음 수가 1보다 작아지면
        // Impossible이 된다
        T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            N = Integer.parseInt(br.readLine());
            // N이 1보다는 큰 홀수면
            if (N > 1 && N % 2 == 1) {
                sb.append(N+" = "+(N/2)+" + "+(N/2+1)+"\n");
            } else {
                // 나머지는 돌려봐야 안다
                Even(N,1);
            }
        }
        System.out.print(sb);

    }

    private static void Even(int num, int count) throws IOException {
    	//System.out.println("num : "+num+" count :" +count);
        if(num==1) {
            // 1이 나왔다는 거는 모든 수가 2로 나누어진다는 뜻
            // 이 수는 연속해서 만들 수 없다
        	sb.append("IMPOSSIBLE\n");
            return;
        } else {
            // 나머지 수에 대해서 홀짝 여부를 판단
        	// 짝수가 나오면 더 들어가고
            if(num%2==0) {
                Even(num/2,count*2);
            } else {
                // 홀수가 나왔으면
            	// 그 수가 나어지는 값 중 가장 작은 인수를 남기고 다시 num에 더한다
            	// 홀수가 나누어지지 않으면 지금까지의 num에서 -1,+1 씩 해서 그 홀수개의 수로 이뤄질도록 함
            	boolean flag = false;
            	
            	for(int i=3;i<=Math.sqrt(num);i++) {
            		if(num%i==0) {
            			flag = true;
                        // 가장 짧은 수를 구하기 위해 작은 수로 나눠준다
            			Even(i,count*(num/i));
            			break;
            		}
            	}
            	
            	// flag가 true면 나누어지지 않는 가장 작은 값이다
            	if(!flag) {
            		int min = count-(num/2);
            		int max = count+(num/2);
                    // min이 0보다 작으면 양의 정수로 표현 불가능
            		if(min<0) {
            			sb.append("IMPOSSIBLE\n");
            		} else {
            			sb.append(N+" = ");
            			for(int i=min==0? 1 : min;i<max;i++) {
            				sb.append(i+" + ");
            			}
            			sb.append(max+"\n");
            		}
            		return;
            	}
            	return;
            }
        }
    }

}