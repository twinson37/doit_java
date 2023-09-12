import java.util.*;

public class Main{
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double[] arr = new double[n];
        double best = 0;
        double avg=0;

        for(int i = 0; i < n; i++){
            arr[i]= sc.nextInt();
            if(arr[i]>best) best = arr[i];
        }

        for(int j = 0; j < n; j++){
            avg += arr[j]*100/best;
        }


        System.out.println(avg/n);

    }
}
