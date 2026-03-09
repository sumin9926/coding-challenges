import java.util.*;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class StartEnd implements Comparable<StartEnd> {
    int start, end;
    public StartEnd(int start, int end){
        this.start=start;
        this.end=end;
    }

    @Override
    public int compareTo(StartEnd o) {
        if(this.start==o.start) return this.end-o.end; //종료일 오름차순
        else return this.start-o.start; //시작일 오름차순
    }
}

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        StartEnd[] flowers=new StartEnd[N];
        for(int i=0; i<N; i++){
            StringTokenizer st=new StringTokenizer(br.readLine());
            int sDay=Integer.parseInt(st.nextToken())*100+Integer.parseInt(st.nextToken());
            int eDay=Integer.parseInt(st.nextToken())*100+Integer.parseInt(st.nextToken());
            flowers[i]=new StartEnd(sDay,eDay);
        }
        Arrays.parallelSort(flowers); //조건에 맞게 정렬

        int idx=0,ans=0,sDay=301,eMax=0; //sDay는 다음 선택할 꽃이 꼭 피어야할 마지노선 날짜(=sDay 이전에 피는 꽃만 선택해야함).

        while(sDay<1201){ //11월30일 이후부터 피는 꽃은 고려할 필요 없음. *참고) 꽃은 모두 같은 해에 피어서 같은 해에 진다.
            boolean selectFlower=false;

            for(int j=idx; j<N; j++){
                if(flowers[j].start>sDay) break; // 선택한 꽃의 개화일이 마지노선을 넘긴 경우

                /*선택한 꽃의 개화일이 마지노선을 넘지 않으면서, 가장 늦게 지는 꽃인 경우.(=피어있는 기간이 더 긴 꽃)*/
                else if(flowers[j].start<=sDay && flowers[j].end>eMax){
                    if(flowers[j].end>1201){
                        System.out.println(++ans);
                        return;
                    }
                    selectFlower=true; //선택할 수 있는 꽃이 있음.
                    idx=j+1; //다음 시작 위치 지정
                    eMax=flowers[j].end;
                }
            }

            if(selectFlower){
                ans++;
                sDay=eMax;
            }
            else {System.out.println(0); return;} //선택 가능한 꽃이 없는 경우
        }
        System.out.println(ans);
    }
}