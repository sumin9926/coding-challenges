import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

       for(int m=0; m<b; m++){
           for(int n=0; n<a; n++){
               System.out.print("*");
           }
           System.out.println();
       }
    }
}