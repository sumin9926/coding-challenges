import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), k=Integer.parseInt(st.nextToken());

        int[] scores = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            scores[i]=Integer.parseInt(st.nextToken());
        }

        // 내림차순 정렬 및 [k-1] 번째 점수 반환
        // 병합정렬
        int[] sortedScores = mergeSort(scores);

        System.out.println(sortedScores[k-1]);
    }

    public static int[] mergeSort(int[] arr){
        if(arr.length<=1) return arr;
        else{
            int mid = arr.length/2;
            int[] leftArr = mergeSort(Arrays.copyOfRange(arr, 0, mid));
            int[] rightArr = mergeSort(Arrays.copyOfRange(arr, mid, arr.length));

            return merge(leftArr, rightArr);
        }
    }

    // 내립 차순 병합
    public static int[] merge(int[] leftArr, int[] rightArr){
        int[] mergedArr = new int[leftArr.length + rightArr.length];
        int l=0, r=0, idx=0;

        while(l < leftArr.length && r < rightArr.length){
            if(leftArr[l]>rightArr[r]){
                mergedArr[idx++]=leftArr[l++];
            } else{
                mergedArr[idx++]=rightArr[r++];
            }
        }

        while(l < leftArr.length){
            mergedArr[idx++]=leftArr[l++];
        }

        while(r < rightArr.length){
            mergedArr[idx++]=rightArr[r++];
        }

        return mergedArr;
    }
}