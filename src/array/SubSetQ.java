package array;

import java.util.ArrayList;
import java.util.HashSet;

public class SubSetQ {

    void allSubset(int[] arr){
        ArrayList<ArrayList<Integer>> outer = new ArrayList<>();
        outer.add(new ArrayList<>());

        for(int i=0;i<arr.length;i++){
            int n=outer.size();

            for(int j=0;j<n;j++){
                ArrayList<Integer> inner = new ArrayList<>(outer.get(j));
                inner.add(arr[i]);
                outer.add(inner);
            }
        }
        System.out.println(outer);


    }
    void allSubsetDup(int[] arr){
        ArrayList<ArrayList<Integer>> outer = new ArrayList<>();
        outer.add(new ArrayList<>());

        for(int i=0;i<arr.length;i++){
            int n=outer.size();

            for(int j=0;j<n;j++){
                ArrayList<Integer> inner = new ArrayList<>(outer.get(j));
                inner.add(arr[i]);
                outer.add(inner);
            }
        }
        System.out.println(outer);
        HashSet<ArrayList<Integer>> set = new HashSet<>();
        for(int i=0;i<outer.size();i++){
            set.add(outer.get(i));
        }
        System.out.println(set);

    }


    void subsetRec(int[] arr,int i,ArrayList<Integer> list,ArrayList<ArrayList<Integer>> ans){
        if(i==arr.length){
             // System.out.println(list);
              ans.add(new ArrayList<>(list));
            return;
        }

        list.add(arr[i]);
        subsetRec(arr,i+1,list,ans);
        list.remove(list.size()-1);
        subsetRec(arr,i+1,list,ans);

    }



    public static void main(String[] args) {
        SubSetQ q1 = new SubSetQ();
        int[] arr={1,2,3};
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        q1.subsetRec(arr,0,list,ans);
     //   System.out.println(list);
        System.out.println(ans);


    }
}
