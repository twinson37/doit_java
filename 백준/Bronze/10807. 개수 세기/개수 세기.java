import java.util.*;
import java.io.*;

public class Main{

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(tk.nextToken());
        int arr[] = new int[n];

        tk = new StringTokenizer(br.readLine());

        for(int i = 0;i<n;i++){

            arr[i] = Integer.parseInt(tk.nextToken());
        }

        int v = Integer.parseInt(br.readLine());
        int answer = 0;

        for(int i = 0;i<n;i++){

            if (arr[i]==v){
                answer++;
            }
        }

        System.out.println(answer);
    }
}