package array;

import java.util.Arrays;

public class TwoArrays {
   void mergeTwoSortedArrays(int[] arr1 , int[] arr2){
        int n= arr1.length;
        int m =arr2.length;

        int[] ans = new int[n+m];
        int i=0;
        int j=0;
        int k=0;
        while (i<n && j<m){
            if(arr1[i]<arr2[j]){
                ans[k]=arr1[i];
                k++;
                i++;
            } else{
                ans[k]=arr2[j];
                j++;
                k++;
            }
        }

        while (i<n){
            ans[k]=arr1[i];
            k++;
            i++;
        }
        while (j<m){
            ans[k]=arr2[j];
            j++;
            k++;
        }
       System.out.println(Arrays.toString(ans));

    }

    void mergeWithoutSpace(int[] arr1, int[] arr2){
       int n=arr1.length;
       int m=arr2.length;

       int i=0;
       int j=0;

       while (i<n){
           if(arr1[i]>arr2[j]){
               swap(arr1,arr2,i,j);
               Arrays.sort(arr2);
           }
           i++;
       }
        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));
    }

    private void swap(int[] arr1, int[] arr2, int i, int j) {
       int temp=arr1[i];
       arr1[i]=arr2[j];
       arr2[j]=temp;
    }

    public static void main(String[] args) {
        TwoArrays q = new TwoArrays();
        int[] arr1 = {1,1,3,4,7};
        int[] arr2 = {1,2,5,7,8};
        q.mergeWithoutSpace(arr1,arr2);
    }
}
