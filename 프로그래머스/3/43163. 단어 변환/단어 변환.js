class Word{
    constructor(str, step){
        this.str=str;
        this.step=step;
    }
}

function solution(begin, target, words) {
    let totalWords = words.length;
    let isVisited = new Array(totalWords).fill(0);
    let q = [];
    q.push(new Word(begin, 0));
    
    function isNext(str1, str2){
        let unMatchCnt=0;
        for(let i=0; i<str1.length; i++){
            if(str1[i]!==str2[i]){
                unMatchCnt++;
                if(unMatchCnt>1) return false; 
            }
        }
        return true;
    }
    
    while(q.length!=0){
        let currentWord = q.shift();
        if(currentWord.str===target){
            return currentWord.step;
        }
        
        for(let i=0; i<totalWords; i++){
            if(!isVisited[i]&&isNext(currentWord.str, words[i])){
                isVisited[i]=1;
                q.push(new Word(words[i], 1+currentWord.step));
            }
        }
    }
    
    return 0;
}