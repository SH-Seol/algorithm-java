package programmers.implement.country124;

class Solution {
    public String solution(int n) {
        StringBuilder sb = new StringBuilder();
        if(n == 1){
            return "1";
        }
        else if(n == 2){
            return "2";
        }
        else if(n == 3){
            return "4";
        }
        while(n != 0){
            if(n % 3 == 0){
                sb.append(4);
                n = n/3 - 1;
            }
            else if(n % 3 == 1){
                sb.append(1);
                n/=3;
            }
            else{
                sb.append(2);
                n/=3;
            }
        }

        return sb.reverse().toString();
    }
}