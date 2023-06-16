package array;

import matrix.Questions;

import java.util.Arrays;

public class BinarySearch {

    int binaryS(int[] arr , int key,int s,int e){
//        int s=0;
//        int e=arr.length-1;

        while (s<=e){
            int mid = s+(e-s)/2;

            if(arr[mid]==key){
                return mid;
            }
            else if(arr[mid]>key){
                e=mid-1;
            } else{
                s=mid+1;
            }
        }
        return -1;
    }
    int binarySdec(int[] arr , int key){
        int s=0;
        int e=arr.length-1;

        while (s<=e){
            int mid = s+(e-s)/2;

            if(arr[mid]==key){
                return mid;
            }
            else if(arr[mid]>key){
                s=mid+1;
            } else{
                e=mid-1;
            }
        }
        return -1;
    }

    int orderAgnoBS(int[] arr,int key,int s,int e){
//        int s=0;
//        int e=arr.length-1;
         boolean isAsc = false;
         if(arr[e]>arr[s]){
             isAsc=true;
         }

        while (s<=e){
            int mid=s+(e-s)/2;
            if(arr[mid]==key){
                return mid;
            }
            if(isAsc){
                if(arr[mid]>key){
                    e=mid-1;
                } else{
                    s=mid+1;
                }
            } else{
                if(arr[mid]>key){
                    s=mid+1;

                } else{
                    e=mid-1;
                }
            }
        }
        return -1;
    }

    int[] firstNlastocu(int[] arr,int key){
        int[] ans = new int[2];
        int first = flbs(arr,key,true);
        int last = flbs(arr,key,false);
        ans[0]=first;
        ans[1]=last;

        return ans;
    }

    private int flbs(int[] arr, int key, boolean isFirst) {
        int s=0;
        int e=arr.length-1;
        int ans=-1;
        while (s<=e){
            int mid = s+(e-s)/2;

            if(arr[mid]==key){
                ans=mid;
                if(isFirst){
                    e=mid-1;
                } else{
                    s=mid+1;
                }
            }

            else if(arr[mid]>key){
                e=mid-1;
            } else{
                s=mid+1;
            }
        }
        return ans;
    }

    int lengthOfElem(int[] arr,int key){
        int[] pos = firstNlastocu(arr,key);

        return pos[1]-pos[0]+1;
    }

    int binarySearchInfinity(int[] arr,int key){

        int s=0;
        int e=1;
        while (key>arr[e]){
            int newS=e+1;
            e=e+(e-s+1)*2;
            s=newS;
        }

        return binaryS(arr,key,s,e);

    }

    int mountainArray(int[] arr , int key){

        int peakI = findPeak(arr);
        if(arr[peakI]==key) return peakI;

        int firstH = orderAgnoBS(arr,key,0,peakI-1);

        if(firstH==-1){
            return orderAgnoBS(arr,key,peakI+1,arr.length-1);
        }

        return firstH;
    }

    private int findPeak(int[] arr) {
        int s=0;
        int e=arr.length-1;

        while (s<e){
            int mid= s+(e-s)/2;

            if(arr[mid]>arr[mid+1]){
                e=mid;
            } else{
                s=mid+1;
            }
        }
        return s;
    }

    int searchRoated(int[] arr,int key){

        int pivotI = findPivot(arr);

        if(pivotI==-1){
            return binaryS(arr,key,0,arr.length-1);
        }

        if(arr[pivotI]==key){
            return pivotI;
        }

        int first = binaryS(arr,key,0,pivotI-1);
        if(first!=-1){
            return first;
        }
        return binaryS(arr,key,pivotI+1,arr.length-1);
    }

    private int findPivot(int[] arr) {
        int s=0;
        int e=arr.length-1;

        while (s<=e){
            int mid =s+(e-s)/2;

            if( mid<arr.length-1 && arr[mid]>arr[mid+1]){
                return mid;
            }

            if(arr[mid]>=arr[s]){
                s=mid+1;
            } else{
                e=mid-1;
            }

        }
        return -1;
    }


    public static void main(String[] args) {
        BinarySearch q = new BinarySearch();
         int[] arr = {5,1,3};

        System.out.println(q.searchRoated(arr,5));
    }
}
