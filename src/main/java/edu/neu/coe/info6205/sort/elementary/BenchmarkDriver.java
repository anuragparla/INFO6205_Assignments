package edu.neu.coe.info6205.sort.elementary;

import edu.neu.coe.info6205.sort.BaseHelper;
import edu.neu.coe.info6205.sort.GenericSort;
import edu.neu.coe.info6205.sort.Helper;
import edu.neu.coe.info6205.util.*;

import java.util.Arrays;
import java.util.Random;
import java.util.function.Supplier;

public class BenchmarkDriver {
    //public String description = "Insertion sort";

    public void testInsertionSortBenchmark() {
        //String description = "Insertion sort";
        //Helper<Integer> helper = new BaseHelper<>(description, N, config);
        //final GenericSort<Integer> sort = new InsertionSort<>(helper);
        //runBenchmark(description, sort, helper);
    }





    public void runBenchmark(String description, Helper<Integer> helper, Supplier<Integer[]> supplier) {
        //helper.init(N);

        final GenericSort<Integer> sort = new InsertionSort<>(helper);
        final Benchmark<Integer[]> benchmark = new Benchmark_Timer<>(
                description + " for " + N + " Integers",
                (xs) -> Arrays.copyOf(xs, xs.length),
                sort::mutatingSort,
                null
        );
        logger.info(Utilities.formatDecimal3Places(benchmark.runFromSupplier(supplier, 100)) + " ms");
    }


    final static LazyLogger logger = new LazyLogger(BenchmarkDriver.class);

    public static int N = 1000;

    private static Config config;


    public static Integer[] generate_orderedarray(int N)
    {
        Integer[] arr_ordered = new Integer[N];
        for (int i=0;i<N;i++)
        {
            arr_ordered[i] = i+1;
        }
        return arr_ordered;
    }


    public static int reset_value_of_N ()
    {
        return 1000;
    }
    public static Integer[] generate_revrseorderedarray(int N)
    {
        Integer[] arr_reversed = new Integer[N];
        int temp = N;
        for(int i=0;i<N;i++)
        {

            arr_reversed[i] = temp;
            temp -=1;
        }
        return arr_reversed;
    }

    public static Integer[] generate_partiallyorderedarray(int N)
    {
        Integer[] arr_partiallyordered = new Integer[N];
        Random random_num = new Random();
        for (int i =0;i<N/2;i++)
        {
            arr_partiallyordered[i] = random_num.nextInt(N/2)+1;
        }
        for (int j=N/2;j<N;j++)
        {
            arr_partiallyordered[j] = j;
        }
        return arr_partiallyordered;
    }

    public static void main(String[] args)
    {
        String description = "Insertion Sort for array of random numbers";
        BenchmarkDriver bd = new BenchmarkDriver();

        /*
        for random
        */

        for (int i=0;i<5;i++)
        {
            Helper<Integer> helper = new BaseHelper<>(description, N, config);
            Supplier<Integer[]> supplier = () -> helper.random(Integer.class, Random::nextInt);

            bd.runBenchmark(description,helper,supplier);
            N = N*2;
        }

        N = reset_value_of_N();
        /* for ordered */
        for (int i=0;i<5;i++)
        {
            description = "Insertion Sort for ordered array";
            Helper<Integer> helper = new BaseHelper<>(description, N, config);
            Supplier<Integer[]> supplier = () -> generate_orderedarray(N);
            bd.runBenchmark(description,helper,supplier);
            N = N*2;

        }

        N = reset_value_of_N();
        for(int i=0;i<5;i++) {
            description = "Insertion Sort for reverse ordered array";
            Helper<Integer> helper = new BaseHelper<>(description, N, config);
            Supplier<Integer[]> supplier = () -> generate_revrseorderedarray(N);
            bd.runBenchmark(description, helper, supplier);
            N = N * 2;
        }

        N = reset_value_of_N();
        for(int i=0;i<5;i++)
        {
            description = "Insertion Sort for partially ordered array";
            Helper<Integer> helper = new BaseHelper<>(description, N, config);
            Supplier<Integer[]> supplier = () -> generate_partiallyorderedarray(N);
            bd.runBenchmark(description,helper,supplier);
            N = N * 2;
        }

    }

}
