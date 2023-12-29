import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(tk.nextToken());
        int m = Integer.parseInt(tk.nextToken());

        int arr[] = new int[n+1];

        for (int h = 0; h < m; h++) {

            tk = new StringTokenizer(br.readLine());

            int i = Integer.parseInt(tk.nextToken());
            int j = Integer.parseInt(tk.nextToken());
            int k = Integer.parseInt(tk.nextToken());

            for(int g = i; g<=j;g++){

                arr[g] = k;
            }
        }

        for (int i = 1; i<n+1;i++){

            System.out.print(arr[i]+" ");
        }
    }
}