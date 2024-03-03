package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * boj_1991_트리순회
 * 2초 128mb
 *
 * 문제
 * 1. 전위, 중위, 후위 순회하는 결과를 출력하라
 *
 * 문풀
 * 1. 트리 표현
 *    - 데이터 저장 필드, 왼쪽 자식 노드, 오른쪽 자식 노트 => 3개의 필드
 */

public class BOJ_1991_트리순회 {
    static BufferedReader br;
    static StringTokenizer st;

    static int nodes; //노드수
    static Node root; //초기 root

    public static void main(String[] args) throws IOException, NumberFormatException {
        br = new BufferedReader(new InputStreamReader(System.in));

        nodes = Integer.parseInt(br.readLine().trim());

        for(int idx=0; idx<nodes; idx++){
            st = new StringTokenizer(br.readLine().trim());
            char data = (st.nextToken()).charAt(0);
            char leftData = (st.nextToken()).charAt(0);
            char rightData = (st.nextToken()).charAt(0);

            createNode(data, leftData, rightData);
        }
        
        preOrder(root);
        System.out.println();
        inOrder(root);
        System.out.println();
        postOrder(root);
    }

    //값을 추가하는 createNode() 메서드
    //트리가 생성되기 전 초기 root값은 null
    //트리 생성을 통해 루트 노드 객체가 생성되고, 왼쪽-오른쪽 값이 있느냐에 따라 좌우노드객체 생성
    //루트 노드 생성 이후 노드는 어느 위치에 추가될지 판별해야 하기 때문에 searchNode() 메서드 통해 탐색
    public static void createNode(char data, char leftData, char rightData) {
        if(root == null) { //초기 상태 - 루트 노드 생성
            root = new Node(data);

            //좌우 노드가 있는 경우, 노드 생성
            if(leftData != '.') {
                root.left = new Node(leftData);
            }

            if(rightData != '.') {
                root.right = new Node(rightData);
            }
        } else {
            //초기 상태가 아니라면, 루트 노드 생성 이후 만들어진 노드 중 어떤건지 찾아야함
            searchNode(root, data, leftData, rightData);
        }
    }

    //값을 어느 위치에 추가할 것인지 찾는 searchNode() 메서드
    //해당 노드가 있다면, 그 노드의 좌우 노드 객체로 생성
    public static void searchNode(Node node, char data, char leftData, char rightData) {
        if(node == null) { //도착한 노드가 null이면 재귀 종료 - 찾을 노드 x
            return;
        } else if(node.data == data) { //해당 노드 찾았다면
            if(leftData != '.') {
                node.left = new Node(leftData);
            }

            if(rightData != '.') {
                node.right = new Node(rightData);
            }
        } else { //아직 찾지 못하고 탐색할 노드가 남아있다면
            searchNode(node.left, data, leftData, rightData); //왼쪽 재귀 탐색
            searchNode(node.right, data, leftData, rightData); //오른쪽 재귀 탐색
        }
    }

    //전위순회 : root -> left -> right
    public static void preOrder(Node node){
        if(node != null) {
            System.out.print(node.data);
            if(node.left != null) preOrder(node.left);
            if(node.right != null) preOrder(node.right);
        }
    }

    //중위순회 : left -> root -> right
    public static void inOrder(Node node){
        if(node != null) {
            if(node.left != null) inOrder(node.left);
            System.out.print(node.data);
            if(node.right != null) inOrder(node.right);
        }
    }

    //후위순회 : left -> right -> root
    public static void postOrder(Node node){
        if(node != null) {
            if(node.left != null) postOrder(node.left);
            if(node.right != null) postOrder(node.right);
            System.out.print(node.data);
        }
    }

    //트리의 노드 정보를 저장할 클래스
    public static class Node {
        char data; //노드값
        Node left; //왼쪽 자식 노드
        Node right; //오른쪽 자식 노드

        Node(char data) {
            this.data = data;
        }
    }
}
