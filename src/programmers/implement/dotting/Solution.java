package programmers.implement.dotting;

class Solution {
    public long solution(int k, int d) {
        long ans = 0;
        //각 x좌표마다의 y좌표 끝값을 나타내기 위함
        long tmp = (long) (d / k) * k;
        long rd = (long) d * d;
        for(long i = 0; i <= d; i += k){
            long dist = tmp * tmp + i * i;
            //거리가 실제 거리 d*d보다 작을 때까지 tmp에 k를 빼고 dist를 제정의한다.
            while(dist > rd){
                tmp -= k;
                dist = tmp * tmp + i * i;
            }
            ans += tmp / k + 1;
        }
        return ans;
    }
}