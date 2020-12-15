package com.marekczelij;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Stack;

public class StackFun {

    Stack<Integer> intStackH;
    Stack<Integer> intStackL;


    public void challenge() {
        Integer[] arr = {1,5,3,8,2,9,5,10,1};
        Integer[] arrL = Arrays.copyOf(arr,4);
        Integer[] arrH = Arrays.copyOfRange(arr,4,arr.length);

        Arrays.stream(arr).forEach(s-> System.out.print(s+" "));
        System.out.println("");
        Arrays.stream(arrL).forEach(s-> System.out.print(s+" "));
        System.out.println("");
        Arrays.stream(arrH).forEach(s-> System.out.print(s+" "));
        System.out.println("");

        stackSort(arrL);
        var firstPart = getAscentArray();
        Arrays.stream(getAscentArray()).forEach(s-> System.out.print(s+" "));
        System.out.println("");

        stackSort(arrH);
        var secondPart = getDescentArray();
        Arrays.stream(getDescentArray()).forEach(s-> System.out.print(s+" "));
        System.out.println("");

        var result = Arrays.copyOf(firstPart,firstPart.length+secondPart.length);
        for (int i = 0; i < secondPart.length; i++) {
            result[firstPart.length+i]=secondPart[i];
        }
        Arrays.stream(result).forEach(s-> System.out.print(s+" "));


    }

    public StackFun stackSort(Integer[] arr){

        intStackH =new Stack<Integer>();
        intStackL =new Stack<Integer>();


        for (Integer i : arr) {
            push(i);
        }
        return this;
    }

    private void push(Integer i){
        if (intStackL.empty() && intStackH.empty()) {
            intStackL.push(i);
            return;
        }
        boolean run = true;
        while(run){
            if (stackLHasLowerVal(i) && (stackHHasHigherVal(i) || intStackH.isEmpty())){
                intStackL.push(i);
                break;
            }
            if (stackHHasHigherVal(i) && (stackLHasLowerVal(i) || intStackL.isEmpty())){
                intStackL.push(i);
                break;
            }

            if (stackLHasHigherVal(i)){
                FromLToH();
                continue;
            }
            if (stackHHasLowerVal(i)) {
                FromHToL();
                continue;
            }
        }
    }
    private boolean stackLHasLowerVal(Integer i) { return !intStackL.empty() && intStackL.peek().compareTo(i)<0;}
    private boolean stackHHasLowerVal(Integer i) { return !intStackH.empty() && intStackH.peek().compareTo(i)<0;}
    private boolean stackHHasHigherVal(Integer i) { return !intStackH.empty() && intStackH.peek().compareTo(i)>-1;}
    private boolean stackLHasHigherVal(Integer i) { return !intStackL.empty() && intStackL.peek().compareTo(i)>-1;}

    private void FromLToH(){
        intStackH.push(intStackL.pop());
    }
    private void FromHToL(){
        intStackL.push(intStackH.pop());
    }

    public Object[] getAscentArray(){
        while(!intStackH.isEmpty()) FromHToL();
        return intStackL.toArray();
    }
    public Object[] getDescentArray(){
        while(!intStackL.isEmpty()) FromLToH();
        return intStackH.toArray();
    }


}
