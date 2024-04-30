import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

// 1339번 - 단어 수학
class Main {
	
	// 실패 알고리즘
	// 반례 , A가 9일 때보다 B가 9일 때 더 큰 값이 된다
	/*10
	ABB
	BB
	BB
	BB
	BB
	BB
	BB
	BB
	BB
	BB
	*/
	
    static int N;
    static int maxLen, ans;
    // 지정된 숫자의 알파벳 저장
    static int[] transformedAlp = new int[26];
    // 문자열에서 알파벳이 나온 개수 저장
    static int[] alpNum = new int[26];
    // 문자열에서 알파벳이 등장하는 길이 저장
    static ArrayList<Integer>[] length = new ArrayList[10];
    // 문자가 알파벳으로 변환되었는지를 체크
    static boolean[] checked = new boolean[26];
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        maxLen = 0;
        ans = 0;
        // 길이 리스트 생성
        for(int i=0;i<10;i++) {
            length[i] = new ArrayList<>();
        }
        
        for(int i=0;i<N;i++) {
            String str = br.readLine();
            // 문자열 중에 가장 큰 값을 저장
            if(maxLen<str.length()) maxLen=str.length();
            for(int j=0;j<str.length();j++) {
                // 알파벳을 숫자로 바꾸고
                int alp = str.charAt(str.length()-1-j)-'A';
                // 문자열의 몇번째 길이에 어떤 알파벳이 위치했는지 저장
                length[j].add(alp);
                // 알파벳이 몇번 나왔는지 저장
                alpNum[alp]++;
            }
        }
        // 알파벳에 숫자를 지정한다
        distributeNum();
        // 지정되었으면 얻은 값들을 숫자로 변환하여 반환한다
        calculateSum();
        
        bw.write(ans+"");
        bw.flush();
        bw.close();
        
        
    }

    private static void calculateSum() {
        for(int i=maxLen;i>=0;i--) {
            for(int j=0;j<length[i].size();j++) {
                ans += Math.pow(10, i)*transformedAlp[length[i].get(j)];
            }
        }
    }

    private static void distributeNum() {
        int Num = 9;
        // 최대길이에서 한칸씩 내려가면서 알파벳에 숫자 지정
        // 해당 길이의 알파벳이 2개 이상이면
        // 알파벳 중 가장 나온 횟수가 많은 값부터 숫자 지정
        for(int i=maxLen-1;i>=0;i--) {
            if(length[i].size()==1) {
            	if(!checked[length[i].get(0)]) {
            		// 알파벳에 숫자가 지정되면 boolean 배열을 true 처리 하고 transformedAlp값에 알파벳의 숫자를 넣어준다
            		transformedAlp[length[i].get(0)]=Num--;
            		checked[length[i].get(0)]=true;
            	}
            } else {
                // 해당 길이를 가진 문자열을 리스트에 저장하고 정렬
                int[] tmpList =  new int[length[i].size()];
                for(int j=0;j<length[i].size();j++) {
                    tmpList[j] = length[i].get(j);
                }
                bubblesort(tmpList);
                // 정렬된 순서대로 숫자 부여
                for(int j=0;j<length[i].size();j++) {
                    if(!checked[tmpList[j]]) {
                    	transformedAlp[tmpList[j]]=Num--; 
                    	checked[tmpList[j]] = true;
                    }
                }
                
            }
        }
    }

    private static void bubblesort(int[] arr) {
        for(int i=0;i<arr.length-1;i++) {
            for(int j=0;j<arr.length-i-1;j++) {
                // 알파벳이 나온 숫자가 더 크면 스왑
                if(alpNum[arr[j]]<alpNum[arr[j+1]]) {
                    int tmp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] =tmp;
                }
            }
        }
    }

}