function solution(n, t, m, timetable) {
    // 크루 대기 시간 오름차순 정렬
    let timetables = timetable.map((e)=>{
        let time = parseInt(e.replace(":", ""), 10);
        return Math.floor(time/100)*60+time%100;
    }).sort((a,b)=>a-b);
    
    // 셔틀 시간
    let busTimes = [];
    for(let i=0; i<n; i++){
        busTimes.push(540+t*i);
    }
    
    // 각 셔틀에 크루들 태우기
    let lastBoardTime = 0;
    let isfull = false;
    for(busTime of busTimes){
        let cnt = 0;
        isfull = false;
        
        while(timetables.length>0){
            let arrivalTime = timetables.shift();
            if(arrivalTime>busTime) {
                timetables.unshift(arrivalTime);
                break;
            }
            cnt++;
            if(cnt===m){
                lastBoardTime = arrivalTime;
                isfull = true;
                break;
            }
            
        }
    }
    
    function stringFormat(time){
        let hour = Math.floor((time)/60);
        let min = (time)%60;
        return `${String(hour).padStart(2, "0")}:${String(min).padStart(2,"0")}`;
    }
    
    // 결론
    // 마지막 셔틀 만차
        //마지막 크루보다 1분 일찍 도착
    if(isfull){
        return stringFormat(lastBoardTime-1);
    }
    // 만차x
        // 마지막 셔틀 시간에 도착
    return stringFormat(busTimes[n-1]);
    
    
}