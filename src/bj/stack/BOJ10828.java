package bj.stack;

import java.util.Scanner;
import java.util.Stack;

public class BOJ10828 {

    static Stack<Integer> stack = new Stack<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            String command = sc.next();
            if(command.equals("push")){
                stack.push(sc.nextInt());
            }
            else{
                System.out.println(st(command));
            }
        }
    }

    public static int st(String command){
        if(command.equals("pop")){
            return stack.isEmpty() ? -1 : stack.pop();
        }
        else if(command.equals("top")){
            return stack.isEmpty() ? -1 : stack.peek();
        }
        else if(command.equals("size")){
            return stack.size();
        }
        else if(command.equals("empty")){
            return stack.isEmpty() ? 1 : 0;
        }
        else{
            return 0;
        }
    }
}
