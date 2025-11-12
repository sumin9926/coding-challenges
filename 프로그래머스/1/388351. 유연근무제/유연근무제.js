function solution(schedules, timelogs, startday) {
    let answer = 0, people = schedules.length;
    check=Array.from({length: people}, ()=>Array(7).fill(0));
    
    //마지노선 시간
    let endTime = [];
    for(let x of schedules){
        let minutes = x%100+10;
        if(minutes>=60){
            endTime.push(Math.floor(x/100)*100+100+(minutes-60));
        }else{
            endTime.push(x+10);
        }
    }
    
    for(let i=0; i<7; i++){ //7일 돌리기

        if(startday>7) startday-=7; //월요일로 돌려놓기
    
        // timelogs 토대로 제 시간에 출근했는지 파악
        for(let p = 0; p<people ; p++){ //각 사람별로 체크
            if(startday===6||startday===7){ //주말[6,7]은 무조건 1
                check[p][i] = 1;
            }else if(timelogs[p][i]<= endTime[p] ){ //평일 제시간에 출근
                check[p][i] = 1;
            }
        }

        startday++;
    }
    
    // 전체 check 의 일차원 배열들 중 전체가 1인 일차원 배열의 개수 확인
    for(let i=0; i<people; i++){ //행
        let flag=true;
        for(let j=0; j<7; j++){ //열
            if(check[i][j]===0){
                flag=false;
                break;
            }
        }
        if(flag) answer++;
    }
    
    return answer;
}

/*
//새로운 2차원 배열 check=Array.from({length: schedules.length}, ()=>Array(7).fill(0));
//사람 수 : let person = schedules.length;

// for(let i=0; i<7; i++){ //7일 돌리기

    if(startday>7) startday-=7; //월요일로 돌려놓기
    
    // timelogs 토대로 제 시간에 출근했는지 파악
    for(let p = 0; p<person ; p++){ //각 사람별로 체크
        if(startday===6||startday===7){ //주말[6,7]은 무조건 1
            check[p][i] = 1;
        }else if(timelogs[p][i]< endtime[p] ){ //평일 제시간에 출근
            check[p][i] = 1;
        }
    }

    startday++;
    
}

// 전체 check 의 일차원 배열들 중 전체가 1인 일차원 배열의 개수 확인
for(let i=0; i<person; i++){ //행
    let flag=true;
    for(let j=0; j<7; j++){ //열
        if(check[i][j]===0){
            flag=false;
            break;
        }
    }
    if(flag) answer++;
}




7일 동안의 출근 시간과 인정 시간을 비교
2차원 배열을 새로 만들어서(초기값 0) 인정 시간은 1로 표시(주말[6,7]은 무조건 1),
전체가 1인 1차원 배열을 개수를 세서 상품을 받을 직원 수 구하기.


//마지노선 시간
let endTime = [];
for(let x of schedules){
    let minutes = x%100+10;
    if(minuetes>=60){
        endTime.push(x+100+(minutes-60));
    }else{
        endTime.push(x+minutes);
    }
}

*/