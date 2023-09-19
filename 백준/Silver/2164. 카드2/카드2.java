import java.io.*;
import java.util.*;


public class Main{

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter  bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer tk;
        StringBuilder sb = new StringBuilder();
        Queue<Integer> queue = new LinkedList<>();

        int n = Integer.parseInt(br.readLine());
//        long beforeTime = System.currentTimeMillis();

        int a[] = new int[n];
        int k=1;
//        tk = new StringTokenizer(br.readLine());


        for(int i = 1;i<n+1;i++){
            queue.add(i);
        }

        while(queue.size()!=1){
            if(k==1){
                queue.poll();
                k=0;
            }else{
                queue.add(queue.poll());
                k=1;
            }
        }

        sb.append(queue.poll());

//        long afterTime = System.currentTimeMillis();
//        long secDiffTime = (afterTime - beforeTime);
//        sb.append("\n"+secDiffTime+"ms");


        bw.write(String.valueOf(sb));
        bw.flush();
        bw.close();

    }
}