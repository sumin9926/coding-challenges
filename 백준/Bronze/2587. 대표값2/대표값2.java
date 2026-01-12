import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int[] nums = new int[5];
        int total=0;
        for(int i=0; i<5; i++){
            nums[i]=Integer.parseInt(br.readLine());
            total+=nums[i];
        }
        System.out.println(total/5); //평균값

        // 삽입 정렬
        for(int i=1; i<5; i++){
            for(int j=i-1; j>=0; j--){
                if(nums[j]<=nums[j+1]) break;
                else{
                    int tmp=nums[j];
                    nums[j]=nums[j+1];
                    nums[j+1]=tmp;
                }
            }
        }

        System.out.println(nums[2]);
    }
}