import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(br.readLine());

        int h = Integer.parseInt(tk.nextToken());
        int m = Integer.parseInt(tk.nextToken());
        int duration = Integer.parseInt(br.readLine());
        int hDuration = duration/60;
        int mDuration = duration%60;


       if(m+mDuration>=60){

           m = m +mDuration - 60;
           h+=1;

       }else{
           m+=mDuration;
       }
       h+=hDuration;
       if(h>=24){
           h -= 24;
       }

       System.out.println(h+" "+m);
    }

}