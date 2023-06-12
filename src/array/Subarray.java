package array;

import jdk.dynalink.linker.LinkerServices;

import java.util.ArrayList;
import java.util.*;

public class Subarray {

    void AllSubArray(int[] arr){
        int n= arr.length;
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                for(int k=i;k<=j;k++){
                    System.out.print(arr[k]+" ");
                }
                System.out.println();
            }
        }
    }

    void AllSubArray1(int[] arr){
        int n= arr.length;
        for(int i=0;i<n;i++){
            List<Integer> list = new ArrayList<>();
            for(int j=i;j<n;j++){
               list.add(arr[j]);
                System.out.println(list);
            }
        }
    }
    void AllSubArraySum(int[] arr){
        int n= arr.length;
        List<Integer> sumL = new ArrayList<>();
        for(int i=0;i<n;i++){
            int sum=0;
            for(int j=i;j<n;j++){
                List<Integer> list = new ArrayList<>();
                sum+=arr[j];
                list.add(sum);
                //sumL.add(sum);
                System.out.println(list);
                sumL.add(list.get(0));
            }

        }
        System.out.println(sumL);
        Collections.sort(sumL);
        System.out.println(sumL);
        System.out.println(sumL.get(1));

    }

    void subarrayGivenSum(int[] arr,int target){
        int n= arr.length;
        int sum=0;
        int cnt=0;
        int max=Integer.MIN_VALUE;
        int min=Integer.MAX_VALUE;
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        for(int i=0;i<n;i++){
            sum=0;
            ArrayList<Integer> list = new ArrayList<>();
            for(int j=i;j<n;j++){
                sum+=arr[j];
                list.add(arr[j]);
                if(sum==0){
                    ArrayList<Integer> list1 = new ArrayList<>();
                    list1.addAll(list);
                    cnt++;
                   ans.add(list1);
                   max=Math.max(max,j-i+1);
                    min=Math.min(min,j-i+1);
                }
             //   System.out.println(list);
            }

        }
        for(int i=0;i<ans.size();i++){
            if(ans.get(i).size()==min){
                System.out.println("min: "+ ans.get(i));
            }
            if(ans.get(i).size()==max){
                System.out.println("max: " + ans.get(i));
            }
        }
        System.out.println(ans);
        System.out.println(cnt);
        System.out.println(max);
        System.out.println(min);
    }
    // Kadane's Algo
    void maxSubarraySum(int[] arr){
        int n= arr.length;
        int sum=0;
        int max=0;
        for(int i=0;i<n;i++){
            sum+=arr[i];
            max=Math.max(max,sum);
            if(sum<0){
                sum=0;
            }

        }
    }

    void subarraySumHashmap(int[] arr,int sum){
       HashMap<Integer,Integer> map = new HashMap<>();
       int rSum=0;
       int s=0;
      int e=0;
      int max=0;
       for(int i=0;i<arr.length;i++){
           rSum+=arr[i];
           if(rSum==sum){
               s=0;
               e=i;
               max=Math.max(max,e-s+1);

           }
           if(map.containsKey(rSum-sum)){
               s=map.get(rSum-sum)+1;
               e=i;
               max=Math.max(max,e-s+1);
           }

               map.put(rSum, i);

       }
        System.out.println(s +" "+ e);
        System.out.println(max);
    }

    int maxproductSubarray(int[] arr){
        int maxL=arr[0];
        int maxR=arr[0];
        boolean isZero=false;
        int prod=1;

        for(int i=0;i<arr.length;i++) {
            prod = prod * arr[i];
            if (arr[i] == 0) {
                isZero = true;
                prod = 1;
                continue;
            }
            maxL = Math.max(maxL, prod);
        }
            prod=1;
            for(int i=arr.length-1;i>=0;i--){
                prod = prod * arr[i];
                if (arr[i] == 0) {
                    isZero = true;
                    prod = 1;
                    continue;
                }
                maxR = Math.max(maxR, prod);
            }
            if (isZero) return Math.max(maxL,Math.max(maxR,0));

            return Math.max(maxL,maxR);

    }


    public static void main(String[] args) {
        Subarray q = new Subarray();
        int[] arr={-13 ,0, 6, 15, 16, 2, 15, -12, 17, -16, 0, -3, 19, -3, 2, -9, -6};
        q.subarraySumHashmap(arr,15);

    }
}
