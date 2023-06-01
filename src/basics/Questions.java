package basics;

public class Questions {

    public void evenOdd(int n){
        if((n&1)==0){
            System.out.println("even");
        }else{
            System.out.println("odd");
        }
    }

    public void sumOfN(int n){
        int sum = (n*(n+1))/2;
        System.out.println(sum);
    }

    public static void main(String[] args) {
        Questions q1= new Questions();
        q1.sumOfN(5);
    }
}
