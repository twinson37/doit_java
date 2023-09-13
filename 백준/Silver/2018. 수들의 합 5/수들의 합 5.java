import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw =new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer tk = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(tk.nextToken());
        int start_idx=1,end_idx=1;

        int sum=1;
        int count=1;
        int arr[] = new int[n+1];
        for(int i = 1; i < n+1; i++){
            arr[i] = i;
        }

        while(end_idx!=n){
            if(sum == n){
                end_idx++;
                count++;
                sum+=arr[end_idx];
            }else if(sum > n){
                sum-=arr[start_idx];
                start_idx++;
            }else{
                end_idx++;
                sum+=arr[end_idx];
            }
        }


        sb.append(count);
        bw.write(sb.toString());
        bw.flush();
        bw.close();

    }
}