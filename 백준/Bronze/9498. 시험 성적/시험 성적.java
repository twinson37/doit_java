import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer tk = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(tk.nextToken());


        if(a>=90) System.out.println("A");
        if(a<90&&a>=80) System.out.println("B");
        if(a<80&&a>=70) System.out.println("C");
        if(a<70&&a>=60) System.out.println("D");
        if(a<60) System.out.println("F");

    }

}