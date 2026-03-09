import java.util.*;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main {
    static int L,N;
    static int[][] arr;
    static int[] ch; //다리 설치 위치 체크

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        L=Integer.parseInt(st.nextToken());
        arr=new int[N][N];

        for(int r=0; r<N; r++){
            st=new StringTokenizer(br.readLine());
            for(int c=0; c<N; c++){
                arr[r][c]=Integer.parseInt(st.nextToken());
            }
        }

        int route=0; //지나갈 수 있는 길의 개수
        boolean bool;
        //가로방향
        for(int r=0; r<N; r++){
            ch=new int[N];
            for(int c=0; c<N; c++){
                if(c==N-1) {route+=1; break;}
                int val=arr[r][c]-arr[r][c+1];
                if(val==-1) bool=up(r,c,'H'); //오르막 경사로 설치 가능
                else if(val==1) bool=down(r,c,'H'); //내리막 경사로 설치 가능
                else if(val==0) continue; //평지
                else break; //단차 2이상

                if(!bool) break; //경사로 설치 불가
            }
        }

        //세로 방향
        for(int c=0; c<N; c++){
            ch=new int[N];
            for(int r=0; r<N; r++){
                if(r==N-1) {route+=1; break;}
                int val=arr[r][c]-arr[r+1][c];
                if(val==-1) bool=up(r,c,'V'); //오르막 경사로 설치 가능
                else if(val==1) bool=down(r,c,'V'); //내리막 경사로 설치 가능
                else if(val==0) continue; //평지
                else break; //단차 2이상

                if(!bool) break; //경사로 설치 불가
            }
        }

        System.out.println(route);
    }

    //오르막 경사로 설치
    public static boolean up(int r, int c, char s){
        int length=1, nc=c-1, nr=r-1;

        if(s=='H'){ //가로로 설치
            if(ch[c]==0) ch[c]=1;
            else return false;
            for(int i=0; i<L-1; i++){
                if(nc>=0 && ch[nc]==0 &&arr[r][nc]==arr[r][c]) {
                    ch[nc]=1;
                    length++;
                    nc--;
                }
                else break;
            }
            if(length==L) return true; //경사로 설치 가능
            else return false; //경사로 설치 불가능
        }
        //세로로 설치
        if(ch[r]==0) ch[r]=1;
        else return false;
        for(int i=0; i<L-1; i++){
            if(nr>=0 && ch[nr]==0 &&arr[nr][c]==arr[r][c]) {
                ch[nr]=1;
                length++;
                nr--;
            }
            else break;
        }
        if(length==L) return true; //경사로 설치 가능
        else return false; //경사로 설치 불가능
    }

    //내리막 경사로 설치
    public static boolean down(int r, int c, char s){
        int length=1, nc=c+2, nr=r+2;

        if(s=='H'){//가로로 설치
            if(ch[c+1]==0) ch[c+1]=1;
            else return false;
            for(int i=0; i<L-1; i++){
                if(nc<N &&ch[nc]==0&& arr[r][nc]==arr[r][c+1]){
                    ch[nc]=1;
                    length++;
                    nc++;
                }
                else break;
            }
            if(length==L) return true; //경사로 설치 가능
            else return false; //경사로 설치 불가능
        }
        //세로로 설치
        if(ch[r+1]==0) ch[r+1]=1;
        else return false;
        for(int i=0; i<L-1; i++){
            if(nr<N && ch[nr]==0 &&arr[nr][c]==arr[r+1][c]){
                ch[nr]=1;
                length++;
                nr++;
            }
            else break;
        }
        if(length==L) return true; //경사로 설치 가능
        else return false; //경사로 설치 불가능
    }
}
