package backjun;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class ColorPaper {
	public static void main(String[] args) throws IOException {
		// N(색종이의 수) 입력 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
		// 넓이를 계산하기 위해 boolean 배열 생성
        boolean[][] arr = new boolean[101][101];
        
        int area = 0;
        
        for (int i = 0; i < N; i++) {
			// BufferedReader의 readLine을 사용하면, 데이터를 줄단위로 입력 받음
			// split()는 문자열을 잘라 문자열 배열을 만드는 메소드
			// " "를 넣어줌으로써 공백단위로 문자열 자름
			String[] input = br.readLine().split(" ");

			// x, y좌표를 입력 받음
			int x = Integer.parseInt(input[0]);
			int y = Integer.parseInt(input[1]);
			
			// x ~ x + j, y ~ y + k의 좌표값을 true로 바꿈
			for(int j = 0;j <10; j++) {
				for(int k = 0;k <10; k++) {
					arr[x + j][y + k] = true;
				}
			}
		}

		// 배열을 돌면서 true값일때, 면적에 1을 더함
        for(int i=1; i<101; i++) {
        	for(int j=1; j<101; j++) {
            	if(arr[i][j]) {
            		area++;
            	}

        	}
        }
        System.out.println(area);
	}
}
