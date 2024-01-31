import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_2477_참외밭 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int ea = Integer.parseInt(br.readLine());
        boolean check = false;
        ArrayList<Integer>[] melon = new ArrayList[5];
        for(int i = 0; i < 5; i++) {
            melon[i] = new ArrayList<Integer>();
        }
        int scurNum = 0;
        int spreNum = 0;
        int firstidx = 0;//초기 숫자
        int firstNum = 0;
        int curidx = 0; //현재의 인덱스
        int preidx = 0; //이전의 인덱스
        int preNum = 0; //이전 번호
        int curNum = 0; //현재 번호
        int area = 1;


        for(int i = 0 ; i < 6; i++) {
            st = new StringTokenizer(br.readLine());
            curNum = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            melon[curNum].add(m);  //해당 번호 인덱스에 m 값 저장
            if(preNum == 0) {
                firstidx = melon[curNum].indexOf(m);
                firstNum = melon[curNum].get(firstidx);
            }
            if(curNum == 1 && preNum == 4 || curNum == 2 && preNum == 3
                    || curNum == 3 && preNum == 1 || curNum == 4 && preNum == 2) { //동쪽으로 꺾이면
                curidx = melon[curNum].indexOf(m); //현재 값을 scurNum에
                scurNum = melon[curNum].get(curidx);
                spreNum = melon[preNum].get(preidx); //이전에 있던 값을 spreNum에
                check = true;
            }
            preidx = melon[curNum].indexOf(m); //인덱스 번호를 저장해놓고
            preNum = curNum; // 4 2 3 1 3 1 현재 번호를 이전 번호로 저장
        }

        if(!check) {
            scurNum = firstNum;
            spreNum = melon[preNum].get(preidx);
        }


        for(int i = 1; i < 5; i++) {
            if(melon[i].size() == 2) {
                continue;
            }
            else {
                area *= melon[i].get(0); //전체 넓이를 구한다!
            }
        }
        System.out.println(ea * (area - (scurNum * spreNum))); //면적에 ea곱한값
    }

}
