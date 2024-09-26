import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11004_k번째수 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			// 배열에 저장
		}

		quickSort(arr, 0, N - 1, K - 1);
		System.out.println(arr[K-1]);
		

	}

	public static void quickSort(int[] arr, int S, int E, int K) {
		if (S < E) {
			int pivot = partition(arr, S, E);
			if (pivot == K) {
				return;
			} else if (K < pivot) { // 피봇이 K보다 크면, 이전에서 탐색을 해야함
				quickSort(arr, S, pivot - 1, K);
			} else { // 아니면 그 반대
				quickSort(arr, pivot + 1, E, K);
			}
		}
	}

	public static int partition(int[] arr, int S, int E) {
		if (S + 1 == E) { // 데이터가 두개인 경우
			if (arr[S] > arr[E]) {
				swap(arr, S, E);// arr start지점이 end보다 크면 교체
			}
			return E;
		}

		int M = (S + E) / 2; // 가운뎃값
		swap(arr, S, M); // 시작과 가운데를 비교
		int pivot = arr[S]; // 시작지저점을 피봇으로 설정
		int s = S + 1;
		int e = E;

		while (s <= e) { // 둘이 교차하지 않을 때 까지
			while (pivot < arr[e] && e > 0) {
				e--;
			}
			
			while (pivot > arr[s] && s < arr.length - 1) {
				s++;
			}
			if (s <= e) {
				swap(arr, s++, e--); // 1씩 증감하여 피봇 미리 설정하기
			}
		}

		arr[S] = arr[e];
		arr[e] = pivot;
		return e;

	}

	public static void swap(int[] arr, int a, int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
		// 교체
	}
}
