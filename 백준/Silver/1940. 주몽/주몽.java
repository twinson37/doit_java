import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter  bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer tk = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(tk.nextToken());
        tk = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(tk.nextToken());
        int start_idx=0;
        int end_idx=1;
        int sum=0;
        int count=0;

        int[] arr = new int[n];
        tk = new StringTokenizer(br.readLine());
        for(int i = 0; i<n;i++){
            arr[i] = Integer.parseInt(tk.nextToken());
        }

        while(start_idx!=n-1){
            sum = arr[start_idx]+arr[end_idx];

            if(sum==m){
                count++;

            }
            if(end_idx==n-1){
                end_idx=++start_idx+1;
            }else end_idx++;
        }
        sb.append(count);
        bw.write(sb.toString());
        bw.flush();
        bw.close();

    }
}