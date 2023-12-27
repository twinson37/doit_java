import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk;

        while (true){

            tk = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(tk.nextToken());
            int second = Integer.parseInt(tk.nextToken());
            int sum = first+second;

            if (sum==0){
                break;
            }
            System.out.println(sum);
        }
    }
}