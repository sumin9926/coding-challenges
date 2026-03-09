import java.util.*;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

class cntKey implements Comparable<cntKey>{
    public int knum, vnum;
    cntKey(int knum, int vnum){
        this.knum=knum;
        this.vnum=vnum;
    }
    @Override
    public int compareTo(cntKey o){
        if(this.vnum==o.vnum) return this.knum-o.knum;
        else return this.vnum-o.vnum;
    }
}

class Main {
    static int[][] A;

   public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int r=Integer.parseInt(st.nextToken())-1, c=Integer.parseInt(st.nextToken())-1, k=Integer.parseInt(st.nextToken());

        A=new int[100][100];
        for(int i=0; i<3; i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0; j<3; j++){
                A[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        int time=0;

        while(time<=100){
            if(A[r][c]==k){
                System.out.println(time);
                return;
            }
            time++;
            if(checkCal()) calR();
            else calC();
        }

        System.out.println(-1);
    }

    // 행의 개수와 열의 개수 체크
    public static boolean checkCal(){
       int Rsize=0, Csize=0;
       for(int i=0; i<100; i++){
           int cnt_C=0, cnt_R=0;
           for(int j=0; j<100; j++){
               if(A[i][j]!=0) cnt_C++;
               if(A[j][i]!=0) cnt_R++;
           }
           Csize=Math.max(Csize,cnt_C);
           Rsize=Math.max(Rsize,cnt_R);
       }
        return Csize <= Rsize;
    }

    public static void calR(){ //R연산

        for(int i=0; i<100; i++){ //행 번호
            HashMap<Integer,Integer> R_numcnt=new HashMap<>();
            for(int j=0; j<100; j++){ //열 번호. 각 숫자가 몇 번 나왔는지 체크
                if(A[i][j]==0) continue;
                R_numcnt.put(A[i][j],R_numcnt.getOrDefault(A[i][j],0)+1);
            }
            ArrayList<cntKey> R_arr=sortList(R_numcnt);
            int k=0;
            for(; k<R_arr.size(); k++){ //배열 A에 정렬된 결과 넣기
                if(k>=50) break; //index 0~49까지
                cntKey n=R_arr.get(k);
                A[i][k*2]=n.knum;
                A[i][2*k+1]=n.vnum;
            }
            k*=2;
            for(; k< 99; k++){
                A[i][k]=0;
            }
        }
    }

    public static void calC(){ //C연산

        for(int j=0; j<100; j++){ //열 번호
            HashMap<Integer,Integer> C_numcnt=new HashMap<>();
            for(int i=0; i<100; i++){ //행 번호
                if(A[i][j]==0) continue;
                C_numcnt.put(A[i][j],C_numcnt.getOrDefault(A[i][j],0)+1);
            }
            ArrayList<cntKey> C_arr=sortList(C_numcnt);
            int k=0;
            for(; k<C_arr.size(); k++){ //배열 A에 정렬된 결과 넣기
                if(k>=50) break; //index 0~49까지
                cntKey n=C_arr.get(k);
                A[k*2][j]=n.knum;
                A[2*k+1][j]=n.vnum;
            }
            k*=2;
            for(; k< 99; k++){
                A[k][j]=0;
            }
        }
    }

    //수와 수의 등장 횟수를 주어진 조건에 맞게 정렬
    public static ArrayList<cntKey> sortList(HashMap<Integer,Integer> hm){
        ArrayList<cntKey> arr=new ArrayList<>();
        for(Map.Entry<Integer,Integer> entry: hm.entrySet()){
            arr.add(new cntKey(entry.getKey(), entry.getValue()));
        }
        Collections.sort(arr);
        return arr;
    }
}