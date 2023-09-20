import java.io.*;
import java.util.*;

class node implements Comparable<node>{
    int value;
    int index;

    public node(int value, int index){
        super();
        this.value = value;
        this.index = index;

    }

    @Override
    public int compareTo(node o) {
        return this.value-o.value;
    }
}

public class Main{

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter  bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        StringTokenizer tk = new StringTokenizer(br.readLine());;
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        node[] arr = new node[n];
        int max=0;

        for(int i = 0; i<n; i++){
            arr[i] = new node(Integer.parseInt(br.readLine()),i);
        }

        Arrays.sort(arr);


        for(int i = 0; i<n;i++){
            if(max<arr[i].index-i){
                max = arr[i].index-i;
            }
        }
        sb.append(max+1);

        bw.write(String.valueOf(sb));
        bw.flush();
        bw.close();

    }
}