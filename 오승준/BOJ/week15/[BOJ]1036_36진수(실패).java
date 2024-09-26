import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;


class Main{
    static int N,K;
    // 36가지의 문자, 50개의 숫자 -> 총 가능한 문자 자리수는 52개
    static int[][] num = new int[36][52];
    static int[] ans = new int[52];
    static boolean[] check = new boolean[36];
    static int[] max = new int[36];
    
    static ArrayList<Integer> list = new ArrayList<>();
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        
        // 풀이과정
        
        // 수의 저장방법은 int[][]로 자리수와 나온 수를 저장
        // 한 자리수마다 36을 넘어가는 경우 36을 나눈 값을 저장하고 몫은 다음 인덱스에 넘긴다
        // 등장한 문자열마다 각 배열의 값이 더 큰 값을 비교
            // 0번 자리수부터 시작해서 가장 큰 자리수와 그 자리수의 값을 찾는다
        // 가장 큰 문자의 값부터 K개의 문자를 골라 Z로 바꿔준다(물론 Z면 제외)
        // 바꿔준 값을 더해주고 정리하면 끝
        
        N = Integer.parseInt(br.readLine());

        
        
        for(int i=0;i<N;i++) {
            String str = br.readLine();
            // 자리수대로 저장하기 위해 
            for(int j=0;j<str.length();j++) {
                // 숫자는 그대로, 알파벳은 A가 10이 되도록 ('A'-55) 처리
                if(str.charAt(j)<='9') {
                	int alp = str.charAt(j)-'0';
                    num[alp][str.length()-1-j] ++;
                    if(num[alp][str.length()-1-j]>35) {
                        num[alp][str.length()-j]+= num[alp][str.length()-1-j]/36;
                        num[alp][str.length()-1-j]%=36;
                    }
                    if(!check[alp]) {
                        list.add(alp);
                        check[alp] = true;
                    }
                } else {
                    num[str.charAt(j)-55][str.length()-1-j]++;
                    if(num[str.charAt(j)-55][str.length()-1-j]>35) {
                        num[str.charAt(j)-55][str.length()-j]+= num[str.charAt(j)-55][str.length()-1-j]/36;
                        num[str.charAt(j)-55][str.length()-1-j]%=36;
                    }
                    if(!check[str.charAt(j)-55]) {
                        list.add(str.charAt(j)-55);
                        check[str.charAt(j)-55] = true;
                    }
                }
            }
        }
        K = Integer.parseInt(br.readLine());
        // 각 문자별 최대 인덱스를 찾는다
        for(int i=0;i<36;i++) {
            for(int j=0;j<52;j++) {
                if(num[i][j]>0) {
                    if(max[i]<j) max[i] =j;
                }
            }
        }
        // 정보의 입력이 끝나면 가장 큰 값부터 정렬
        int[] arr = bubblesort();
        
        // K개의 숫자가 바뀔 때 까지 변경
        int count = 0;
        while(count!=K&&count<arr.length) {
            if(arr[count]==35) continue;
            for(int i=0;i<52;i++) {
                // 정렬된 순서대로 자리수에 있던 값을 Z(35)에다 더해줌
                num[35][i] += num[arr[count]][i];
                num[arr[count]][i] = 0;
            }
            count++;
        }
        
        //나왔던 모든 값의 자리수를 더해준다
        for(int i=0;i<36;i++) {
            for(int j=0;j<52;j++) {
                ans[j] += num[i][j]*i; 
                if(ans[j]>35) {
                    ans[j+1] += ans[j]/36;
                    ans[j] %= 36; 
                }
            }
        }
        // 값을 출력한다
        boolean flag = false;
        for(int i=51;i>=0;i--) {
            if(!flag) {
                if(ans[i]==0) continue;
                flag = true;
                if(ans[i]>9) {
                    char alp = (char)(ans[i]+55);
                    System.out.print(alp);
                } else {
                    System.out.print(ans[i]);
                }
                
            } else {
                if(ans[i]>9) {
                    char alp = (char)(ans[i]+55);
                    System.out.print(alp);
                } else {
                    System.out.print(ans[i]);
                }
            }
        }

    }
    private static int[] bubblesort() {
        int[] tmpList =  new int[list.size()];
        for(int j=0;j<list.size();j++) {
            tmpList[j] = list.get(j);
        }
        
        for(int i=0;i<tmpList.length-1;i++) {
            for(int j=0;j<tmpList.length-i-1;j++) {
                // 알파벳이 나온 숫자가 더 크면 스왑
                if(max[tmpList[j]]<max[tmpList[j+1]]) {
                    int tmp = tmpList[j+1];
                    tmpList[j+1] = tmpList[j];
                    tmpList[j] =tmp;
                } else if(max[tmpList[j]]==max[tmpList[j+1]]) {
                	if(num[tmpList[j]][max[tmpList[j]]]<num[tmpList[j+1]][max[tmpList[j+1]]]) {
                		int tmp = tmpList[j+1];
                        tmpList[j+1] = tmpList[j];
                        tmpList[j] =tmp;
                	} else if(num[tmpList[j]][max[tmpList[j]]]==num[tmpList[j+1]][max[tmpList[j+1]]]){
                		if(tmpList[j]>tmpList[j+1]) {
                			int tmp = tmpList[j+1];
                            tmpList[j+1] = tmpList[j];
                            tmpList[j] =tmp;
                		}
                		
                	}
                }
            }
        }
        return tmpList;
    }
}