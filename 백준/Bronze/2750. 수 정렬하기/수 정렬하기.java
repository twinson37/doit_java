import java.io.*;
import java.util.*;


public class Main{

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter  bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        StringTokenizer tk = new StringTokenizer(br.readLine());;
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int arr[] = new int[n];
        int tmp;

        for(int i = 0; i<n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
/*
* 5 2 3 4 1
* 2 5 3 4 1
* 2 3 5 4 1
* 2 3 4 5 1
* 2 3 4 1 5
*
* 2 3 4 1 5
* 2 3 4 1 5
* 2 3 1 4 5
*
* 2 3 1 4 5
* 2 1 3 4 5
*
* 1 2 3 4 5
*
*
*
* */

        for(int i = 0; i < n; i++){
            for(int j = 0; j<n-1; j++){
                if(arr[j]>arr[j+1]){
                    tmp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = tmp;
                }
            }
        }
        for(int i = 0; i<n;i++){
            sb.append(arr[i]).append("\n");
        }
        bw.write(String.valueOf(sb));
        bw.flush();
        bw.close();

    }
}