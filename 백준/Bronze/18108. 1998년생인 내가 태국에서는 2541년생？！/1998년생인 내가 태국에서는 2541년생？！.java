import java.util.*;
import java.io.*;

public class Main{

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int year = sc.nextInt();
        int diff = 2541 - 1998;
        System.out.println(year-diff);
    }

}