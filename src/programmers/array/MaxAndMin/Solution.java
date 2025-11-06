package programmers.array.MaxAndMin;

class Solution {
    public String solution(String s) {
        String[] sts = s.split(" ");
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(String num:sts){
            int n = Integer.parseInt(num);
            max = Math.max(n, max);
            min = Math.min(n, min);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(min).append(" ").append(max);

        return sb.toString();
    }
}
