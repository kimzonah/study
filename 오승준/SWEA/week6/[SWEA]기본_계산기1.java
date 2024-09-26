import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.StringTokenizer;
 
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //[S/W 문제해결 기본] 6일차 - 계산기1
        //문자열 K, K의 길이 N,후위표시 문자열postfix, Stack<integer>,Stack<Character> 선언
        String K;
        int N;
        Stack<Character> stack;
        Stack<Integer> sum;
        String postfix;
         
        //10번의 TC 반복
        for(int i=1;i<=10;i++) {
            // K,N,stack,postfix 초기화 및 입력
            N = Integer.parseInt(br.readLine());
            K = br.readLine();
            postfix ="";
            stack = new Stack<>();
            sum = new Stack<>();
            for(int j=0;j<N;j++) {
                //문자열의 길이만큼 반복문 실행
                if(K.charAt(j)>='0' && K.charAt(j)<='9') {
                    // K의 i번째 문자가 숫자면 postfix에 추가
                    postfix += K.charAt(j);
                } else {
                    // '+'면 stack<Character>에 추가('+'밖에 없어서 나중에 한꺼번에 더해주면 됨)
                    stack.add(K.charAt(j));
                }
                // 반복문이 끝나면 stack에 있던 '+'을 postfix에 넣어준다
            }
            while(!stack.isEmpty()) {
                postfix += stack.pop();
            }
            for(int j=0;j<postfix.length();j++) {
                //postfix의 길이만큼 반복문 실행
                if(postfix.charAt(j)>='0' && postfix.charAt(j)<='9') {
                    //K의 i번째 문자가 0~9일경우 push
                     
                    sum.add(postfix.charAt(j)-'0');
                } else {
                    //'+'일 경우 pop 두번 후 연산
                    int x = sum.pop();
                    int y = sum.pop();
                    // 연산된 숫자는 다시 push
                    sum.add(x+y);
                }
                // 반복이 끝난 후 stack에 남아있는 연산 값 출력
            }
            System.out.println("#"+i+" "+sum.pop());
             
        }
         
 
    }
}