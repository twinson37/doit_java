import java.io.*;
import java.util.*;


public class Main{

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter  bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer tk;
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();

        int n = Integer.parseInt(br.readLine());
        int a[] = new int[n];
        int ans[] = new int[n];

        tk = new StringTokenizer(br.readLine());
        for(int i = 0;i<n;i++){
            a[i] = Integer.parseInt(tk.nextToken());
        }

        for(int i = 0; i<n;i++){

            while (!stack.empty()&&a[stack.peek()]<a[i]){

                ans[stack.pop()] = a[i];
            }
            stack.push(i);
        }

        while(!stack.empty()){
            ans[stack.pop()]=-1;
        }

        for(int i = 0; i < n; i++){
            sb.append(ans[i]).append(" ");
        }

        bw.write(String.valueOf(sb));
        bw.flush();
        bw.close();

    }
}