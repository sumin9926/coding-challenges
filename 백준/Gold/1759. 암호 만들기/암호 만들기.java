import java.util.*;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.StringBuilder;

class Main {
    static char[] chars; //주어진 문자들을 저장하는 배열
    static StringBuilder sb=new StringBuilder();
    static char[] vowsArr={'a','e','i','o','u'};
    static int[] ch; //check 배열

    public static void DFS(int level, int L, int lf){
        if(level==L) {
            int cons=0, vow=0; //cons=자음, vow=모음
            // 자음모음 개수 검사
            String str=sb.toString();
            for(int i=0; i<str.length(); i++){
               if(Arrays.binarySearch(vowsArr,str.charAt(i))>=0) vow++;
               else cons++;
            }

            //암호 구성이 조건을 만족하는지 확인 후 출력
            if(vow>=1 && cons>=2) System.out.println(str);
        }
        else{
            for(int i=lf; i<ch.length; i++){
                if(ch[i]==0){
                    ch[i]=1;
                    lf=i; //현 위치 저장
                    sb.setCharAt(level,chars[i]);
                    DFS(level+1, L, lf);//DFS에 현 위치 넘겨주기(이전 위치 중복 탐색 방지)
                    ch[i]=0;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int L=Integer.parseInt(st.nextToken()); //암호를 구성하는 글자 수
        int c=Integer.parseInt(st.nextToken()); //주어진 문자의 개수
        ch=new int[c]; //check 배열
        st=new StringTokenizer(br.readLine());
        chars=new char[c]; //주어진 문자들을 저장할 배열
        for(int i=0; i<c; i++){
            chars[i]=st.nextToken().charAt(0); //주어진 문자들을 배열에 저장
        }
        Arrays.sort(chars); //사전식으로 출력하기 위해 문자들을 오름차순으로 정렬

        for(int j=0; j<L; j++) sb.append("0"); //DFS에서 setCharAt()로 특정 위치의 문자만 바꾸기 위해 미리 채워둠

        DFS(0, L, 0);
    }
}