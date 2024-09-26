import java.util.Scanner;
import java.util.Stack;
 
class Node{
    String data;
    Node left;
    Node right;
     
    Node(){
    }
     
    Node(String data){
        this.data = data;
    }
}
 
public class Solution {
    // 정점 N 선언
    static int N;
    static String a;
    static String b;
    static String c;
    static String d;
     
    // node의 배열 nodes 선언
    static Node[] nodes;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // TC 10번 반복
        for(int T=1;T<=10;T++) {
            // N 입력
            N =  sc.nextInt();
            // nodes 생성
            nodes = new Node[N+1];
            for(int i=0;i<=N;i++) {
                nodes[i] = new Node();
            }
            // N번 만큼 데이터 입력을 위한 반복문
            for(int i=1;i<=N;i++) {
                // 순서에 따라 index가 부여되니까 첫번째수자는 그냥 받기만
                a = sc.next();
                b = sc.next();
 
                // 2번째 문자가 사칙연산일 경우
                if(b.equals("+")||b.equals("-")||b.equals("*")||b.equals("/")) {
                    // 해당 node의 데이터에 해당 사칙연산 입력
                    nodes[i].data = b;
                    // 뒤에 오는 두 숫자에 대해 각 left,right로 연결
                    nodes[i].left = nodes[Integer.parseInt(sc.next())];
                     
                    nodes[i].right = nodes[Integer.parseInt(sc.next())];
                    // 2번째 문자가 숫자일 경우
                } else {
                    // 해당 node의 데이터에 숫자 입력
                    nodes[i].data = b;
                }
                //전위 순회 실행
            }
            preorder(nodes[1]);
             
            // TC와 계산 값 출력
            System.out.println("#"+T+" "+nodes[1].data);
             
        }
    }
    // 전위 순회
    static void preorder(Node node) {
        if(node == null) {
            return;
        }
//      System.out.println(node.data);
        // 자식 노드가 사칙 연산일경우 재귀 순회
        if(node.left.data.equals("+")||node.left.data.equals("-")||node.left.data.equals("/")||node.left.data.equals("*")) {
            preorder(node.left);
        }
        if(node.right.data.equals("+")||node.right.data.equals("-")||node.right.data.equals("/")||node.right.data.equals("*")) {
            preorder(node.right);
        } 
        calc(node);
    }
     
    // 부모 노드에 따라 자식 노드에 대한 사칙 연산 진행
    static void calc(Node node) {
        if(node.data.equals("+")) {
            node.data = (Integer.parseInt(node.left.data)+Integer.parseInt(node.right.data))+"";
        } else if(node.data.equals("-")) {
            node.data = (Integer.parseInt(node.left.data)-Integer.parseInt(node.right.data))+"";
        } else if(node.data.equals("/")) {
            node.data = (Integer.parseInt(node.left.data)/Integer.parseInt(node.right.data))+"";
        } else {
            node.data = (Integer.parseInt(node.left.data)*Integer.parseInt(node.right.data))+"";
        }
    }
}