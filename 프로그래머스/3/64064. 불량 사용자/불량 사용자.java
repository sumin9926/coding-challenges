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
            List<String> list = new ArrayList<>(bannedUsers);
            Collections.sort(list);
            String key = String.join(",",list);
            results.add(key);
            return;
        }else{
            for(int i=0; i<userIds.length; i++){
                if(!isChecked[i] && isBanned(userIds[i], bannedIds[idx])){
                    isChecked[i]=true;
                    bannedUsers.offerLast(userIds[i]);
                    dfs(idx+1, userIds, bannedIds);
                    isChecked[i]=false;
                    bannedUsers.pollLast();
                }
            }
        }
    }
    
    static boolean[] isChecked;
    static Set<String> results = new HashSet<>();
    static Deque<String> bannedUsers = new ArrayDeque<>();
    
    public int solution(String[] userIds, String[] bannedIds) {
        isChecked = new boolean[userIds.length];
        
        dfs(0, userIds, bannedIds);
        
        return results.size();
    }
}