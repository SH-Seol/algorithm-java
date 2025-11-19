package programmers.implement.findroad;

import java.util.*;

class Solution {
    int[][] answer;
    int preNum = 0;
    int postNum = 0;
    public int[][] solution(int[][] nodeinfo) {
        int[][] arr = new int[nodeinfo.length][3];
        for(int i = 1; i <= nodeinfo.length; i++){
            arr[i - 1][0] = i;
            arr[i - 1][1] = nodeinfo[i - 1][0];
            arr[i - 1][2] = nodeinfo[i - 1][1];
        }
        Arrays.sort(arr, (a, b) -> b[2] - a[2]);
        Node root = new Node(arr[0][0], arr[0][1], arr[0][2]);

        for(int i = 1; i < arr.length; i++){
            putNode(root, new Node(arr[i][0], arr[i][1], arr[i][2]));
        }
        answer = new int[2][nodeinfo.length];
        preorder(root);
        postorder(root);
        return answer;
    }
    public void putNode(Node root, Node node){
        if(root.x < node.x){
            if(root.getRight() == null){
                root.setRight(node);
            }
            else{
                putNode(root.getRight(), node);
            }
        }
        else{
            if(root.getLeft() == null){
                root.setLeft(node);
            }
            else{
                putNode(root.getLeft(), node);
            }
        }
    }
    //predorder
    public void preorder(Node node){
        answer[0][preNum] = node.num;
        preNum++;
        if(node.getLeft() == null && node.getRight() == null){
            return;
        }
        if(node.getLeft() != null){
            preorder(node.getLeft());
        }
        if(node.getRight() != null){
            preorder(node.getRight());
        }

    }

    //postorder
    public void postorder(Node node){
        if(node.getLeft() != null){
            postorder(node.getLeft());
        }
        if(node.getRight() != null){
            postorder(node.getRight());
        }
        answer[1][postNum] = node.num;
        postNum++;
    }
}
class Node{
    int num;
    int x;
    int y;
    Node left;
    Node right;

    public Node(int num, int x, int y){
        this.num = num;
        this.x = x;
        this.y = y;
        this.left = null;
        this.right = null;
    }

    public Node getRight(){
        return this.right;
    }
    public Node getLeft(){
        return this.left;
    }
    public void setLeft(Node left){
        if(this.left == null){
            this.left = left;
        }
    }
    public void setRight(Node right){
        if(this.right == null){
            this.right = right;
        }
    }
}