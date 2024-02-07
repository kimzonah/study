package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Gaemi {	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		// 배열의 크기 w, h
		String[] wh = br.readLine().split(" ");
		int w = Integer.parseInt(wh[0]);
		int h = Integer.parseInt(wh[1]);
		
		// 초기 파리 위치 p, q
		String[] pq = br.readLine().split(" ");
		int p = Integer.parseInt(pq[0]);
		int q = Integer.parseInt(pq[1]);
		
		// 개미 이동 시간 t
		int t = Integer.parseInt(br.readLine());
		
		// 몇시간 후인지 계산		
		int currentX = (p + t) % (2 * w);
        int currentY = (q + t) % (2 * h);

        if (currentX > w) currentX = 2 * w - currentX;
        if (currentY > h) currentY = 2 * h - currentY;

        sb.append(currentX).append(" ").append(currentY);
        System.out.println(sb);
	}
}