import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer tk = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(tk.nextToken());
        int m = Integer.parseInt(tk.nextToken());
        long arr[] = new long[n];
        long accumulated_sum[] = new long[n+1];
        long ans = 0;
        long num[] = new long[m+1];

        tk = new StringTokenizer(br.readLine());

        for(int i = 0; i<n;i++){
            arr[i] = Integer.parseInt(tk.nextToken());

            accumulated_sum[i+1] =  accumulated_sum[i]+arr[i];
        }

        for(int i = 1; i<n+1;i++){
            accumulated_sum[i]%=m;
            if (accumulated_sum[i]==0){
                ans++;
            }
            num[(int) (accumulated_sum[i]+1)]++;
        }

        for(int i=1;i<m+1;i++){
            ans+= num[i]*(num[i]-1)/2;
        }

        bw.write(String.valueOf(ans));
        bw.flush();
        bw.close();
    }
}