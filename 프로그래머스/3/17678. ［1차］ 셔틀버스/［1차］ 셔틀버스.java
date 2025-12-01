import java.util.*;

class Solution {
    
    static class Bus implements Comparable<Bus>{
        int time;
        int lastArrivalTime;
        boolean isfull=false;
        
        Bus(int time){
            this.time=time;
        }
        
        @Override
        public int compareTo(Bus o){
            return this.time - o.time;
        }
        
    }
    
    public int calTime(int idx, int min){
        int total = 540+min*idx;
        int result = total/60*100+total%60;
        return result;
    }
    
    
    public int subTime(int time){
        int total = (time%100+time/100*60)-1;
        int result = total/60*100+total%60;
        return result;
    }
    
    public String timeToString(int time){
        int hour = time/100;
        int min = time%100;
        return String.format("%02d:%02d", hour, min);
    }
    
    public String solution(int n, int t, int m, String[] timetable) {
        Bus[] busTimes = new Bus[n];
        int[] arrivalTimes = new int[timetable.length];
        
        for(int i=0; i<timetable.length; i++){
            int arrivalTime = Integer.parseInt(timetable[i].replace(":",""));
            arrivalTimes[i] = arrivalTime;
        }
        
        Arrays.sort(arrivalTimes);
        
        for(int i=0; i<n; i++){
            int busTime = calTime(i, t);
            busTimes[i] = new Bus(busTime);
        }
        
        int j=0;
        for(int i=0; i<n; i++){
            int busTime = busTimes[i].time;
            int cnt=0;
            
            for( ;j<timetable.length; j++){
                int arrivalTime = arrivalTimes[j];
                if(arrivalTime>busTime) break;
                cnt++;
                busTimes[i].lastArrivalTime=arrivalTime;
                if(cnt==m){
                    busTimes[i].isfull = true;
                    j++;
                    break;
                }
            }
        }
        
        Bus lastBus = busTimes[n-1];
        if(lastBus.isfull){
          return timeToString(subTime(lastBus.lastArrivalTime));
        }
        
        return timeToString(lastBus.time);
    }
}