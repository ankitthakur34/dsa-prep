package string;

public class Questions {

    void convert24(String s){
       int n=s.length();

       StringBuilder str = new StringBuilder();
       String hr = s.substring(0,2);
       String tr = s.substring(3,5);
        int hrt = Integer.parseInt(hr);

        char t = s.charAt(n-2);


        if(t=='a'){
            if(hrt==12){
                hrt=00;
            }
        } else{
            if(hrt!=12){
                hrt=hrt+12;
            }
        }
        String nt = Integer.toString(hrt);
        if(nt.length()==1){
            nt='0'+nt;
        }

        str.append(nt+":"+tr);
        System.out.println(str);
    }

    boolean palindrome(String s){
        int n= s.length();
        int i=0;
        int j=n-1;

        while (i<j){
            if(s.charAt(i)!=s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
    String reverseS(String s){
        StringBuilder str = new StringBuilder(s);
        int i=0;
        int j=s.length()-1;
        while (i<j){
            swap(str,i,j);
            i++;
            j--;
        }
        s=str.toString();
        return s;

    }

    void findASCII(char ch){

        int n =  'a'+1;
        System.out.println(n);
        char c = 'a'+1;
        System.out.println(c);

    }

    private void swap(StringBuilder str, int i, int j) {
        char ch=str.charAt(i);
        str.setCharAt(i,str.charAt(j));
        str.setCharAt(j,ch);

    }

   void removeVowels(String s){
        StringBuilder str = new StringBuilder();

        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch!='a' && ch!='e' && ch!='i' && ch!='o' && ch!='u'){
                str.append(ch);
            }
        }
        // using regex
       s= s.replaceAll("[aeiouAEIOU]","");
       System.out.println(s);
       System.out.println(str.toString());
   }

   void removeSpace(String s){
       StringBuilder str = new StringBuilder();
       for(int i=0;i<s.length();i++){
           char ch = s.charAt(i);
           if(ch!=' '){
               str.append(ch);
           }
       }
        s=s.replaceAll(" ","");
       System.out.println(s);
       System.out.println(str);
   }

   void removeSpecial(String s){
//        s=s.replaceAll("[^a-zA-Z]","");
//       System.out.println(s);
       StringBuilder str = new StringBuilder();
       for(int i=0;i<s.length();i++){
           char ch = s.charAt(i);
           if(ch>=97 && ch<=122 || ch>=65 && ch<=91){
               str.append(ch);
           }
       }
       System.out.println(str.toString());
   }

   void removeBracket(String s){
        s=s.replaceAll("[()]","");
       System.out.println(s);
   }

void sumOfNumbers(String s){
          StringBuilder str = new StringBuilder();
          int sum=0;
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch>=48 && ch<=57){
            sum+=ch-'0';
            }
        }
    System.out.println(sum);

}
    public static void main(String[] args) {
        Questions q1 = new Questions();
        String s="12dd3gg4t5";
        char ch ='a';
     q1.sumOfNumbers(s);
    }
}
