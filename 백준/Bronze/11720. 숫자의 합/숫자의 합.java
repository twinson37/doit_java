import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long n = sc.nextLong();

        String num = sc.next();
        long sum = 0;
        long tmp = 0;

        for(long i =0; i<n; i++){
            sum += Integer.valueOf(String.valueOf(num.charAt((int) i)));

        }

        System.out.println(sum);



    }
}
