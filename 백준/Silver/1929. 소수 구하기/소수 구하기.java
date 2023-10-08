import java.io.*;
import java.util.*;

public class Main{
    static int[] n_arr;
//    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter  bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer tk = new StringTokenizer(br.readLine());;
        StringBuilder sb = new StringBuilder();

        int m = Integer.parseInt(tk.nextToken());
        int n = Integer.parseInt(tk.nextToken());
        int[] num = new int[n+1];
        boolean[] not_prime = new boolean[n+1];
        not_prime[1] = true;
        for (int i =2;i<=n;i++){

            if(not_prime[i]){
                continue;
            }
            for (int j=2 ;j*i<=n;j++){

                not_prime[i*j] = true;
            }
        }

        for(int i = m;i <= n ; i++){
            if(!not_prime[i]){
                sb.append(i).append("\n");
            }
        }


        bw.write(String.valueOf(sb));
        bw.flush();
        bw.close();

    }
}
