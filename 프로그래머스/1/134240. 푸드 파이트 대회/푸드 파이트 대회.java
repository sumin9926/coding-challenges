class Solution {
    public String solution(int[] food) {
        StringBuilder sb=new StringBuilder();
        StringBuilder sb2=new StringBuilder();

        for(int i=1; i<food.length; i++){
            int cnt=food[i]/2;
            for(int j=0; j<cnt; j++){
                sb.append(i);
            }
        }
        sb2.append(sb).append("0").append(sb.reverse());

        return sb2.toString();
    }
}