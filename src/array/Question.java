package array;

import java.util.*;

public class Question {
 public    void printArray(int[] arr){
        System.out.println(Arrays.toString(arr));
    }
     void largestNSmallest(int[] arr){
         int max=Integer.MIN_VALUE;
         int min=Integer.MAX_VALUE;

         for(int i=0;i<arr.length;i++){
             if(arr[i]>max){
                 max=arr[i];
             }
             if(arr[i]<min){
                 min=arr[i];
             }
         }
         System.out.println("max = " +max);
         System.out.println("min = " +min);
     }

     void secondLandM(int[] arr){
         int max=Integer.MIN_VALUE;
         int min=Integer.MAX_VALUE;

         for(int i=0;i<arr.length;i++){
             if(arr[i]>max){
                 max=arr[i];
             }
             if(arr[i]<min){
                 min=arr[i];
             }
         }
         int maxS=Integer.MIN_VALUE;
         int minS=Integer.MAX_VALUE;

         for(int i=0;i<arr.length;i++){
             if(arr[i]>maxS && arr[i]!=max ){
                 maxS=arr[i];
             }
             if(arr[i]<minS && arr[i]!=min ){
                 minS=arr[i];
             }
         }

         System.out.println("maxS = " +maxS);
         System.out.println("minS = " +minS);

     }
     // only for distint array
     int secSmallest(int arr[], int n)
    {
        int first = Integer.MAX_VALUE, second = Integer.MAX_VALUE;

        for (int i=0; i < n; i++){
            if(arr[i] < first){ second = first; first = arr[i]; }

            else if(second>arr[i])
                second = arr[i];
        }

        return second;

    }

   void sumOfElem(int[] arr){
         int sum=0;
         for(int i=0;i<arr.length;i++){
             sum+=arr[i];
         }

       System.out.println(sum);
    }

    void reverseArray(int[] arr){
         int i=0;
         int j=arr.length-1;
         while (i<j){
             swap(arr,i,j);
             i++;
             j--;
         }
        printArray(arr);
    }

    void AscDec(int[] arr){
        Arrays.sort(arr);
        int i=0;
        int j=arr.length-1;
        int mid=(i+j)/2;
        mid=mid+1;

        while (mid<j){
            swap(arr,mid,j);
            mid++;
            j--;
        }
        printArray(arr);

    }

    void countFreq1(int[] arr){
        int n=arr.length;
        boolean[] isVisited= new boolean[n];
        Arrays.fill(isVisited,false);

        for(int i=0;i<n;i++){
           if(isVisited[i]) continue;
            int cnt=1;
            for(int j=i+1;j<n;j++){
                if(arr[i]==arr[j]){
                    isVisited[j]=true;
                    cnt++;
                }
            }
            System.out.println("elem :"+ arr[i] + " cnt :"+ cnt);
            System.out.println();
        }
    }

    void countFreq2(int[] arr){
        Arrays.sort(arr);
        int cnt=1;
        for(int i=0;i<arr.length;i++){
            int elem=arr[i];
            if( i<arr.length-1 && arr[i]==arr[i+1]){
                cnt++;
            }else{
            System.out.println("elem :"+ elem + " cnt :"+ cnt);
            cnt=1;
            }
        }
    }
    void countFreq3(int[] arr){
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<arr.length;i++){
            if(map.containsKey(arr[i])){
                map.put(arr[i],map.get(arr[i])+1);
            }else {
                map.put(arr[i], 1);
            }
        }

        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            System.out.println(entry.getKey() + " cnt: "+ entry.getValue());
        }
    }

    void sortFreq(int[] arr){
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<arr.length;i++){
            if(map.containsKey(arr[i])){
                map.put(arr[i],map.get(arr[i])+1);
            }else {
                map.put(arr[i], 1);
            }
        }
        List<Integer> list = new LinkedList<>();
        for(int i=0;i<arr.length;i++){
            list.add(arr[i]);
        }

        Collections.sort(list,(n1,n2)->{
            int f1=map.get(n1);
            int f2=map.get(n2);

            if(f1!=f2) return f2-f1;
            else{
                return list.indexOf(n1)-list.indexOf(n2);
            }
        });
        System.out.println(list);



    }

    void sortStringFreq(String s){
        HashMap<Character,Integer> map = new HashMap<>();

        for(int i=0;i<s.length();i++){
            if(map.containsKey(s.charAt(i))){
                map.put(s.charAt(i),map.get(s.charAt(i))+1);
            } else {
                map.put(s.charAt(i), 1);
            }
        }

        List<Character> list = new LinkedList<>();
        StringBuilder str = new StringBuilder();
        for(int i=0;i<s.length();i++){
            list.add(s.charAt(i));
        }

        Collections.sort(list,(n1,n2)->{
            int f1=map.get(n1);
            int f2=map.get(n2);

            if(f1!=f2){
                return f2-f1;
            } else{
                return n1-n2;
            }
        });
        for(int i=0;i<list.size();i++){
            str.append(list.get(i));
        }
        System.out.println(str.toString());
    }

    void countDistint(int[] arr){
        Arrays.sort(arr);
        int i=0;
        int j=0;
        int cnt=1;
        while (j<arr.length){
            if(arr[i]!=arr[j]){
                cnt++;
                i=j;
            }
            j++;
        }
        System.out.println(cnt);
    }

    void countDistint2(int[] arr){
      HashMap<Integer,Integer> map = new HashMap<>();

      for(int i=0;i<arr.length;i++){
          if(map.containsKey(arr[i])) {
              map.put(arr[i], map.get(arr[i]) + 1);
          } else{
              map.put(arr[i],1);
          }
      }
        System.out.println(map.size());
    }

    void findRepeatingElem(int[] arr){
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i=0;i<arr.length;i++){
            if(map.containsKey(arr[i])) {
                map.put(arr[i], map.get(arr[i]) + 1);
            } else{
                map.put(arr[i],1);
            }
        }
        int cnt=0;
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            if(entry.getValue()>1){
                System.out.print(entry.getKey()+" ");
            }
        }

    }

    void findNonRepeating2(int[] arr){
        Arrays.sort(arr);
        for(int i=0;i<arr.length;i++){
            if(i==0){
                if(arr[i]!=arr[i+1]){
                    System.out.print(arr[i]+" ");
                }
            }
          else   if(i==arr.length-1){
                if(arr[i]!=arr[i-1]){
                    System.out.print(arr[i]+" ");
                }
            }
            else if ( arr[i-1]!=arr[i]  && arr[i+1]!=arr[i]){
                System.out.print(arr[i]+" ");
            }
        }
    }
    void findRepeating2(int[] arr){

           for(int i=0;i<arr.length;i++){
               int flag=0;
               while (i<arr.length-1 && arr[i]==arr[i+1]){
                   flag=1;
                   i++;
               }
               if(flag==1){
                   System.out.println(arr[i-1]);
               }
           }
        }

        void removeDupSorted(int[] arr){
        Arrays.sort(arr);
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(arr[0]);
        int i=0;
        int j=1;
        while (j<arr.length){
            if(arr[i]!=arr[j]){
                ans.add(arr[j]);
                i=j;
            }
            j++;
        }
            System.out.println(ans);
        }

        void removeDupSortedInPlace(int[] arr){
        Arrays.sort(arr);
        int i=0;
        int j=1;
        while (j<arr.length){
            if(arr[i]!=arr[j]){
                i++;
                arr[i]=arr[j];
            }
            j++;
        }
            System.out.println(Arrays.toString(arr));
        }

        void removeDupUnSorted(int[] arr){
        int n= arr.length;
        boolean[] isVis = new boolean[n];
        Arrays.fill(isVis,true);

        for(int i=0;i<n;i++){
            if(!isVis[i]) continue;
            for(int j=i+1;j<n;j++){
                if(arr[i]==arr[j]){
                    isVis[j]=false;
                }
            }
        }
        for(int i=0;i<n;i++){
            if(isVis[i]){
                System.out.print(arr[i]+" ");
            }
        }
        }

        void symmenticPair(int[][] arr){
        int n= arr.length;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<n;i++){
            int first = arr[i][0];
            int sec = arr[i][1];

            Integer val = map.get(sec);

            if( val!=null && val==first){
                System.out.print(first + " " + sec);
                System.out.println();
            } else{
                map.put(first,sec);
            }
        }
        }

        boolean DisJoint(int[] arr1,int[] arr2){
        HashSet<Integer> set = new HashSet<>();
        for(int i=0;i<arr1.length;i++){
            set.add(arr1[i]);
        }
        for(int i=0;i<arr2.length;i++){
            if(set.contains(arr2[i])){
                return false;
            }
        }
        return true;
        }

        boolean makeEqual(int[] arr){

        for(int i=0;i<arr.length;i++){
            while (arr[i]%2==0){
                arr[i]=arr[i]/2;
            }
            while (arr[i]%3==0){
                arr[i]=arr[i]/3;
            }
        }
        for(int i=1;i<arr.length;i++){
            if(arr[i]!=arr[i]){
                return false;
            }
        }
        return true;
        }

        void sortByAnotherArray(int[] arr1,int[] arr2){
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i=0;i<arr1.length;i++){
            if(map.containsKey(arr1[i])){
                map.put(arr1[i],map.get(arr1[i])+1);
            } else{
                map.put(arr1[i],1);
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i=0;i<arr2.length;i++){
            if(map.containsKey(arr2[i])){
                for(int j=0;j<map.get(arr2[i]);j++){
                    ans.add(arr2[i]);
                }
                map.remove(arr2[i]);
            }
        }
            ArrayList<Integer> ans1 = new ArrayList<>();
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            for(int i=0;i<entry.getValue();i++){
                ans1.add(entry.getKey());
            }
        }
        Collections.sort(ans1);
       ans.addAll(ans1);
            int[] ansA = new int[ans.size()];
        for(int i=0;i<ans.size();i++){
            ansA[i]=ans.get(i);
        }
        }

        int eqiIndex(int[] arr){
        int n= arr.length;
         int[] sumA = new int[n];
         int sum=0;
         for(int i=0;i<n;i++){
             sum+=arr[i];
             sumA[i]=sum;
         }
         int ts =sumA[n-1];
         for(int i=0;i<n;i++){
             int ls = sumA[i]-arr[i];
             int rs = ts-sumA[i];
             if(ls==rs){
                 return i;
             }
         }
         return -1;
        }

        int eqiIndex2(int[] arr){
        int sum=0;
        for(int i=0;i<arr.length;i++){
            sum+=arr[i];
        }
        int ls=0;
        int rs=sum;
        for(int i=0;i<arr.length;i++){
            rs=rs-arr[i];
            if(rs==ls){
                return i;
            }
            ls+=arr[i];
        }
        return -1;
        }


    private void swap(int[] arr, int i, int j) {
        int temp=arr[j];
        arr[j]=arr[i];
        arr[i]=temp;
    }

    public static void main(String[] args) {
        Question q1= new Question();
        int arr1[] = {1, 2, 3, 5,3,2,1};
//        int arr2[] = {4, 2, 1, 3};
     //   int arr[][] = {{10,20}, {30,40}, {50,60}, {20,10}, {40,30}};
        String s="fccaaaaaabbbbbrrr";
        q1.eqiIndex(arr1);



    }
}
