package week01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Dwarf {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<Integer> dwarfs = new ArrayList<>();
		int sum = 0; // 난쟁이들 키의 합 담을 변수

		for (int i = 0; i < 9; i++) {
			dwarfs.add(Integer.parseInt(br.readLine()));
			sum += dwarfs.get(i); // 난쟁이들 키의 전체 합
		}

		boolean flag = false; // 바깥 for문 나오기 위한 변수

		for (int i = 0; i <= 7; i++) {
			for (int j = i + 1; j <= 8; j++) {
				if ((sum - (dwarfs.get(i) + dwarfs.get(j))) == 100) { // 키 전체 합에서 두개합 뺀 게 100이면
					dwarfs.remove(j); // 그 값을 삭제하고
					dwarfs.remove(i);
					flag = true; 
					break;
				}
			}
			if (flag == true) // 반복문 전체 나오기
				break;
		}

		Collections.sort(dwarfs); // 리스트 오름차순 정렬
		for (int i : dwarfs) {
			System.out.println(i);
		}

	}

}
