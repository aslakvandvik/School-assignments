package INF100labs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Implement the methods removeThrees, uniqueValues and addList.
 * These programming tasks was part of lab5 in INF100 fall 2022/2023. You can find them here: https://inf100h22.stromme.me/lab/5/
 */
public class Lab5 {
    
    public static void main(String[] args) {
        ArrayList<Integer> a1 = new ArrayList<>(Arrays.asList(1, 2, 3));
        ArrayList<Integer> b1 = new ArrayList<>(Arrays.asList(4, 2, -3));
        addList(a1, b1);
        System.out.println(a1); // [5, 4, 0]

        ArrayList<Integer> a2 = new ArrayList<>(Arrays.asList(1, 2, 3));
        ArrayList<Integer> b2 = new ArrayList<>(Arrays.asList(47, 21, -30));
        addList(a2, b2);
        System.out.println(a2); // [48, 23, -27]
    }

    public static ArrayList<Integer> multipliedWithTwo(ArrayList<Integer> list) {
        ArrayList<Integer> result = new ArrayList<>();
        
        for(int number : list){
            result.add(number * 2);
        }
        return result;
    }

    public static ArrayList<Integer> removeThrees(ArrayList<Integer> list) {
        ArrayList<Integer> resultRemoveThrees = new ArrayList<>();
        for(int number : list){
            if(number != 3){
                resultRemoveThrees.add(number);
            }
        }
        return resultRemoveThrees;
    }

    public static ArrayList<Integer> uniqueValues(ArrayList<Integer> list) {
        // gjør listen om til et set (tillater ikke duplikater), og så tilbake til en liste
        // bruker LinkedHashSet siden den ikke endrer rekkefølgen.
        Set<Integer> set = new LinkedHashSet<>(list);

        ArrayList<Integer> newList = new ArrayList<>(set);

        return newList;
    }

    public static void addList(ArrayList<Integer> a, ArrayList<Integer> b) {
        for(int i=0; i < a.size(); i++){
            a.set(i, a.get(i)+b.get(i)); // finner samme indeks i listen og adderer.
        }
    }
}