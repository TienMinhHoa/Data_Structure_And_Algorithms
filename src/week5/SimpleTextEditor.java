package week5;

import java.util.Scanner;
import java.util.Stack;

public class SimpleTextEditor {
    public static Stack<String> st = new Stack<>();
    public static void main(String[] args){
        StringBuilder s = new StringBuilder();
        st.push(String.valueOf(s));
        Scanner input = new Scanner(System.in);
        int q = input.nextInt();
        for(int i = 0; i < q; i++){
            int ops = input.nextInt();
            switch (ops){
                case 1:
                    String w = input.nextLine();
                    s.append(w);
                    st.push(String.valueOf(s));
                    break;
                case 2:
                    int k = input.nextInt();
                    while(k>0){
                        s.deleteCharAt(s.length()-1);
                        k--;
                    }
                    st.push(String.valueOf(s));
                    break;
                case 3:
                    int index = input.nextInt();
                    System.out.println(s.charAt(index));
                    break;
                case 4:
                    st.pop();
                    s = new StringBuilder(st.peek());
            }
            System.out.println(s);
        }
    }
}
