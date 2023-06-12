package array;

import java.util.*;
import java.util.logging.Handler;

import array.Question;
public class AdQuestion extends Question{

    void rotation(int[] arr , int k){
        int[] answer = new int[arr.length];
        for(int i=0;i<arr.length;i++){
            answer[(i+k)%arr.length]=arr[i];
        }

    }

    void moveZeros(int[] arr){
        int n= arr.length;
        int i=0;
        int j=0;
        while (j< arr.length){
            if(arr[j]==0){
                j++;
            } else{
                swap(arr,i,j);
                i++;
                j++;
            }
        }
        printArray(arr);

    }
    public void swap(int[] arr, int i, int j) {
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
    void rotation1(int[] arr,int k){
        int n=arr.length;

           for(int j=0;j<k;j++) {
               int elem= arr[n-1];
               for (int i = n - 1; i > 0; i--) {

                   arr[i] = arr[i - 1];
               }
               arr[0] = elem;
           }
        System.out.println(Arrays.toString(arr));
    }

    void moveZeros2(int[] arr){
        int cnt=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]!=0){
                swap(arr,i,cnt);
                cnt++;
            }
        }
    }

    void countOnes(int[] arr){
        int n= arr.length;
        int j=0;
        int cnt=1;
        int max=0;
        while (j<n){
            if(arr[j]==0){
                cnt=0;
            } else{
                cnt++;
            }
            j++;
            max=Math.max(cnt,max);
        }
    }

    int findMissing(int[] arr){
        int n=arr.length;
        int i=0;
        while (i<n){
            int correctIndex= arr[i];
            if( arr[i]<n && arr[i]!=arr[correctIndex]){
                swap(arr,i,correctIndex);
            } else{
                i++;
            }
        }

        for(int j=0;j<n;j++){
            if(arr[j]!=j){
                return j;
            }
        }
        return -1;
    }

    public int[] twoSum(int[] arr, int target) {

        HashMap<Integer,Integer> map = new HashMap<>();
        int[] ans = new int[2];
        for(int i=0;i<arr.length;i++){
            if(map.containsKey(target-arr[i])){
                ans[0]=i;
                ans[1]=map.get(target-arr[i]);
                return ans;
            }
            map.put(arr[i],i);
        }
        return ans;
    }
    void sort012(int[] arr){
        int i=0;
        int j=0;
        int k=arr.length-1;

        while(j<=k){
            if(arr[j]==2){
                swap(arr,j,k);
                k--;
            } else if(arr[j]==0){
                swap(arr,i,j);
                i++;
                j++;
            } else{
                j++;
            }
        }

    }

    public List<List<Integer>> threeSum(int[] arr) {
        Set<List<Integer>> ans = new HashSet<>();
      //  List<Integer> list = new LinkedList<>();
int n= arr.length;

        for(int i=0;i<n;i++){
           List<Integer> list;
            HashMap<Integer,Integer> map = new HashMap<>();
            for(int j=0;j<n && i!=j;j++){
                int elem= arr[i]+arr[j];
                if(map.containsKey(-elem)){
                list=Arrays.asList(arr[i],arr[j],-elem);
                Collections.sort(list);
                ans.add(list);

                }
                map.put(arr[j],j);
            }
        }

        return new ArrayList<>(ans);

    }



    public static void main(String[] args) {
        AdQuestion q1 = new AdQuestion();
        int[] arr={-1,0,1,2,-1,-4};
        System.out.println(q1.threeSum(arr));

    }
}
