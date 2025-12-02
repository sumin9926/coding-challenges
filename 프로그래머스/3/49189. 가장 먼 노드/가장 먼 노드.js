function solution(n, edge) {
    let answer = 0, max = 0;
    let graph = Array.from(Array(n+1), ()=>[]);
    let nodes = new Array(n+1).fill(-1);
    let queue = [];
    
    // 그래프 정보 채우기
    for(let row of edge){
        let v1 = row[0], v2=row[1];
        graph[v1].push(v2);
        graph[v2].push(v1);
    }
    
    // 1번 노드 - 각 노드 사이의 간선 개수 구하기
    queue.push(1);
    nodes[1]=0;
    while(queue.length>0){
        let node = queue.shift();
        for(let v of graph[node]){
            if(nodes[v]===-1){
                nodes[v] = nodes[node]+1;
                if(max<nodes[v]){
                    max = nodes[v];
                    answer=0;
                }
                answer++;
                queue.push(v);
            }
        }
    }
    
    return answer;
}