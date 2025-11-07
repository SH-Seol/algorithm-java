package programmers.implement.magicelevator;

class Solution {
    public int solution(int storey) {
        int answer = 0;
        while(storey > 0){
            int num = storey % 10;
            if(num < 5){
                answer += num;
                storey -= num;
            }
            else if(num == 5){//5일 때는 빼는게 좋고 45일 때 빼는게 좋고 55일 때는? 5더하고 4더하고 1더하고?
                if(storey % 100 > 50){
                    storey += 5;
                }
                else{
                    storey -= 5;
                }
                answer += 5;
            }
            else{
                answer += (10 - num);
                storey += (10 - num);
            }
            storey /= 10;
        }
        return answer;
    }
}
