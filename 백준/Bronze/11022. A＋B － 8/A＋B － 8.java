import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk;

        int t = Integer.parseInt(br.readLine());

        for(int i = 0; i < t;i++){

            tk = new StringTokenizer(br.readLine());

            int first = Integer.parseInt(tk.nextToken());
            int second = Integer.parseInt(tk.nextToken());

            System.out.println("Case #"+(i+1)+": "+first+" + "+second+" = "+(first+second));
        }
    }
}