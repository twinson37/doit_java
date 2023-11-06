import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.StringTokenizer;

class Solution
{

    static int count;
    static int max;
    static int changeNumber;
    static int changeNumber2;
    static int sortedNumber;
    static ArrayList<Integer> list;
    static HashMap<Integer, ArrayList<Integer>> visited = new HashMap<>();

    public static void main(String[] args) throws Exception
    {

        //System.setIn(new FileInputStream("input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer tk = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();


        int T = Integer.parseInt(tk.nextToken());

        for(int test_case = 1; test_case <= T; test_case++)
        {
            visited.clear();
            count = 0;
            max = 0;
            tk = new StringTokenizer(br.readLine());
            list = new ArrayList<>();
            ArrayList<Integer> sortedList = new ArrayList<>();


            for(char chars: tk.nextToken().toCharArray()){

                list.add(Integer.parseInt(String.valueOf(chars)));
                sortedList.add(Integer.parseInt(String.valueOf(chars)));
            }
            changeNumber = Integer.parseInt(tk.nextToken());
            changeNumber2=changeNumber;

            sortedList.sort(Comparator.reverseOrder());
            sortedNumber = makeNumber(sortedList);

            dfs(makeNumber(list));

            sb.append("#").append(test_case).append(" ").append(max).append("\n");

        }
        bw.write(String.valueOf(sb));
        bw.flush();
        bw.close();
    }


    private static int makeNumber(ArrayList<Integer> list) {

        int len = list.size();
        int number=0;

        for (int i = 0; i<len;i++){

            number+= Math.pow(10,len-i-1)* list.get(i);
        }

        return number;
    }

    private static void dfs(int nowNumber) {
//        System.out.println(nowNumber);

//        if(nowNumber == sortedNumber){
//            System.out.println(sortedNumber);
//            int tmp = changeNumber2-count;
//            if(tmp>0){
//                if(tmp%2==1){
//                    swap(list.size()-1,list.size()-2 );
//                    nowNumber=makeNumber(list);
//                }
//            }
//            max = nowNumber;
//            return;
//        }

        if(count==changeNumber) {
            if(max<nowNumber){
                max = nowNumber;
            }

            return;
        }
        for (int i=0;i < list.size()-1;i++){
            for(int j = i+1; j<list.size();j++){
                swap(i,j);

//                ArrayList<Integer> tmpList = new ArrayList<>(list);
                if(!visited.containsKey(makeNumber(list))||!visited.get(makeNumber(list)).contains(count)){

                    count++;
                    dfs(makeNumber(list));
                    count--;
                    //                list = tmpList;
                    if(visited.containsKey(makeNumber(list))){

                        visited.get(makeNumber(list)).add(count);

                    }else visited.put(makeNumber(list),new ArrayList<Integer>(){{
                        add(count);
                    }});
                }
                swap(i,j);
            }
        }
    }


    private static void swap(int i, int j) {

        int tmp = list.get(i);
        list.set(i,list.get(j));
        list.set(j,tmp);
    }
}