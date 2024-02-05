import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		//변수 받습니다
		int w = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int p = Integer.parseInt(st.nextToken());
		int q = Integer.parseInt(st.nextToken());
		int t = Integer.parseInt(br.readLine());
		
		// 문제에서 개미는 오른쪽 직사각형으로 움직입니다 (+1,+1)
		// 반복문을 쓰면 절대 시간 내에 풀 수 없어서 다른 방법을 찾아야 합니다
		// 사각형 안을 모서리에 닿으면 방향을 바꾼다는 말은 , 주어진 시간만큼 사각형의 가로 세로를 왕복한다는 말입니다.
		// 즉 총 시간 t 동안 움직인 횟수를 사각형 변의 길이인 h,w로 나눠주면 마지막의 개미의 위치를 알 수 있습니다.
		// (기존의 개미 위치 + t 시간)을 h,w로 나눠서 개미의 위치를 파악합니다.
		// 근데 사각형을 +방향으로 갔다가 - 방향으로 돌아가는데, 사각형의 길이만큼 나눴을 때 짝수번 왕복했으면 +방향, 홀수번은 -방향입니다.
		// -,+ 방향에 따라 0에서 개미의 위치를 셀지, w or h에서 개미의 위치를 셀지 파악할 수 있습니다.
		
		// 사각형을 몇번 왕복했는지 확인하는 변수인 i,j를 설정합니다
		boolean i = ((t+p)/w%2==0);
		boolean j = ((t+q)/h%2==0);
		// 마지막의 개미 위치를 계산합니다.
		int c =(t+p)%w;
		int d =(t+q)%h;
		// x,y에서 i,j가 짝수면 0에서 개미의 위치를 그냥 세주면 되므로 c,d를 그냥 저장하면 되고
		// i,j가 홀수면 개미의 위치를 w,h에서 세줘야 되서 사각형의 길이에서 각 값을 빼줍니다.
		int x = (i==true)? c : w-c ;
		int y = (j==true)? d : h-d ;
		
		//마지막으로 받은 값을 출력해주면 됩니다.
		//멘탈나가는 문제인게 i,j,c,d 변수를 모두 따로 설정하지 않으면 제한 시간에 못맞추게 만들어놨네요.
		
		bw.write(x+" "+y);
		bw.flush();
		bw.close();
	}
}
