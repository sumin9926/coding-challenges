import java.util.*;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class ParentCommand{ //(부모노드,사용된 명령어 번호)를 저장하는 클래스
    int PNode, Com;
    ParentCommand(int PNode, int Com){
        this.PNode=PNode;
        this.Com=Com;
    }
}

class Main {
    static String[] commands={"D","S","L","R"}; //명령어 모음. D=0번, S=1번, L=2번, R=3번
    static ParentCommand[] ch;
    static boolean[] chIndex;
    static String[] answer;
    static boolean flag;

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int T=Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int i=0; i<T; i++){
            st=new StringTokenizer(br.readLine());
            int A=Integer.parseInt(st.nextToken());
            int B=Integer.parseInt(st.nextToken());
            BFS(A,B);
        }
    }

    public static void BFS(int A, int B){
        int level=0;
        ch=new ParentCommand[10000]; //초기화
        chIndex=new boolean[10000]; //초기화
        Queue<Integer> q=new LinkedList<>();
        q.offer(A);
        ch[A]=new ParentCommand(A,-1);
        chIndex[A]=true;
        flag=false;
        
        while(!q.isEmpty()){
            int len=q.size();
            level++;
            for(int i=0; i<len; i++){
                int PNode=q.poll(); //부모노드, 이 부모노드 하나에 대해 4개의 명령어 수행

                for(int j=0; j<4; j++){
                    int sonNode=startCommand(j,PNode);
                    if(!chIndex[sonNode]){
                        ch[sonNode]=new ParentCommand(PNode,j);
                        chIndex[sonNode]=true;
                        if(sonNode==B){
                            answer=new String[level];
                            printAnswer(B,level,answer);
                            break;
                        }
                        q.offer(sonNode);
                    }
                }
                if(flag) break;
            }
            if(flag) break;
        }

    }

    public static int startCommand(int CommandNum, int PNode){
        if(CommandNum==0) return D(PNode);
        if(CommandNum==1) return S(PNode);
        if(CommandNum==2) return L(PNode);
        if(CommandNum==3) return R(PNode);
        else return 0;
    }

    public static void printAnswer(int pn,int level,String[] answer){
        if(flag) return;
        if(level==0){
            for(String x: answer) System.out.print(x);
            System.out.println();
            flag=true;
        }
        else {
            answer[level-1] = commands[ch[pn].Com];
            printAnswer(ch[pn].PNode, level - 1, answer);
        }
    }

    public static int D(int value){
        value*=2;
        if(value>9999) return value%10000;
        else return value;
    }

    public static int S(int value){
        if(value==0) return 9999;
        return value-1;
    }

    public static int L(int value){
        int[] valueArr=new int[4];
        int i=3; //valueArr.length-1=3
        while(i>-1){ //정수->정수 배열
            valueArr[i--]=value%10;
            value/=10;
        }
        int lastnum=valueArr[0]; //1의자리 숫자가 될 숫자 저장
        for(int j=1; j<4; j++){ //왼쪽으로 숫자 shift 수행
            valueArr[j-1]=valueArr[j];
        }
        valueArr[3]=lastnum;

        value=0;
        for(int digit:valueArr){ //정수배열->정수 변환
            value*=10;
            value+=digit;
        }
        return value;
    }

    public static int R(int value){
        int[] valueArr=new int[4];
        int i=3; //valueArr.length-1=3
        while(i>-1){ //정수->정수 배열
            valueArr[i--]=value%10;
            value/=10;
        }
        int firstnum=valueArr[3];
        for(int j=3; j>0; j--){
            valueArr[j]=valueArr[j-1];
        }
        valueArr[0]=firstnum;

        value=0;
        for(int digit:valueArr){ //정수배열->정수 변환
            value*=10;
            value+=digit;
        }
        return value;
    }
}