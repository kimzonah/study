import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int w = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken()); //격자 크기
		st = new StringTokenizer(br.readLine());
		int p = Integer.parseInt(st.nextToken()); //초기 좌표
		int q = Integer.parseInt(st.nextToken());
		int t = Integer.parseInt(br.readLine()); //시간
		
		
		int afterP = (p + t) % (2 * w); //사이클이 2w ,2h이므로
		int afterQ = (q + t) % (2 * h); //시간에 따른 값을 더해주고 나머지를 구해보면 해당 좌표가 나옴
		//근데 증가할때 만임. 감소할 때는, (p+t)나 (q+t)값이 w, h보다 큼
		//꼭 괄호 쳐야됩니다. 앞에가 우선 연산돼요 
		
		//그래서, 거기서 w나 h를 뺴줄 것.
		if(afterP > w) {
			afterP = 2 * w - afterP; 
		}
		if(afterQ > h) {
			afterQ = 2 * h - afterQ;
		}
		sb.append(afterP).append(" ").append(afterQ);
		System.out.println(sb);
		
	}

}
