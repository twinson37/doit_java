import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(br.readLine());

        int x = Integer.parseInt(tk.nextToken());
        int n = Integer.parseInt(br.readLine());
        int sum = 0;
        for (int i = 0; i < n; i++) {
            tk = new StringTokenizer(br.readLine());
            int a= Integer.parseInt(tk.nextToken());
            int b= Integer.parseInt(tk.nextToken());
            sum+=a*b;
        }

        if(sum==x) System.out.println("Yes");
        if(sum!=x) System.out.println("No");


    }
}