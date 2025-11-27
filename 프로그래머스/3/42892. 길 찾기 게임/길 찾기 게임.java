import java.util.*;

class Solution {
    static class Node{
        int nodeNum; //노드 번호
        int[] co; //좌표
        Node leftNode;
        Node rightNode;

        Node(int nodeNum, int[] co){
            this.nodeNum=nodeNum;
            this.co=co;
        }
    }

    static class Tree{
        Node root;

        Tree(){}

        void insertNode(int nodeNum, int[] co){
            Node newNode = new Node(nodeNum, co);
            if(this.root==null){
                this.root=newNode;
                return;
            }
            Node current = this.root;
            while(current!=null){
                if(current.co[0]>co[0]){ // 부모노드 기준 왼쪽 노드일 경우
                    if(current.leftNode==null){
                        current.leftNode=newNode;
                        break;
                    }else{
                        current = current.leftNode;
                    }
                }else{ //부모노드 기준 오른쪽 노드일 경우
                    if(current.rightNode==null){
                        current.rightNode = newNode;
                        break;
                    }else{
                        current = current.rightNode;
                    }
                }
            }
        }
    }
    static int preidx, postidx, nodeCnt;
    static int[][] answer;
    
    public void preorder(Node current){ //전위 순회
        if(preidx>=nodeCnt) return;
        answer[0][preidx++] = current.nodeNum;
        if(current.leftNode!=null) preorder(current.leftNode);
        if(current.rightNode!=null) preorder(current.rightNode);
    }
    
    public void postorder(Node current){// 후위 순회
        if(postidx>=nodeCnt) return;
        if(current.leftNode!=null) postorder(current.leftNode);
        if(current.rightNode!=null) postorder(current.rightNode);
        answer[1][postidx++] = current.nodeNum;
    }
    
    public int[][] solution(int[][] nodeinfo) {
        nodeCnt = nodeinfo.length;
        answer = new int[2][nodeCnt];
        Map<String, Integer> nodeMap = new HashMap<>();
        for(int i=0; i<nodeCnt; i++){
           nodeMap.put(nodeinfo[i][0]+","+nodeinfo[i][1], i+1); //key: 좌표, value: 노드 번호
        }
        
        Arrays.sort(nodeinfo, (a, b)->{
           if(a[1]!=b[1]) return b[1]-a[1]; //y축 기준 내림차순 정렬
            return a[0]-b[0]; //x축 기준 오름차순 정렬
        });
        
        Tree tree = new Tree();
        for(int i=0; i<nodeCnt; i++){
            tree.insertNode(nodeMap.get(nodeinfo[i][0]+","+nodeinfo[i][1]), nodeinfo[i].clone());
        }
        
        preidx=0;
        postidx=0;
        
        preorder(tree.root);
        postorder(tree.root);
        
        return answer;
    }
}

