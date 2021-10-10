package edu.neu.coe.info6205.union_find;

import java.util.Scanner;

public class HWQUPC_Main {

    public static void main(String[] args)
    {
        //Scanner sc = new Scanner(System.in);
        int n =0;
        int resultant_pairs = 0,sum = 0;
        double avg_pairs = 0.0;
        int [] arr = {16,32,64,128,256,512,1024,2048,4096,8192,16384,32768,65536,131072};


        for (int i =0;i<arr.length;i++)
        {
            System.out.println("When the value of n is "+arr[i]);
            //n = sc.nextInt();
            for (int j =0;j<10;j++) {
                resultant_pairs = HWQUPC_Solution.count(arr[i]);
                sum += resultant_pairs;
            }
            avg_pairs= sum/10;
            System.out.println("The total number of pairs generated after taking average of 10 iterations are: "+avg_pairs);
            System.out.println("----------------------------------------------");
            sum = 0;
        }

    }

}
