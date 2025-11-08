package programmers.greedy.makebignum;

class Solution {
    public String solution(String number, int k) {//순서 유지 제일 큰 수를 잡고 넣으면 됨
        char[] chars = number.toCharArray();
        StringBuilder sb = new StringBuilder();
        int start = 0;
        while(true){
            int idx = start;
            for(int i = start; i <= start + k; i++){
                if(chars[idx] < chars[i]){
                    idx = i;
                }
            }
            sb.append(chars[idx]);
            k -= (idx - start);
            start = idx + 1;
            if(chars.length - start == k){
                break;
            }
            if(k == 0){
                for(int i = start; i < chars.length; i++){
                    sb.append(chars[i]);
                }
                break;
            }
        }
        String answer = sb.toString();
        return answer;
    }
}
