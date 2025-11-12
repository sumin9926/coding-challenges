function solution(schedules, timelogs, startday) {
    let answer = 0, people = schedules.length;
    
    //마지노선 시간
    let deadline = (x) => {
        let t = x+10;
        return (t%100>=60) ? t+40 : t;
    }
    
    const deadlines = schedules.map(deadline);
    
    // timelogs 토대로 제 시간에 출근했는지 파악
    for(let p = 0; p<people ; p++){ //각 사람별로 체크
       let flag = true;
        
        for(let i=0; i<7; i++){
            let day = (startday+i-1)%7+1;
            if(day===6||day===7) continue;
            if(timelogs[p][i]>deadlines[p]){
                flag=false;
                break;
            }
        }
        
        if(flag) answer++;
    }
        
    
    return answer;
}
