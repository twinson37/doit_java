import java.util.*;
import java.io.*;

public class Main{

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk;

        int max = 0;
        int index = 0;

        for(int i = 0;i<9;i++){

            tk = new StringTokenizer(br.readLine());
            int nowNumber = Integer.parseInt(tk.nextToken());
            if (max<nowNumber){
                max = nowNumber;
                index = i+1;
            }
        }

        System.out.println(max);
        System.out.println(index);

    }
}