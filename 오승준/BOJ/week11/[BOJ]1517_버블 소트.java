import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
	static int N;
	static int[] arr;
	static int[] sortedArr;
	static long ans;

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	// 버블 소트를 일어난 횟수를 머지소트로 찾아야 한다
	// 버블 소트는 왼쪽 값이 돌면서 오른쪽 값보다 크면 자리 바꿈
	// 머지소트는 왼쪽(idx) 중심으로 값이 다르면 위치 변경
	// 즉 머지소트는 버블 소트가 +1,-1 씩 이동 하는 횟수를 +n, -n씩 이동한다고 생각하면 된다
	
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		
		arr = new int[N];
		sortedArr = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		mergesort(0, arr.length-1);
		
		// 머지 다 돌리면 위치가 뒤바뀐 횟수가 ans에 저장되죠?
		// 근데 왼쪽 애가 위치를 혼자 바꾼게 아니라 오른쪽 값도 바뀌므로
		// 바뀐 횟수를 절반 나눠주면 끝
		bw.write((ans/2)+"");
		bw.flush();
		bw.close();
	}
	// 머지소트 구현부
	private static void mergesort(int left, int right) {
		if(left<right) {
			int mid = (left+right)/2;
			mergesort(left,mid);
			mergesort(mid+1,right);
			
			merge(left,mid,right);
		}
		
	}

	private static void merge(int left, int mid, int right) {
		int L = left;
		int R = mid+1;
		int idx = left;
		
		while(L<=mid&&R<=right) {
			if(arr[L]<=arr[R]) {
				// L이 idx로 간다 -> L-idx만큼 버블 소트 된 것과 같음
				// 뒤 바뀌는 인덱스의 차이를 ans에 넣어줌
				// 밑에도 똑같이
				ans += Math.abs(L-idx);
				sortedArr[idx++] = arr[L++];
			}
			else {
				ans += Math.abs(R-idx);
				sortedArr[idx++] = arr[R++];
			}
		}
		if(L<=mid) {
			for(int i=L;i<=mid;i++) {				
				ans += Math.abs(i-idx);
				sortedArr[idx++] = arr[i];
			}
		} else {
			for(int i=R;i<=right;i++) {
				ans += Math.abs(i-idx);
				sortedArr[idx++] = arr[i];
			}
		}
		
		for(int i=left;i<=right;i++) {
			arr[i]=sortedArr[i];
		}
		
	}



}