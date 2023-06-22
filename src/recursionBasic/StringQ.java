package recursionBasic;

public class StringQ {

    String skipChar(String s,String ans){

        if(s.isEmpty()){
            return ans ;
        }
        char ch = s.charAt(0);
        if(ch=='a'){
          return    skipChar(s.substring(1),ans);
        } else {
         return    skipChar(s.substring(1), ans + ch);
        }
    }

    public static void main(String[] args) {
        StringQ q1 = new StringQ();
        String s = "abaacdaaass";
        String ans ="";
     String s1= q1.skipChar(s,ans);
        System.out.println(s1);

    }
}
