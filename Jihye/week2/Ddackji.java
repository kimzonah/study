package backjun;

import java.io.*;
import java.util.*;

public class Ddackji {
	public static void main(String[] args) throws IOException {
		// N 입력 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;

        // 딱지 정보를 입력할 list 만들기
        ArrayList<Integer> listA = new ArrayList<>();
        ArrayList<Integer> listB = new ArrayList<>();
        String[] answer = new String[N];

        for (int i = 0; i < N; i++) {
        	// 새로운  라운드 시작 시 리스트 초기화
        	listA.clear(); listB.clear();
        	
        	// listA 입력 받기
            st = new StringTokenizer(br.readLine());
            int na = Integer.parseInt(st.nextToken());

            for (int j = 0; j < na; j++) {
                listA.add(Integer.parseInt(st.nextToken()));    
            }

            // listB 입력 받기
            st = new StringTokenizer(br.readLine());
            int nb = Integer.parseInt(st.nextToken());

            for (int j = 0; j < nb; j++) {
                listB.add(Integer.parseInt(st.nextToken()));    
            }
            
            // 답이 나올 때까지 반복
            while (answer[i] == null) {
            	// 배열이 비었다면 최대값에 0을 대입하고, 아니라면 최대값 계산 후 대입
            	int listAMax = listA.isEmpty() ? 0 : Collections.max(listA);
                int listBMax = listB.isEmpty() ? 0 : Collections.max(listB);
                
             // 둘 중 한 리스트의 최대값이 더 크면, 그것이 정답
                if (listAMax != listBMax) { 
                    answer[i] = listAMax > listBMax ? "A" : "B";
                    continue;
                }
                // 최대값이 같지만, 최대값의 빈도수가 더 큰 것이 정답
                else if (Collections.frequency(listA, listAMax) != Collections.frequency(listB, listBMax)) {
                    answer[i] = Collections.frequency(listA, listAMax) > Collections.frequency(listB, listBMax) ? "A" : "B";
                    continue;
                }
                // 최대값과 빈도수가 모두 같다면, 최대값 배열에서 삭제
                listA.remove(listA.indexOf(listAMax));
                listB.remove(listB.indexOf(listBMax));
                // 두 배열 모두 비었다면 비겼음
                if (listA.isEmpty() && listB.isEmpty()) {
                	answer[i] = "D";
                }
            }
        
        }
        for(String str : answer) {
            System.out.println(str);
        }
    }
}