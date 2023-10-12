import java.io.*;
import java.util.*;

public class Main{
    static int[] n_arr;
//    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter  bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer tk = new StringTokenizer(br.readLine());;
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(tk.nextToken());
        int m = Integer.parseInt(tk.nextToken());
        n_arr = new int[n+1];

        int calc,a,b;

        for(int i = 0;i<n+1;i++){
            n_arr[i] = i;
        }

        for(int i = 0; i < m;i++){
            tk = new StringTokenizer(br.readLine());
            calc = Integer.parseInt(tk.nextToken());
            a = Integer.parseInt(tk.nextToken());
            b = Integer.parseInt(tk.nextToken());


            if(calc==0) union(a,b);
            if(calc==1){
                if (find(a)==find(b)) sb.append("YES\n");
                if (find(a)!=find(b)) sb.append("NO\n");

            }
        }

        bw.write(String.valueOf(sb));
        bw.flush();
        bw.close();

    }

    public static void union(int a, int b){

        a=find(a);
        b=find(b);

        if(n_arr[a]==a&&n_arr[b]==b) n_arr[b] = a;

    }

    public static int find(int x){
        if(n_arr[x]==x) {
            return x;
        }else return n_arr[x]=find(n_arr[x]);
    }
}







/*
import java.io.*;
import java.util.*;

public class Main{
public static void main(String[] args) throws IOException {

BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
StringTokenizer tk = new StringTokenizer(br.readLine());
StringBuilder sb = new StringBuilder();
BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

int n = Integer.parseInt(tk.nextToken());
sb.append(ans+"\n");

bw.write(String.valueOf(sb));
bw.flush();
bw.close();

시간 측정
long beforeTime = System.currentTimeMillis();
long afterTime = System.currentTimeMillis();
long secDiffTime = (afterTime - beforeTime);
sb.append("\n"+secDiffTime+"ms");

 */
