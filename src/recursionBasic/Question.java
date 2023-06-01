package recursionBasic;

public class Question {
    public  int sumN(int n){
        if (n == 1) {
            return 1;
        }
        return n+ sumN(n-1);
    }

    public int sumBtw2(int a,int b){

        if(a==b){
            return b;
        }

        return a+sumBtw2(a+1,b);
    }
    public static void main(String[] args) {
        Question q = new Question();
        System.out.println(q.sumBtw2(5,7));

    }
}

