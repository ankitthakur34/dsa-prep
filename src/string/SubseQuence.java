package string;

import java.util.ArrayList;

public class SubseQuence {

    void printSubse(String s,String ans){

        if(s.isEmpty()){
            System.out.print(ans+" ");
            return;
        }
        char ch = s.charAt(0);
        printSubse(s.substring(1),ans+ch);
        printSubse(s.substring(1),ans);
    }

    void printSubseR(String s, ArrayList<String> list, String ans){

        if(s.isEmpty()){
            list.add(ans);
            return;
        }
        char ch = s.charAt(0);
        printSubseR(s.substring(1),list,ans+ch);
        printSubseR(s.substring(1),list,ans);
    }

    ArrayList<String> printSubseR2(String s, String ans){

        if(s.isEmpty()){
            ArrayList<String> list = new ArrayList<>();
            list.add(ans);
            return list;
        }
        char ch = s.charAt(0);
      ArrayList<String> left=  printSubseR2(s.substring(1),ans+ch);
      ArrayList<String> right=  printSubseR2(s.substring(1),ans);

      left.addAll(right);
      return left;
    }

    public static void main(String[] args) {
        SubseQuence q1 = new SubseQuence();
        String s="abc";
      //  ArrayList<String> list   = new ArrayList<>();
        ArrayList<String> list =  q1.printSubseR2(s,"");
        System.out.println(list);
    }
}
