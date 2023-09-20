import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main{

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter  bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        StringTokenizer tk = new StringTokenizer(br.readLine());;
        StringBuilder sb = new StringBuilder();
        String n = br.readLine();

        char[] arr =  n.toCharArray();
        int[] arr1 = new int[n.length()];
        int tmp;

        for (int i=0;i<n.length();i++) {
            arr1[i] = Integer.parseInt(String.valueOf(arr[i]));
        }

        int max = 0;
        for(int i = 0; i<n.length(); i++){
            max =arr1[i];
            for(int j = i; j<n.length();j++){
                if(max<arr1[j]){
                    max = arr1[j];
                    arr1[j] = arr1[i];
                    arr1[i] = max;
                }
            }
        }
        for (int i=0;i<n.length();i++) {
            sb.append(arr1[i]);
        }

        bw.write(String.valueOf(sb));
        bw.flush();
        bw.close();

    }
}