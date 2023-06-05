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
    public void sumBtw2(int a,int b){
        int bS = (b*(b+1))/2;
        int aS = (a*(a+1))/2;

        int sum=(bS-aS)+a;
        System.out.println(sum);
    }
    public void leap(int n){
        if((n%400==0 )|| (n%4==0 && n%100!=0)){
            System.out.println("leap");
        } else{
            System.out.println("not a leap");
        }
    }
    public boolean prime(int n){
        boolean flag =true;
        for(int i=2;i<n;i++){
            if(n%i==0){
         flag=false;
         break;
            }
        }
//        if(flag==true){
//            System.out.println("prime");
//        } else{
//            System.out.println("not prime");
//        }
        return flag;
    }
    public void primeBtw2(int a,int b){
        for(int n=a;n<=b;n++){
            boolean flag = true;
            for(int i=2;i<n;i++){
                if(n%i==0){
                    flag=false;
                    break;
                }
            }
            if(flag){
                System.out.print(n+" ");
            }
        }
    }

    // pattern- last digit

    void sumOfDigit(int n){
        int sum=0;
        while (n>0) {
            int lastD = n % 10;
            n = n / 10;
            sum += lastD;
        }

        System.out.println(sum);

    }
    void numOfD(int n){
        int sum= (int) Math.log10(n)+1;
        System.out.println(sum);
    }

    int reverseNum(int n){
        int rev=0;
        while (n>0) {
            int lastD = n % 10;
            n = n / 10;
            rev=rev*10+lastD;
        }
       return rev;
    }

    void palindrome(int n){
        int og=n;
        int rev=reverseNum(n);
        if(og==rev){
            System.out.println("palin");
        }else{
            System.out.println("not");
        }
    }

    boolean armstrong(int n){
        int digit=(int) Math.log10(n)+1;
        int og=n;
        int arms=0;
        boolean flag=false;
        while (n>0){
            int ld=n%10;
            n=n/10;
            arms+=Math.pow(ld,digit);
        }
        if(arms==og){
            System.out.println("armstrong");
            flag=true;
        }
return flag;
    }

    void armstronNumbers(int a,int b){
        for(int i=a;i<=b;i++){
          boolean arms=  armstrong(i);
            if(arms){
                System.out.print(i+" ");
            }
        }
    }

    //fabo
    void fabonacci(int n){
        int og=n;
        int n1=0;
        int n2=1;
        System.out.print(n1+" "+n2+" ");
        int nextT=0;
        while (n!=2) {
             nextT = n1 + n2;
            n1 = n2;
            n2 = nextT;
            n--;
            System.out.print(nextT+" ");
        }
        System.out.println();
        System.out.println(og+ "th fibo term is "+ nextT);
    }
void fact(int n){
        int fact=1;
        for(int i=n;i>=1;i--){
            fact*=i;
        }
    System.out.println(fact);
}

void power(int n,int p){
        int pow=1;
        while (p!=0){
            pow*=n;
            p--;
        }
    System.out.println(pow);
}

void primeFactors(int n){
        int og=n;
        for(int i=2;i<og;i++){
            if(prime(i)){
                while (n!=0 && n%i==0){
                    System.out.print(i+" ");
                    n=n/2;
                }
            }
        }
}

void hcf(int a,int b){
        int ao=a;
        int bo=b;
        int rem=Integer.MAX_VALUE;
        while (rem!=0){
            rem=a%b;
            a=b;
            b=rem;
        }
    System.out.println("hcf is"+a);
    System.out.println("lcm is "+(ao*bo)/a);

}

    public static void main(String[] args) {
        Questions q1= new Questions();
        q1.hcf(36,24);
    }
}
