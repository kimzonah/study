import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine()); // 참외 수
		int[][] arr = new int[6][2]; // 벙향 별로 입력 받는 수
		int[] cnt = new int[5];
		List<Integer> longer = new ArrayList<Integer>(); // 안꺾이는 방향, 두개 곱하면 꽉찬 사각형의 넓이
		List<Integer> shorter = new ArrayList<Integer>(); // 꽉 찬 넓이에서 빈 사각형 빼줘야 돼용
		List<Integer> ii = new ArrayList<Integer>();
		int s1 = 0;			//전체 사각형의 넓이
		int s2 = 1;			// 꺾이는 부분의 비어있는 사각형의 넓이

		for (int i = 0; i < 6; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken()); // 방향이 두번 나오면 2차 배열의 1번 항이 채워져요
			arr[i][1] = Integer.parseInt(st.nextToken());

		}
		for (int i = 0; i < 6; i++) {
			cnt[arr[i][0]]++;
		}
		for (int i = 1; i <= 4; i++) {	//cnt 2면 두번 나온거 == 한번 꺾였다. 즉 짧은 곳이다
			if(cnt[i] == 1) {
				longer.add(i);			// 1은 긴 방향이니까 longer
			} else if (cnt[i] ==2) {
				shorter.add(i);			// 2는 짧으니까 shorter 넣어주구요
			}
		}

		for (int i = 0; i < 6; i++) {
			if (arr[i][0] == longer.get(0)||arr[i][0]==longer.get(1)) {
				s2 *= arr[i][1];		//긴 부분으로 전체 사각형 넓이 구해줍니다. 긴쪽은 따로 뭐할 필요 없이 곱해주기만 하면 돼요
				continue;
			}
		}
		for (int i = 0; i < 6; i++) {	//이제 지옥 시작입니더
			if (longer.get(0) == arr[i][0]) { 	// longer의 인덱스 위치에 따라 짧은 곳에서 꺾인 방향을 찾을 수 있습니다.
				ii.add(i);						// 그래서 일단 기다란 부분의 인덱스를 찾아서 ii에 넣어줍니다.
			}
			if (longer.get(1)== arr[i][0]) {
				ii.add(i);
			}
		}	
		
		if (ii.size() == 0) {					// 방금 위에서 찾을 때  i를 1부터 찾아서 넣은 구문인데.. 이건 수정 중에 없애도 됐었던 것 같습니다.
			ii.add(0);
			ii.add(5);
		}

		switch (ii.get(0) + ii.get(1)) {		// 육각형의 방향 꺾임은 긴쪽이 나온 순서에따라 알 수 있습니다.
			case 1:								// longer 인덱스가 0, 1 이었을 때, 긴긴짧짧짧짧 으로 사각형이 그려집니다.
				s1 = arr[3][1] * arr[4][1];		// 위에 짧짧짧짧이 있을 때, 중간의 짧(짧짧)짧 부분이 꺽이는 부분입니다.
				break;							// 그래서 longer 인덱스가 0,1일 때 꺾이는 부분이 3,4번 인덱스 값이고, 이 두 값을 곱해주면 빈 사각형 넓이입니다.
			case 3:								
				s1 = arr[4][1] * arr[5][1];
				break;
			case 5:								// 인덱스값의 합이 5인 경우가 (0,5),(2,3)의 두가지가 있어 또 두가지 케이스로 나눠줍니다.
				if (ii.get(0) * ii.get(1) == 0) {	// 아주 개고생입니다. 깔끔한 방법있음 알려주세용
					s1 = arr[2][1] * arr[3][1];
					break;
				} else {
					s1 = arr[5][1] * arr[0][1];
					break;
				}
			case 7:
				s1 = arr[0][1] * arr[1][1];
				break;
			case 9:								// 9까지 다 구했으면 완성입니다 ㅠ
				s1 = arr[1][1] * arr[2][1];
				break;
		}
		System.out.println(N * (s2 - s1));				// s값 뺀거에다가 참외수 곱해주면 끝~

	}
}
