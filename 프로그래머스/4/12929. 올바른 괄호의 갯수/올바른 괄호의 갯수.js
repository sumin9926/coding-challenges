function solution(n) {
    let answer = new Array(n+1).fill(0);
    answer[0]=1;
    answer[1]=1;
    
    for(let i=2; i<n+1; i++){
        for(let a=0; a<=i-1; a++){
            let b=i-1-a;
            answer[i]+=answer[a]*answer[b];
        }
    }
    
    return answer[n];
}