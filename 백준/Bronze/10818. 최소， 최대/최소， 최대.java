import java.util.*;
import java.io.*;

public class Main{

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(tk.nextToken());

        int min = 1000000;
        int max = -1000000;

        tk = new StringTokenizer(br.readLine());

        for(int i = 0;i<n;i++){

            int nowNumber = Integer.parseInt(tk.nextToken());

            min = (min>nowNumber) ? nowNumber:min;
            max = (max<nowNumber) ? nowNumber:max;
        }

        System.out.println(min+" "+max);

    }
}