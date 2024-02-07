package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10158_개미 {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 개미가 돌아다닐 공간 입력받기
		StringTokenizer st = new StringTokenizer(br.readLine());
		int w = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());

		// 개미의 초기 좌표값 입력받기
		st = new StringTokenizer(br.readLine());
		int p = Integer.parseInt(st.nextToken());
		int q = Integer.parseInt(st.nextToken());

		// 개미가 움직일 시간 입력받기
		int t = Integer.parseInt(br.readLine());

		int mp = (p + t) % (2 * w);
		if (mp > w)
			mp = (2 * w) - mp;
		
		int mq = (q + t) % (2 * h);
		if (mq > h)
			mq = (2 * h) - mq;
		
//		// 뭘 할려고 한거지...?
//		if (mp % w == 1) {
//			mp = w - (p + t) % w;
//		} else {
//			mp = (p + t) % w;
//		}
//		
//		if (mq % h == 1) {
//			mq = h - (q + t) % h;
//		} else {
//			mq = (q + t) % h;
//		}
//		
//		
//		// 시간 정제하기
//		t = t % (w * h);
//
//		int dp = 1;
//		int dq = 1;
//
//		while (t > 0) {
//			// x좌표가 공간안에 있으면
//			if (0 < p && p < w) {
//				p += dp;
//			} else { // 없다면 방향을 틀어준다
//				dp *= -1;
//				p += dp;
//			}
//			// y좌표가 공간 안에 있으면
//			if (0 < q && q < h) {
//				q += dq;
//			} else {
//				dq *= -1;
//				q += dq;
//			}
//			t--;
//		}
		System.out.printf("%d %d\n", mp, mq);
	}
}
