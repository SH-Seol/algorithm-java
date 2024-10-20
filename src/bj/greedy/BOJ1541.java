package bj.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BOJ1541 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        ArrayList<Integer> nums = new ArrayList<>();
        ArrayList<Character> ops = new ArrayList<>();
        boolean isMinus = false;
        int result = 0;

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if(Character.isDigit(c)) {//숫자인 경우
                sb.append(c);
            }
            else{//숫자가 아닌 경우
                if(c == '+' || c == '-') {
                    ops.add(c);
                }
                nums.add(Integer.parseInt(sb.toString()));
                sb.setLength(0);
            }
        }
        if(sb.length() > 0) {
            nums.add(Integer.parseInt(sb.toString()));
        }
        result = nums.get(0);
        for(int i = 1; i < nums.size(); i++) {
            if(ops.get(i - 1) == '-'){
                isMinus = true;
            }
            if(isMinus){//음수인경우
                result -= nums.get(i);
            }
            else{
                result += nums.get(i);
            }
        }
        System.out.println(result);
    }
}
