package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int student = Integer.parseInt(br.readLine());
		
		ArrayList<Integer> order = new ArrayList<>();
		StringTokenizer st = new StringTokenizer(br.readLine());

    // list의 메서드인 add(index, value)를 이용해서 숫자를 입력 받을 때마다 해당 숫자만큼 앞으로 이동해 값 저장 
		for (int i = 0; i < student; i++) {
			int n = Integer.parseInt(st.nextToken());
			order.add(i - n, i + 1);
		}
		for (int i : order) {
			System.out.print(i + " ");

		}
	}
}
