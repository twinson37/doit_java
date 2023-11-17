import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] dp = new int[10];
        for (int i =0;i<10;i++){
            dp[i] = 1;
        }
        for(int i = 1; i<n;i++){

            for(int j = 1;j<10;j++){
//                dp[j] += dp[j-1];
                dp[j] = (dp[j]+dp[j-1])%10007;
//                dp[j]%=10007;
            }
        }
        int answer=0;
        for(int number : dp){

            answer+=number;
            answer%=10007;
        }

        System.out.println(answer);
    }
}