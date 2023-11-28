import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(br.readLine());

        int x = Integer.parseInt(tk.nextToken());
        int y = Integer.parseInt(tk.nextToken());
        int z = Integer.parseInt(tk.nextToken());

        int same = 0;
        int reward = 0;
        int max = 0;
        int samenum = 0;
        max =Math.max(x,y);
        max = Math.max(max,z);

        if(x==y) {
            same++;
            samenum = x;
        }
        if(x==z) {
            same++;
            samenum = x;

        }
        if(z==y) {
            same++;
            samenum = z;

        }

        if(same == 3 ) reward = 10000+x*1000;
        if(same==1) reward = samenum*100+1000;
        if(same == 0) reward = max*100;
        
        System.out.println(reward);
    }

}