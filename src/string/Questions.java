package string;

import java.util.*;

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

void sumOfDigit(String s){
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

void sumOfNumber(String s){
        String tempSum="";
    int sum=0;
    for(int i=0;i<s.length();i++){
        char ch = s.charAt(i);
        if(ch>=48 && ch<=57){
            tempSum+=ch;
        } else{
            sum+=Integer.parseInt(tempSum);
            tempSum="0";
        }
    }
    System.out.println(sum+Integer.parseInt(tempSum));
}

void capiFirstnLast(String s){

        s=s.trim();
   // int n=s.length()-1;
        StringBuilder str = new StringBuilder(s);

        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            if(i==0 || i==str.length()-1){
                str.setCharAt(i,Character.toUpperCase(ch));
            }
            if(ch==' '){
                str.setCharAt(i-1,Character.toUpperCase(str.charAt(i-1)));
                str.setCharAt(i+1,Character.toUpperCase(str.charAt(i+1)));
            }
        }
        s=str.toString();
    System.out.println(s);
}

void freqChar(String s){
    HashMap<Character,Integer> map = new HashMap<>();
    for(int i=0;i<s.length();i++){
        char ch = s.charAt(i);
        if(ch==' ')continue;
        if(map.containsKey(ch)){
            map.replace(ch,map.get(ch)+1);
        } else {
            map.put(ch, 1);
        }
    }
    for(Map.Entry<Character,Integer> e : map.entrySet()){
        System.out.println(e.getKey() +" "+ e.getValue());
    }
}

void freqChar2(String s){
        int[] arr = new int[26];
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch>='a'&& ch<='z') {
                arr[ch - 'a']++;
            }
        }
        for(int i=0;i<26;i++){
            if(arr[i]!=0){
                System.out.println( (char)(i+'a') +" "+ arr[i] );
            }
        }

    System.out.println(Arrays.toString(arr));
}

 void sortByFreq(String s){
     HashMap<Character,Integer> map = new HashMap<>();
     for(int i=0;i<s.length();i++){
         char ch = s.charAt(i);
         if(ch==' ')continue;
         if(map.containsKey(ch)){
             map.replace(ch,map.get(ch)+1);
         } else {
             map.put(ch, 1);
         }
     }
     while (!map.isEmpty()){

         int maxV=Integer.MIN_VALUE;
         char macK='a';
         for(Map.Entry<Character,Integer> e : map.entrySet()){
             if(e.getValue()>maxV){
                 maxV=e.getValue();
                 macK=e.getKey();
             }
         }
         map.remove(macK);
         for(int i=0;i<maxV;i++){
             System.out.print(macK+" ");
         }
     }
 }

 void sortFreq2(String s){
     HashMap<Character,Integer> map = new HashMap<>();
     for(int i=0;i<s.length();i++){
         char ch = s.charAt(i);
//         if(ch==' ')continue;
         if(map.containsKey(ch)){
             map.replace(ch,map.get(ch)+1);
         } else {
             map.put(ch, 1);
         }
     }
     List<Character> list = new LinkedList<>();

     for(int i=0;i<s.length();i++){
         list.add(s.charAt(i));
     }

     list.sort((n1, n2) -> {
         int f1 = map.get(n1);
         int f2 = map.get(n2);

         if (f1 != f2) return f1-f2;
         else {
             return list.indexOf(n1) - list.indexOf(n2);
         }
     });
     System.out.println(list);
 }

 boolean anagram(String s1,String s2){
        int n= s1.length();
        int m=s2.length();

        if(n!=m){
       //     System.out.println("not anagram");
            return false;
        }
        HashMap<Character,Integer> map = new HashMap<>();

        for(int i=0;i<n;i++){
            char ch = s1.charAt(i);
            if(map.containsKey(ch)){
                map.replace(ch,map.get(ch)+1);
            } else {
                map.put(ch, 1);
            }
        }

        for(int i=0;i<m;i++){
            char ch = s2.charAt(i);
            if(!map.containsKey(ch)){
                return false;
            } else{
                if(map.get(ch)>1){
                    map.replace(ch,map.get(ch)-1);
                } else{
                    map.remove(ch);
                }
            }
        }
        if(map.size()==0){
            return true;
        }
        return false;
 }

 void toggleLetter(String s){
        StringBuilder ans = new StringBuilder();
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch>='a' && ch<='z'){
                ans.append( (char)( ch - 32));
            } else{
                ans.append((char) (ch+32));
            }
        }
     System.out.println(ans);
 }

 void cntWords(String s){
        s=s.trim();
        Stack<String> stack = new Stack<>();
        int i=0;
        int j=0;
        int max=0;
        int maxI=0;
        int maxe=0;
        while (i<s.length()){

            while (j<s.length() && s.charAt(j)!=' '){
                j++;
            }
            stack.add(s.substring(i,j));
           int maxL=j-i;
          if(maxL>max){
              maxI=i;
              maxe=j;
              max=maxL;
          }
            while (j<s.length() && s.charAt(j)==' '){
                j++;
            }

            i=j;


        }


     System.out.println(" number 0f words"+ stack.size());
     System.out.println("largest word l "+ s.substring(maxI,maxe));
      StringBuilder ans = new StringBuilder();
     while (!stack.isEmpty()){
         if(ans.isEmpty()) {
             ans.append(stack.pop());
         } else{
             ans.append(" "+ stack.pop());
         }
        }
     System.out.println(ans);
 }

 String removeOuterPara(String s){
        Stack<Character> st = new Stack<>();
        StringBuilder ans = new StringBuilder();

        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                if(st.size()>0){
                    ans.append('(');
                }
                st.push('(');
            } else{
                st.pop();
                if(st.size()>0){
                    ans.append(')');
                }

            }
        }
        return ans.toString();
 }
 // ["flower","flow","flight"]
 String commonprefix(String[] arr){

        String curr= arr[0];

        int j=0;
        for(int i=1;i<arr.length;i++){
            j=0;
            while (j<curr.length() && j<arr[i].length() && arr[i].charAt(j)==curr.charAt(j) ){
                j++;
            }
            if(j==0){
                return "";
            }
            curr=curr.substring(0,j);

        }
return curr;
 }

 boolean isoMorphic(String s,String t){
        HashMap<Character,Character> map1=new HashMap<>();
        HashMap<Character,Integer> map2=new HashMap<>();

        if(s.length()!=t.length()) return false;

        for(int i=0;i<s.length();i++){
            char ch1 = s.charAt(i);
            char ch2 = t.charAt(i);

            if(map1.containsKey(ch1)){
                if(map1.get(ch1)!=ch2){
                    return false;
                }
            } else if(map2.containsKey(ch2)){
                return false;
            }
             else {
                map1.put(ch1, ch2);
                map2.put(ch2, 1);
            }
        }
        return true;
 }

  int romanToInt(String s){
        HashMap<Character,Integer> map = new HashMap<>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);

        int sum=0;
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);

            if(ch=='V' || ch=='X'){
                if(s.charAt(i-1)=='I') sum+=-2;
            }
            if(ch=='L' || ch=='C'){
                if(s.charAt(i-1)=='X') sum+=-20;
            }
            if(ch=='D' || ch=='M'){
                if(s.charAt(i-1)=='C') sum+=-200;
            }

            sum+=map.get(ch);

        }
        return sum;

  }

  void nextLexicographicalOrder(String s){
        StringBuilder ans = new StringBuilder();
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch=='z' || ch=='Z'){
                ans.append((char) (ch-25));
            } else {
                ans.append((char) (ch + 1));
            }
        }
      System.out.println(ans);
  }

  boolean validPara(String s){
        Stack<Character> st = new Stack<>();

        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);

            if(ch=='(' || ch=='{' || ch=='['){
                st.push(ch);
            } else{
                if(ch==')'){
                    if(st.isEmpty() || st.peek()!='('){
                        return false;
                    } else{
                        st.pop();
                    }
                }
                if(ch=='}'){
                    if(st.isEmpty() || st.peek()!='{'){
                        return false;
                    } else{
                        st.pop();
                    }
                } if(ch==']'){
                    if(st.isEmpty() || st.peek()!='['){
                        return false;
                    } else{
                        st.pop();
                    }
                }
            }
        }
        return st.isEmpty();
  }

  int minAddToMakeParaValid(String s){
        Stack<Character> st = new Stack<>();

        for(int i=0;i<s.length();i++){
            char ch = s.charAt(0);

            if(ch=='('){
                st.push(ch);
            } else{
                if(!st.isEmpty() && st.peek()=='(' ){
                    st.pop();
                } else{
                    st.push(ch);
                }
            }
        }
        return st.size();
  }

  boolean redudantBracket(String s){
        Stack<Character> st = new Stack<>();
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch=='(' || ch=='+' || ch=='-' || ch=='*' || ch=='/' ){
                st.push(ch);
            } else{
                if(st.peek()=='('){
                    return true;
                }
                while (st.peek()!='('){
                    st.pop();
                }
                st.pop();
            }
        }
        return false;
  }
    public static void main(String[] args) {
        Questions q1 = new Questions();
        String s="anAkiiOZtz";
        String s1 ="bab";
        q1.nextLexicographicalOrder(s);
   }
}
