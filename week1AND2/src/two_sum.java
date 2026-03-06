import java.util.*;

public class two_sum {

    public static void find(int[] nums,int target){

        HashMap<Integer,Integer> map=new HashMap<>();

        for(int n:nums){

            int c=target-n;

            if(map.containsKey(c))
                System.out.println(n+" "+c);

            map.put(n,1);
        }
    }

    public static void main(String[] args){

        int[] arr={500,300,200};

        find(arr,500);
    }
}