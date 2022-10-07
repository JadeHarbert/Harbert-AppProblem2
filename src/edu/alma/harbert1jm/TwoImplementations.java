package edu.alma.harbert1jm;

import java.util.ArrayList;
import java.util.Random;

/**
 * @author Scott Dexter
 * CSC 240
 * February
 */
public class TwoImplementations {

    public static void main(String[] args) {
        final int[] ARR_VAL_SIZE = {25, 250, 2500, 25000, 50000};
        final int RAND_VAL_RANGE = 100;
        Random rand = new Random();
        ArrayList<Integer[]> arrays = new ArrayList<>();


        /*
          Creates integer arrays in the arrays ArrayList with different sizes specified in ARR_VAL_SIZE
          Populates each element in the arrays with a random value from 0-99
         */
        for (int arr_val : ARR_VAL_SIZE) {
            Integer[] arr = new Integer[arr_val];
            for (int j = 0; j < arr_val; j++) {
                arr[j] = rand.nextInt(RAND_VAL_RANGE);
            }
            arrays.add(arr);
        }


        /*
          Performs the algorithm on each array with different element sizes and
          calculates how long each algorithm takes in milliseconds
         */
        for (Integer[] array : arrays) {
            long startTime = System.nanoTime();
            int[] alg1Results = alg1(array);
            long endTime = System.nanoTime();
            long duration = (endTime - startTime);
            System.out.println("Duration of alg1 for " + array.length + " elements in nanoseconds: \t " + duration);

            startTime = System.nanoTime();
            int[] alg2Results = alg2(array);
            endTime = System.nanoTime();
            duration = (endTime - startTime);
            System.out.println("Duration of alg2 for " + array.length + " elements in nanoseconds: \t" + duration);


            /*
              Compares the results gotten from the two different algorithms on an array with 50 elements to
              verify that both algorithms produce the same results
             */
            System.out.println("Do alg1 and alg2 produce the same results for " + array.length + " elements: " + java.util.Arrays.equals(alg1Results, alg2Results) + "\n");
        }

    }


    /**
     * @return integer array that performed the algorithm on each element of integers
     */
    static int[] alg1(Integer[] integers){
        int[] A = new int[integers.length];

        for(int i = 0; i < integers.length; i++) {
            int a = 0;

            for(int j = 0; j <= i; j++) {
                a = a + integers[j];
            }
            A[i] = a / (i + 1);
        }

        return A;
    }

    /**
     * @return integer array that performed the algorithm on each element of integers
     */
    static int[] alg2(Integer[] integers) {
        int[] A = new int[integers.length];
        int s = 0;

        for(int i = 0; i < integers.length; i++) {
            s = s + integers[i];
            A[i] = s / (i + 1);
        }
        return A;
    }
}

