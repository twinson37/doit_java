import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter  bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer tk = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int s = Integer.parseInt(tk.nextToken());
        int p = Integer.parseInt(tk.nextToken());

        String str = br.readLine();

        tk= new StringTokenizer(br.readLine());
        int[] min = new int[4];
        int[] num = new int[4];
        int count = 0;
        int k = s-p;
        int[][] tmp = new int [k][2];

        for (int i = 0; i < 4; i++) {
            min[i] = Integer.parseInt(tk.nextToken());
        }

        int start_idx = 0;
        int end_idx = p-1;

        for(int i = 0; i<k;i++){
            tmp[i][0] = str.charAt(i);

            tmp[i][1] = str.charAt(i+p);
        }

        for (int i=start_idx;i<end_idx+1;i++){
            switch(str.charAt(i)){
                case 'A':
                    num[0]++;
                    break;
                case 'C':
                    num[1]++;
                    break;

                case 'G':
                    num[2]++;
                    break;

                case 'T':
                    num[3]++;
                    break;

            }
        }


        if(num[0]>=min[0]&&num[1]>=min[1]&&num[2]>=min[2]&&num[3]>=min[3]){
            count++;
        }

        for(int i = 0; i<k;i++){
            switch(tmp[i][0]){
                case 'A':
                    num[0]--;
                    break;
                case 'C':
                    num[1]--;
                    break;

                case 'G':
                    num[2]--;
                    break;

                case 'T':
                    num[3]--;
                    break;

            }
            switch(tmp[i][1]){
                case 'A':
                    num[0]++;
                    break;
                case 'C':
                    num[1]++;
                    break;

                case 'G':
                    num[2]++;
                    break;

                case 'T':
                    num[3]++;
                    break;

            }
            if(num[0]>=min[0]&&num[1]>=min[1]&&num[2]>=min[2]&&num[3]>=min[3]){
                count++;
            }

        }


        bw.write(Integer.toString(count));

        bw.flush();
        bw.close();

    }
}
