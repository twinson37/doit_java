import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(tk.nextToken());
        int m = Integer.parseInt(tk.nextToken());
        int[][] arr = new int[n+1][n+1];
        int[][] s_arr = new int[n+1][n+1];
        int x1,y1,x2,y2;

        int ans;

        for (int i =1;i<n+1;i++){
            tk = new StringTokenizer(br.readLine());
            for(int j = 1; j<n+1;j++){

                arr[i][j]= Integer.parseInt(tk.nextToken());
                if(j==1){
                    s_arr[i][j] = arr[i][j];
                }else s_arr[i][j] += s_arr[i][j-1]+arr[i][j];
            }
        }

        for(int k = 0;k<m;k++){
            tk = new StringTokenizer(br.readLine());

            ans = 0;
            x1= Integer.parseInt(tk.nextToken());
            y1=Integer.parseInt(tk.nextToken());
            x2=Integer.parseInt(tk.nextToken());
            y2=Integer.parseInt(tk.nextToken());

            for(int i = x1; i<x2+1;i++){
                ans+=s_arr[i][y2]-s_arr[i][y1-1];
            }
            sb.append(ans+"\n");


        }
        bw.write(String.valueOf(sb));
        bw.flush();
        bw.close();

    }
}