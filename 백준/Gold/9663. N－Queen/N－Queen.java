import java.io.*;
import java.util.*;

public class Main{

    static int answer = 0;
    static boolean[] visitedColumn;
    static boolean[] visitedRightDiagonal;
    static boolean[] visitedLeftDiagonal;
    static  int n;

    public static void main(String[] args) throws IOException{

        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer tk = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(tk.nextToken());
        visitedColumn = new boolean[n+1];
        visitedRightDiagonal = new boolean[2*n+1];
        visitedLeftDiagonal = new boolean[2*n];

        dfs(1);
        sb.append(answer);
        bw.write(String.valueOf(sb));
        bw.flush();
        bw.close();
    }

    private static void dfs(int i) {
        if(n+1==i){
            answer++;
            return;
        }

        for(int j = 1; j<=n;j++){
            if((visitedColumn[j]==false)
                    &&(visitedRightDiagonal[i+j]==false)
                    && (visitedLeftDiagonal[i-j+n]==false)){

                visitedColumn[j]=true;
                visitedRightDiagonal[i+j]=true;
                visitedLeftDiagonal[i-j+n]=true;

                dfs(i+1);

                visitedColumn[j]=false;
                visitedRightDiagonal[i+j]=false;
                visitedLeftDiagonal[i-j+n]=false;
            }
        }
    }
}