package edu.neu.coe.info6205.union_find;

import java.util.Random;

public class HWQUPC_Solution {

    public static int count(int n)
    {
        UF c = new UF_HWQUPC(n);
        int pair_count = 0;
        Random random = new Random();
        while(c.components()>1)
        {
            int pair1 = random.nextInt(n);
            int pair2 = random.nextInt(n);
            pair_count +=1;
            c.connect(pair1,pair2);
        }

        return pair_count;
    }

}
