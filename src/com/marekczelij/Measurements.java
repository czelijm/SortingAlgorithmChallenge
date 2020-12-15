package com.marekczelij;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Measurements {

    public static <T extends Comparable> void performMergeSortMeasurement(T[] array,String setType) {
        SortingAlgoritms<T> sortingAlgoritms = new SortingAlgoritms<>();
        long start = System.nanoTime();

        sortingAlgoritms.mergeSort(array);

        long finish = System.nanoTime() - start;
        System.out.println("MergeSort " + setType +" "+finish +" [ns]");
    }

    public static <T extends Comparable> void performBubbleSortMeasurement(T[] array, String setType) {
        SortingAlgoritms<T> sortingAlgoritms = new SortingAlgoritms<>();
        long start = System.nanoTime();

        sortingAlgoritms.bubbleSort(array);

        long finish = System.nanoTime() - start;
        System.out.println("BubbleSort " + setType +" "+finish +" [ns]");
    }

    public static void performSortingTest(){
        int length = 1000;
        var ramdomSet = generateRandomSet(length);
        var ramdomReapetedSet = generateRandomRepeatedSet(length,5);
        Integer[] randomDescentSet = (Integer[]) generateDescentSet(length);

//        System.out.println();
//        Arrays.stream(ramdomSet).forEach(s-> System.out.print(s+" "));
//        System.out.println();
//        Arrays.stream(ramdomReapetedSet).forEach(s-> System.out.print(s+" "));
//        System.out.println();
//        Arrays.stream(randomDescentSet).forEach(s-> System.out.print(s+" "));
//        System.out.println();
//        System.out.println();

        performBubbleSortMeasurement(ramdomSet,"randomSet");
        performBubbleSortMeasurement(ramdomReapetedSet,"RandomRepeatedSet");
        performBubbleSortMeasurement(randomDescentSet,"randomSet");
        performMergeSortMeasurement(ramdomSet,"randomSet");
        performMergeSortMeasurement(ramdomReapetedSet,"RandomRepeatedSet");
        performMergeSortMeasurement(randomDescentSet,"randomSet");

    }


    public static Integer[] generateRandomSet(int length){
        Random rd = new Random();
        Integer[] result = new Integer[length];

        for (int i = 0; i < length; i++) {
            result[i] = rd.nextInt();
        }
        return result;
    }

    public static Integer[] generateRandomRepeatedSet(int length, int maxvalue){
        Random rd = new Random();
        Integer[] result = new Integer[length];

        for (int i = 0; i < length; i++) {
            result[i] = rd.nextInt(maxvalue);
        }
        return result;
    }

    public static Integer[] generateDescentSet(int length){
        Integer[] result = generateRandomSet(length);
        Object[] tmp = Arrays.stream(result).sorted().toArray();
        var tmp1 = Arrays.asList(tmp);
//        Collections.reverse(Arrays.asList(Arrays.stream(result).sorted().collect(Collectors.toList())));
        Collections.reverse(tmp1);
//        tmp1.stream().forEach(s-> System.out.print(s));
        var tmp2 = tmp1.stream().mapToInt(o->(int)o).toArray();
        var tmp3 = IntStream.of(tmp2).boxed().toArray(Integer[]::new);
        return tmp3;
    }
}
