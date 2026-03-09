import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] nums = new int[N];
        for(int i=0; i<N; i++){
            nums[i]=Integer.parseInt(br.readLine());
        }

        // 버블 정렬(내림차순)
        int last=N;
        while(last>0){
            for(int i=1; i<last; i++){
                if(nums[i-1]<nums[i]){
                    int tmp=nums[i];
                    nums[i]=nums[i-1];
                    nums[i-1]=tmp;
                }
            }
            last--;
            System.out.println(nums[last]);
        }
    }
}
