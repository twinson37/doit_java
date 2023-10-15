import java.io.*;
import java.util.*;

public class Main{

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter  bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer tk = new StringTokenizer(br.readLine());;
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(tk.nextToken());
        int pre_construct;
        int num;
        int[] time = new int[n+1];
        int[] self_time = new int[n+1];
        ArrayList<Integer> condition;
        ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();

        int[] indegree = new int[n+1];

        for(int i = 0 ;i<n+1;i++){
            arr.add(new ArrayList<>());
        }
        for(int i = 1; i<n+1;i++){

            tk = new StringTokenizer(br.readLine());

            self_time[i] = Integer.parseInt(tk.nextToken());

            while((pre_construct = Integer.parseInt(tk.nextToken()))!=-1){
                arr.get(pre_construct).add(i);
                indegree[i]++;
            }
        }

        for(int i =1;i<n+1;i++){
            if(indegree[i]==0) queue.add(i);
        }

        int now;
        while (!queue.isEmpty()){

            now = queue.poll();

            for(int i : arr.get(now)){
                indegree[i]--;
                time[i]=Math.max(self_time[now]+time[now],time[i]);
                if(indegree[i]==0) queue.add(i);
            }
        }

        for(int i = 1;i<n+1;i++){
            sb.append(time[i]+self_time[i]).append("\n");
        }

        bw.write(String.valueOf(sb));
        bw.flush();
        bw.close();

    }
}