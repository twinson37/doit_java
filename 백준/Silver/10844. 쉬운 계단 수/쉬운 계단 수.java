import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] list = new int[n+1][10];

        for(int i = 0; i<=9;i++){
            list[1][i] = 1;
        }

        for(int i =2;i<=n;i++){
            for(int j = 0;j<=9;j++){
                if(j==0){

                    list[i][j] = list[i-1][j+1]%1000000000;
                }
                else if(j==9){
                    list[i][j] = list[i-1][j-1]%1000000000;
                }else list[i][j] = ((list[i-1][j-1]%1000000000)+(list[i-1][j+1]%1000000000))%1000000000;
            }
        }
        int answer = 0;
        for(int i = 1;i<=9;i++){
            answer+=(list[n][i])%1000000000;
            answer%=1000000000;
        }

        System.out.println(answer);
    }
}