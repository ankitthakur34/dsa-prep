package string;

public class Questions {

    void convert24(String s){
        int n= s.length();
        StringBuilder str = new StringBuilder(s.substring(0,n-2));
        if(s.charAt(n-2)=='a'){
            char c1=s.charAt(0);
            char c2=s.charAt(1);
           if(c1=='1' && c2=='2'){
           //   s= s.replace(c1,'2');
              str.setCharAt(0,'2');
           //   s= s.replace(c2,'4');
               str.setCharAt(1,'4');
           }

        } else{
            if(s.charAt(0)=='1' && s.charAt(1)=='2'){
                System.out.println(str);
                return;
            }
            int c1=  s.charAt(0)-'0';
            int  c2=  s.charAt(1)-'0';

            int nc2=c2+2;
            char ch = (char) ((char) nc2+'0');
            System.out.println(ch);
            if(c2<8){
//                s=s.replace(s.charAt(0),'1');
                str.setCharAt(0,'1');
//                s=s.replace(s.charAt(1),ch);
                str.setCharAt(1,ch);
            }
            else{

                int nc3=c2+12;
                int i=1;
                while (nc3>0){
                    int ld=nc3%10;
                    nc3=nc3/10;
                    char ch1 =(char) ((char) ld+'0');
                    s=s.replace(s.charAt(i), ch1);
                    str.setCharAt(i,ch1);
                    i--;

                }
            }




        }
       // s=s.substring(0,s.length()-2);
        System.out.println(str);
    }



    public static void main(String[] args) {
        Questions q1 = new Questions();
        String s="11:24pm";
        q1.convert24(s);
    }
}
