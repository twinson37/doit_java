import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk;
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {

            tk = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(tk.nextToken());
            int b = Integer.parseInt(tk.nextToken());
            
            if (i == t - 1) {
                sb.append(a + b);
            } else {
                sb.append(a + b).append("\n");
            }

        }

        System.out.print(sb);
    }
}