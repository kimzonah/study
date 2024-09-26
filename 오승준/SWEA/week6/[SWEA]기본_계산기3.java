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
        // [S/W 문제해결 기본] 6일차 - 계산기3
 
        // 케이스 별 길이 N, 케이스 문자열 변수 K, stack collection 생성
        // 후위 표기법으로 정리하는 string 변수 postfix 생성
        // 연산자 우선순위 저장을 위한 Map 생성, 우선도는 *,+,) 순이다
        int N;
        String K;
        String postFix;
        Stack<Character> stack;
        Map<Character, Integer> map = new HashMap<>();
        map.put('+',1);
        map.put('*',2);
        map.put('(',0);
         
        // 10번의 케이스 반복문 생성
        for (int i = 1; i <= 10; i++) {
            // N,K를 입력받고, stack,postfix 초기화
            stack = new Stack<Character>();
            postFix = "";
            N = Integer.parseInt(br.readLine());
            K = br.readLine();
            // N만큼 반복하는 반복문 생성, i는 K의 i번째 문자를 stack에 추가할지 postfix에 받을지 선택
            for (int j = 0; j < N; j++) {
                if(K.charAt(j)=='(') {
                    // '(' 가 입력되면 무조건 우선 push 
                    stack.add(K.charAt(j));
                // 피연산자는 postfix에 입력, 연산자는 stack에 넣는다
                } else if (K.charAt(j) >= '0' && K.charAt(j) <= '9') {
                    postFix += K.charAt(j);
                // '(' 입력 시 ')'가 나올 때까지 pop을 수행한다
                } else if(K.charAt(j)==')') {
                    while(stack.peek() !='(') {
                        postFix += stack.pop();
                    }
                    stack.pop();
                } else {
                    // stack은 비어있을 경우 push
                    if(stack.isEmpty()) {
                        stack.add(K.charAt(j));
                    } else {
                        // 비어있지 않을 경우, 연산자 순위가 낮은 인자가 top에 있을 때까지 pop 및 postfix에 입력
                        while(!stack.isEmpty()&&map.get(stack.peek())>map.get(K.charAt(j))){
                            postFix += stack.pop();
                        }
                        // top이 들어오려는 인자보다 우선순위가 낮으면 push
                        stack.add(K.charAt(j));
                    }
                }
            }
            // 연산을 위해 정수값을 받는 stack sum을 새로 생성한
            // 생성된 postfix의 길이만큼의 반복문을 수행하여 연산을 시작한다
            Stack<Integer> sum = new Stack<>();
            for(int j=0;j<postFix.length();j++) {
                // '0'~'9'까지의 피연산자는 push
                if(postFix.charAt(j)>='0'&& postFix.charAt(j) <= '9') {
                    sum.add(postFix.charAt(j)-'0');
                } else if (postFix.charAt(j)=='+'){
                    // +,*의 연산자는 2번의 pop을 통해 인자를 두개 받아낸 다음 연산을 수행한다
                    int x = sum.pop();
                    int y = sum.pop();
                    // 반복문동안 연산된 항목은 다시 push를 통해 sum에 넣는다
                    sum.add(x +y);
                } else {
                    int x = sum.pop();
                    int y = sum.pop();
 
                    sum.add(x*y);
                }
            }
            // 반복문이 끝나고 sum에 남아있는 1개의 인자(연산결과)를 출력한다
            System.out.println("#" + i+" "+sum.pop());
        }
    }
}