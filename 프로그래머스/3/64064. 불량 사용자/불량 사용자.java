import java.util.*;

class Solution {
    
    public boolean isBanned(String userId, String bannedId){
        if(userId.length()!=bannedId.length()) return false;
        for(int i=0; i<bannedId.length(); i++){
            if(bannedId.charAt(i)!='*'){
                if(bannedId.charAt(i)!=userId.charAt(i)) return false;
            }
        }
        return true;
    }
    
    public void dfs(int idx, String[] userIds, String[] bannedIds){
        if(idx==bannedIds.length){
            String key = Arrays.toString(isChecked);
            results.add(key);
            return;
        }else{
            for(int i=0; i<userIds.length; i++){
                if(!isChecked[i] && isBanned(userIds[i], bannedIds[idx])){
                    isChecked[i]=true;
                    dfs(idx+1, userIds, bannedIds);
                    isChecked[i]=false;
                }
            }
        }
    }
    
    static boolean[] isChecked;
    static Set<String> results = new HashSet<>();
    
    public int solution(String[] userIds, String[] bannedIds) {
        isChecked = new boolean[userIds.length];
        
        dfs(0, userIds, bannedIds);
        
        return results.size();
    }
}