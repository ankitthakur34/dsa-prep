package matrix;
import java.util.*;

public class Questions {
    Scanner sc = new Scanner(System.in);
    void input2D(){
        int n=sc.nextInt();
        int m=sc.nextInt();
        int[][] arr = new int[n][m];

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                arr[i][j]=sc.nextInt();
            }
        }
        print2D(arr);
    }

    void print2D(int[][] arr){
        int n=arr.length;
        for(int i=0;i<n;i++){
            for(int j=0;j<arr[i].length;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }

    int rowWithMax1s(int arr[][], int n, int m) {
        int max=0;
        int cnt=0;
        int row=-1;
        for(int i=0;i<n;i++){
            cnt=0;
            for(int j=0;j<arr[i].length;j++){
                if(arr[i][j]==1){
                    cnt++;
                }
            }
           if(cnt>max){
               max=cnt;
               row=i;
           }
        }
        return row;
    }

    int[] linearS(int[][] arr,int key){
        int n=arr.length;

        for(int i=0;i<n;i++){
            for(int j=0;j<arr[i].length;j++){
                if(arr[i][j]==key){
                    return new int[]{i,j};
                }
            }
        }
        return new int[]{-1,-1};
    }

    int[] search2D(int[][] arr,int key){
        int n= arr.length;

        int s=0;
        int e=n-1;

        while (s<n && e>=0){

            if(arr[s][e]==key){

                return new int[]{s,e};
            }

           else if(arr[s][e]>key){
                e--;
            }
           else{
               s++;
            }

        }
        return new int[]{-1,-1};
    }

    void commonElem(int[][] mat){
        int n= mat.length;
        int m=mat[0].length;
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i=0;i<m;i++){
            map.put(mat[0][i],1);
        }

        for(int i=1;i<n;i++){
            for(int j=0;j<m;j++){
                if(map.containsKey(mat[i][j])){
                    if(map.get(mat[i][j])==i){
                        map.put(mat[i][j],map.get(mat[i][j])+1);
                    }
                }
            }
        }
        for(Map.Entry<Integer,Integer> e : map.entrySet()){
            if(e.getValue()==n){
                System.out.println(e.getKey()+ " ");
            }
        }
    }

    public void setZeroes(int[][] matrix) {
        int n= matrix.length;
        int m= matrix[0].length;

        int row[] = new int[n];
        int[] col = new int[m];
        Arrays.fill(row,-1);
        Arrays.fill(col,-1);

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(matrix[i][j]==0){
                    row[i]=0;
                    col[j]=0;
                }
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(row[i]==0 || col[j]==0){
                    matrix[i][j]=0;
                }
            }
        }


    }

    void transposeMatrix(int[][] arr){
        int n= arr.length;
        int m= arr[0].length;
        for(int i=0;i<n;i++){
            for(int j=i;j<m;j++){
                swap(arr,i,j);
            }
        }
        print2D(arr);
    }

    void reverseRow(int[][] arr){
      //  transposeMatrix(arr);
        int n= arr.length;
        int m= arr[0].length;
        for(int i=0;i<n;i++){
            int s=0;
            int e=arr[i].length-1;
            while (s<=e) {
                int temp=arr[i][s];
                arr[i][s]=arr[i][e];
                arr[i][e]=temp;
                s++;
                e--;
            }
        }
        print2D(arr);
    }

    void rotate90cc(int[][] arr){
        int n= arr.length;
        int m=arr[0].length;

        int[][] rotated = new int[n][m];

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                rotated[j][m-i-1]=arr[i][j];
            }
        }
        print2D(rotated);
    }

    void printSpiral(int[][] arr){
       int n= arr.length;
       int m= arr[0].length;

       int top=0;
       int left=0;
       int right=n-1;
       int bottom=m-1;
        ArrayList<Integer> list = new ArrayList<>();

       while (top<=bottom && right>=left){

           for(int i=top;i<=right;i++){
               list.add(arr[top][i]);
           }
           top++;

           for(int i=top;i<=bottom;i++){
               list.add(arr[i][right]);
           }
           right--;

           if(top<=bottom) {
               for (int i = right; i >= left; i--) {
                   list.add(arr[bottom][i]);
               }
               bottom--;
           }
           if(right>=left) {
               for (int i = bottom; i >= top; i--) {
                   list.add(arr[i][left]);
               }
               left++;
           }
       }
    }

    void rotate90c(int[][] arr){
        transposeMatrix(arr);
        reverseRow(arr);

    }

    void sortRows(int[][] arr){
        int n= arr.length;
        int m= arr[0].length;

        ArrayList<Integer> ans = new ArrayList<>();

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                ans.add(arr[i][j]);
            }
        }
        System.out.println(ans);
        Collections.sort(ans);
        System.out.println(ans);
       int c=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                arr[i][j]=ans.get(c);
                c++;
            }
        }
        print2D(arr);
    }

    void reverseCols(int[][] arr){
        int n=arr.length;
        int m=arr[0].length;

        for(int i=0;i<m;i++){
            int s=0;
            int e=n-1;
            while(s<=e) {
                int temp=arr[s][i];
                arr[s][i]=arr[e][i];
                arr[e][i]=temp;
                s++;
                e--;
            }
        }
        print2D(arr);

    }

    private void swap(int[][] arr, int i, int j) {
        int temp=arr[i][j];
        arr[i][j]=arr[j][i];
        arr[j][i]=temp;

    }


    //    int[] binaryS(int[] arr,int key){
//
//    }
    public static void main(String[] args) {
        Questions q1= new Questions();
        int mat[][] =
                {
                        {1,6,3},
                        {8,5,6},
                        {7,88,9}
                };
        q1.print2D(mat);
        System.out.println();
        q1.reverseCols(mat);


    }
}
