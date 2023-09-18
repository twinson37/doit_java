import java.io.*;
import java.util.*;


public class Main{

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter  bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        StringTokenizer tk;
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();

        int n = Integer.parseInt(br.readLine());
        int[] num = new int[n];
        int index = 1;
        boolean wrong= false;

        for(int i = 0;i<n;i++){
            num[i] = Integer.parseInt(br.readLine());
        }

        for (int i =0;i<n;i++){
            if(index<=num[i]){
                while(index<=num[i]){
                    stack.push(index);
                    index++;
                    sb.append("+\n");
                }
                stack.pop();
                sb.append("-\n");

                continue;
            }else {
                if(stack.peek()<num[i]){
                    System.out.println("NO\n");
                    wrong = true;
                    break;
                }
                stack.pop();
                sb.append("-\n");
            }
        }

        if(!wrong) bw.write(String.valueOf(sb));
        bw.flush();
        bw.close();

    }
}
