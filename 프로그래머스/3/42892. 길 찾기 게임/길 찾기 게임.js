class Node {
    constructor(node, co){
        this.node = node; //번호
        this.co = co; //좌표
        this.left = null;
        this.right = null;
    }
}

class Tree{
    constructor(){
        this.root = null;
    }
    
    insertNode(node, co){
        const newNode = new Node(node, co);
        if(this.root === null){ //root 노드 지정
            this.root = newNode;
            return this;
        }
        let current = this.root; //root 노드부터 시작
        while(current){
            if(current.co[0]>co[0]){
                if(current.left === null) { 
                    current.left = newNode;
                    break;
                }else{
                    //이미 왼쪽 노드가 있으면 해당 왼쪽 노드를 부모 노드로 해서 탐색
                    current = current.left; 
                }
            }
            else{
                if(current.right === null) { 
                    current.right = newNode;
                    break;
                }else{
                    current = current.right; 
                }
            }
        }
    }
}

function solution(nodeinfo) {
    let answer = [[],[]];
    const nodeObj = {};
    // 각 노드별 번호 저장. key=좌표, value=노드 번호
    nodeinfo.forEach((e, idx)=>{nodeObj[e[0]+","+e[1]]=idx+1}); 
    // y기준 내림차순, x기준 오름차순 정렬
    nodeinfo.sort((a,b)=>{
        if(a[1]!==b[1]) return b[1]-a[1];
        else return a[0]-b[0];
    });
  
    
    // 이진트리 만들기
    let tree = new Tree();
    for(let i=0; i<nodeinfo.length; i++){
        tree.insertNode(nodeObj[nodeinfo[i][0]+","+nodeinfo[i][1]],nodeinfo[i]);
    }
    
    // 전위 순회 -> answer[0]에 push
    function preorder(current){
        answer[0].push(current.node);
        if(current.left) preorder(current.left);
        if(current.right) preorder(current.right);
    }
    
    // 후위 순회 -> answer[1]에 push
    function postorder(current){
        if(current.left) postorder(current.left);
        if(current.right) postorder(current.right);
        answer[1].push(current.node);
    }
    
    preorder(tree.root);
    postorder(tree.root);
    
    return answer;
}