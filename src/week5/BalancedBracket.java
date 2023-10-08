package week5;
import java.util.*;

import static java.util.stream.Collectors.joining;

class BalancedBracket {

    /*
     * Complete the 'isBalanced' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String isBalanced(String s) {
        if(s.length()%2!=0) return "NO";
        // Write your code here
        Stack<Character> st = new Stack<>();
        for(int i = 0; i < s.length();i++){
            if(s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '['){
                st.push(s.charAt(i));
            }
            else{
                if(st.size() == 0) return "NO";
                switch (s.charAt(i)){
                    case ')':{
                        if(st.peek()!= '(') return "NO";
                        st.pop();
                        break;
                    }
                    case ']':   {
                        if(st.peek()!= '[') return "NO";
                        st.pop();
                        break;
                    }
                    case '}':{
                        if(st.peek() !='{') return "NO";
                        st.pop();
                        break;
                    }
                }
            }
        }
        if(st.isEmpty())
            return "YES";
        return "NO";
    }

}