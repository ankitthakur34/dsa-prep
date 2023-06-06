package array;

import java.util.ArrayList;
import java.util.Arrays;

public class SortingAlgo {

    void printArray(int[] arr){
        System.out.println(Arrays.toString(arr));
    }

    void bubbleSort(int[] arr){
        int n=arr.length;
        for(int i=0;i<n;i++){
            for(int j=1;j<n-i;j++){
                if(arr[j-1]>arr[j]){
                    swap(arr,j-1,j);
                }
            }
        }
        printArray(arr);
    }

    void insertionSort(int[] arr){
        int n=arr.length;

        for(int i=0;i<n;i++){
            int last=n-1-i;
            int max=getMax(arr,last);
            swap(arr,max,last);
        }
        printArray(arr);
    }

    void selection(int[] arr){
        int n=arr.length;

        for(int i=0;i<n-1;i++){
            for(int j=i+1;j>0;j--){
                if(arr[j-1]>arr[j]){
                    swap(arr,j-1,j);
                }
            }
        }
        printArray(arr);


    }

    int linearS(int[] arr,int key){
        for(int i=0;i<arr.length;i++){
            if(arr[i]==key){
                return key;
            }
        }
        return -1;
    }

    int binaryS(int[] arr,int key){

        Arrays.sort(arr);

        int s=0;
        int e=arr.length-1;

        while (s<=e){
            int mid=s+(e-s)/2;
            if(arr[mid]==key){
                return key;
            }
            if(arr[mid]>key){
                e=mid-1;
            } else{
                s=mid+1;
            }
        }
        return -1;
    }


    void cyclicSort(int[] arr){
        int i=0;
        while (i<arr.length) {
            // for 1-n array
            int correctIn = arr[i]-1;
            // for 0-n-1 array
            // int correctIn = arr[i];
            if(arr[i]!=arr[correctIn]){
                swap(arr,i,correctIn);
            }
            i++;
        }
        printArray(arr);
    }




    private int getMax(int[] arr, int last) {
        int max=Integer.MIN_VALUE;
        int maxI=Integer.MIN_VALUE;
        for(int i=0;i<=last;i++){
            if(arr[i]>max){
                max=arr[i];
                maxI=i;
            }
        }
        return maxI;
    }

    private void swap(int[] arr, int i, int j) {
        int temp=arr[j];
        arr[j]=arr[i];
        arr[i]=temp;
    }

    public static void main(String[] args) {


        SortingAlgo s = new SortingAlgo();
        int[] arr= {5,1,3,2,4};
        s.cyclicSort(arr);

    }
}
