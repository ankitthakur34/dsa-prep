package patterns;

public class Questions {

    void squre(int n){

        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    void hollowSqure(int n){
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                if(i==1 || i==n || j==1 || j==n) {
                    System.out.print("* ");
                } else{
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }

    void rhombus(int n){
        for(int i=1;i<=n;i++){

            for(int s=1;s<=n-i;s++){
                System.out.print(" ");
            }

            for(int j=1;j<=n;j++){
                System.out.print("* ");
            }
            System.out.println();
        }
    }


    void halfPyramid(int n){
        // row
        for(int i=1;i<=n;i++){


            // column
            for(int j=1;j<=i;j++){
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    void invertedHalfPyra(int n){

        for(int i=1;i<=n;i++){
            for(int j=1;j<=n-i+1;j++){
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    void fullPyramid(int n){

        for(int i=1;i<=2*n-1;i++){

            int col = (i<=n)?i:2*n-i;
            for(int j=1;j<=col;j++){
                System.out.print("* ");
            }
            System.out.println("  ");
        }
    }

    void triangle(int n){
        // row
        for(int i=1;i<=n;i++){

            // space
            for(int s=1;s<=n-i;s++){
                System.out.print(" ");
            }
            // column
            for(int j=1;j<=i;j++){
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    void triangleInverted(int n){
        // row
        for(int i=1;i<=n;i++){

            // space
            for(int s=1;s<=i;s++){
                System.out.print(" ");
            }
            // column
            for(int j=1;j<=n-i+1;j++){
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    void triangleNumber(int n){
        // row
        for(int i=1;i<=n;i++){

            // space
            for(int s=1;s<=n-i;s++){
                System.out.print(" ");
            }
            // column
            for(int j=1;j<=i;j++){
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }

    void daimond(int n){

        for(int i=1;i<=2*n-1;i++){

            int space=(i<=n)?n-i:i-n;
            int col=(i<=n)?i:2*n-i;

            for(int s=1;s<=space;s++){
                System.out.print(" ");
            }

            for(int j=1;j<=col;j++){
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    void palindrome(int n){

        for(int i=1;i<=n;i++){

            for(int s=1;s<=n-i;s++){
                System.out.print("  ");
            }

            for(int j=i;j>=1;j--){
                System.out.print(j+" ");
            }
            for(int j=2;j<=i;j++){
                System.out.print(j+" ");
            }
            System.out.println();
        }
    }

    void butterFly(int n){

        for(int i=1;i<=2*n-1;i++){

            int col=(i<=n)?i:2*n-i;

            for(int j=1;j<=col;j++){
                System.out.print("* ");
            }
            int space=2*n-(2*col+1);

            for(int s=1;s<=space;s++){
                System.out.print("  ");
            }
                  int line = (i==4)?3:col;
            for(int j=1;j<=line;j++){
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    void pascalTri(int n){
        int[][] arr = new int[5][5];

        for(int i=0;i<n;i++){

            for(int s=0;s<n-i;s++){
                System.out.print(" ");
            }

            for(int j=0;j<=i;j++){
                if(j==0 || i==j){
                    arr[i][j]=1;
                } else{
                    arr[i][j]=arr[i-1][j]+arr[i-1][j-1];
                }

                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Questions q1 = new Questions();
        q1.pascalTri(5);
    }

}
