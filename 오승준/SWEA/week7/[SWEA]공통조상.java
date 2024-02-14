// 노드 클래스 선언
// 단순 연결, left/right와 int data 선언
 
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
 
class Node {
    int data;
    Node left;
    Node right;
     
    Node(){
    }
     
    Node(int data){
        this.data = data;
    }
}
 
 
public class Solution {
    // TC, V, E변수 선언
    static int V;
    static int E;
    static int num1;
    static int num2;
    // 노드의 리스트 nodes 선언
    static Node[] nodes;
    static boolean[][] arr;
     
    static List<Integer> num1P;
    static List<Integer> num2P;
    static int cnt=0;
    static List<Integer> parents = new ArrayList<>();
     
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int TC = sc.nextInt();
         
        for(int T=1;T<=TC;T++) {
            // V, E 입력
            V = sc.nextInt();
            E = sc.nextInt();
            num1 = sc.nextInt();
            num2 = sc.nextInt();
            nodes = new Node[V+1];
             
            for (int i = 1; i <= V; i++) {
                nodes[i] = new Node();
                nodes[i].data = i;
            }
            // 간선을 표현하는 2차배열 생성(길이 : V+1*V+1)
            arr = new boolean[V+1][V+1];
            // E의 수 만큼 반복문 실행
            for(int i=0;i<E;i++) {
                // parent와 child 선언, 먼저입력이 부모, 나중이 자식이다
                int parent = sc.nextInt();
                int child = sc.nextInt();
                 
                // parent 노드의 왼쪽이 비어있으면 child 추가, 아니면 오른쪽에
                if (nodes[parent].left == null) {
                    nodes[parent].left = nodes[child];
                } else {
                    nodes[parent].right = nodes[child];
                }
                // arr[부모][자식]의 간선이 있을경우 true로 표시
                arr[parent][child] = true;
            }
            // 두 정점에 대한 메서드가 완료된 후 리스트에 추가된 인덱스를 순서대로 비교한다(오름차순 후)
            parents = new ArrayList<>();
            num1P = findP(num1);
            parents = new ArrayList<>();
            num2P = findP(num2);
 
            int idx = 1 ;
            for(int i=Math.min(num1P.size(), num2P.size())-1;i>0;i--) {
                if(num1P.contains(num2P.get(i))) {
                    idx = num2P.get(i);
                }
            }
            cnt = 0;
            preorder(nodes[idx]);
            System.out.println("#"+T+" "+idx+" "+cnt);
        }
         
    }
    // 부모를 찾는 메서드 생성
    public static List<Integer> findP(int idx) {
        // arr[i][자식]에서 i=true인 idx 찾는다
        for(int i=1;i<=V;i++) {
            if(arr[i][idx]==true) {
//              System.out.println(i+" "+idx);
                // 인덱스를 찾을 경우 그 인덱스를 리스트에 추가하고 부모에 대한 메서드 재귀 실행
                parents.add(i);
                findP(i);
            }
        }
        return parents;
    }
     
    // 공통 조상을 VLR 
    static void preorder(Node node) { 
        // VLR하면서 진행되는 항목에 대한 count 세기
        // VLR완료 후 count 출력
        if(node == null) {
            return;
        }
        cnt++;
        // 왼쪽 자식
        preorder(node.left);
        // 오른쪽 자식
        preorder(node.right);
    }
     
}