package Week9;

import java.util.HashSet;
import java.util.Queue;
import java.util.Scanner;

public class HashSetHackkerrank {

    public static void main(String[] args) {
        HashSet<String> set = new HashSet<>();
        Scanner input = new Scanner(System.in);
        int n  = input.nextInt();
        for(int i = 0; i < n+1; i++){
            String tmp = input.nextLine();
            tmp = tmp.trim();
            if(!tmp.isEmpty()){
                set.add(tmp);
                System.out.println(set.size());
            }
        }
    }
}