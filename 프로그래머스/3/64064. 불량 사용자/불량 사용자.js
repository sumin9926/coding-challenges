function solution(userIds, bannedIds) {
    let isChecked = Array(userIds.length).fill(0);
    let result = new Set();
    
    function isBanned(userId, bannedId){
        if(userId.length!==bannedId.length) return false;
        for(let i=0; i<userId.length; i++){
            if(bannedId[i]==='*') continue;
            if(bannedId[i]!==userId[i]) return false;
        }
        return true;
    }
    
    function dfs(idx){
        if(idx==bannedIds.length){
            result.add(isChecked.join(""));
            return;
        }
        for(let i=0; i<userIds.length; i++){
            if(!isChecked[i] && isBanned(userIds[i], bannedIds[idx])){
                isChecked[i]=1;
                dfs(idx+1);
                isChecked[i]=0;
            }
        }
    }
    
    dfs(0);
    
    return result.size;
}