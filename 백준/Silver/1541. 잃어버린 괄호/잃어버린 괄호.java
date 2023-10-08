import java.io.*;
import java.util.*;

public class Main{
    static int[] n_arr;
//    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter  bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer tk = new StringTokenizer(br.readLine());;
//        StringBuilder sb = new StringBuilder();

        String[] str = tk.nextToken().split("-");
        String[] tmp;
        int ans=0;
        int[] number = new int[50];

        for(int i = 0; i < str.length; i++){

            tmp = str[i].split("[+]");

            for(int j = 0; j<tmp.length; j++){
                number[i]+=Integer.parseInt(tmp[j]);
            }
            if(i==0){
                ans=number[0];
            }else ans-=number[i];

        }

        bw.write(String.valueOf(ans));
        bw.flush();
        bw.close();

    }
}