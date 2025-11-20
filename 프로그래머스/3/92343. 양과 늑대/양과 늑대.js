function solution(info, edges) {
    let answer = 0;
    
    // 각 노드별 방문 가능한 후보를 2차원 배열로 표현
    let graph = Array.from({length: info.length}, ()=>[]);
    for(let [a,b] of edges){
        graph[a].push(b);
    }
    
    function dfs(sheep, wolf, candidates){
        answer = Math.max(answer, sheep);
        
        // 현재 노드에서부터 탐색 가능한 노드들 모두 탐색
        for(let i=0; i<candidates.length; i++){
            let nextNode = candidates[i]; // 다음 방문할 노드 번호
            let newSheep = sheep+(info[candidates[i]]===0?1:0);
            let newWolf = wolf+(info[candidates[i]]===1?1:0);
            
            if(newSheep<=newWolf) continue; // 다음 노드 방문시 양이 모두 잡아먹히면 해당 경로 폐기
            
            // 이미 방문한 후보 제외, 새로운 후보 추가
            let newCandidates = candidates.slice();
            newCandidates.splice(i,1);
            
            for(let child of graph[nextNode]){
                newCandidates.push(child);
            }
            
            dfs(newSheep, newWolf, newCandidates);
        }
    }
  
    dfs(1, 0, graph[0].slice());
    
    return answer;
}

// 내가 이전에 방문한 노드와 현재 방문한 노드를 기준으로 새로 방문 가능한 노드의 목록을 리스트업 한다.
// 만약에 방문 중간에 양<=늑대가 되면 즉시 해당 경로는 폐기한다.
// 0번 노드부터 시작하고, 양은 1마리부터 시작한다.

