package programmers.implement.newname;

import java.util.*;

public class Solution {
    public String solution(String new_id) {
        //1 대문자 소문자로 치환
        new_id = new_id.toLowerCase();
        StringBuilder sb = new StringBuilder();
        //2
        for(int i = 0; i < new_id.length(); i++){
            //소문자
            if(new_id.charAt(i) >= 'a' && new_id.charAt(i) <= 'z'){
                sb.append(new_id.charAt(i));
            }
            //숫자
            if(new_id.charAt(i) >= '0' && new_id.charAt(i) <= '9'){
                sb.append(new_id.charAt(i));
            }
            // -, _, .
            if(new_id.charAt(i) == '-' || new_id.charAt(i) == '_' || new_id.charAt(i) == '.'){
                sb.append(new_id.charAt(i));
            }
        }
        //3 마침표가 2번 이상 연속된 경우 하나로 치환 문제 발생
        boolean flag = false;
        int idx = 0;
        while(true){
            if(idx == sb.length()){
                break;
            }
            if(sb.charAt(idx) == '.'){
                if(flag){
                    sb.deleteCharAt(idx);
                }
                else{
                    flag = true;
                    idx++;
                }
            }
            else{
                flag = false;
                idx++;
            }
        }



        //4마침표가 처음이나 끝에 위치하면 제거
       if(sb.length()!= 0){
           if(sb.charAt(0) == '.'){
               sb.deleteCharAt(0);
           }
       }
       if(sb.length() != 0){
           if(sb.charAt(sb.length()-1) == '.'){
               sb.deleteCharAt(sb.length()-1);
           }
       }
        //5 빈 문자열이라면 a를 대입
        if(sb.length() == 0) {
            sb.append("a");
        }

        //6 길이가 16자 이상이면 첫 15개의 문자 제외한 나머지 제거
        if(sb.length() > 16){
            sb.delete(15, sb.length());
            if(sb.charAt(sb.length()-1) == '.'){
                sb.deleteCharAt(sb.length()-1);
            }
        }
        if(sb.length() == 16){
            sb.deleteCharAt(15);
            if(sb.charAt(sb.length()-1) == '.'){
                sb.deleteCharAt(sb.length()-1);
            }
        }
        //7 길이가 2자 이하라면 길이가 3이 될 때까지 마지막 글자 추가
        while(sb.length() < 3){
            sb.append(sb.charAt(sb.length()-1));
        }
        return sb.toString();
    }
}