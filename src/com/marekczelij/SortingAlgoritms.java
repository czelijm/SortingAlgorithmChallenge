package com.marekczelij;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

public class SortingAlgoritms<T extends Comparable> {

    public void mergeSort(T[] a)
    {
        performMergeSort(a);
    }
    private void performMergeSort(T[] a)
    {
        mergeSortStep(a);
    }

    private void mergeSortStep(T[] array){
        if(array.length<2) return;
        int mediumIndex = array.length/2;
        T[] left = Arrays.copyOfRange(array,0,mediumIndex);
        T[] right = Arrays.copyOfRange(array,mediumIndex,array.length);
        mergeSortStep(left);
        mergeSortStep(right);
        merge(array,left,right);
    }

    private void merge(T[] array, T[] left, T[] right) {
        boolean change = true;
        int arrayIndex = 0, leftIndex = 0, rightIndex = 0;
//        while(change){
            while (leftIndex<left.length && rightIndex<right.length)
            {
                if(left[leftIndex].compareTo(right[rightIndex])>-1)
                {
                    array[arrayIndex++]=right[rightIndex++];
                }else{
                    array[arrayIndex++]=left[leftIndex++];
                }
//                continue;
            }
            while (leftIndex<left.length){ array[arrayIndex++]=left[leftIndex++];}
            while (rightIndex<right.length){array[arrayIndex++]=right[rightIndex++];}
//            change=false;
//        }
    }

    public void bubbleSort(T[] array){
        for (int i = 0; i < array.length; i++) {
            for (int j = i+1; j < array.length; j++) {
                if(array[i].compareTo(array[j])>0){
                    T tmpVal = array[i];
                    array[i] = array[j];
                    array[j] = tmpVal;
                }
            }
        }
    }

}
