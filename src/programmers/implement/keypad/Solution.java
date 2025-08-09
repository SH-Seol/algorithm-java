package programmers.implement.keypad;

//왼손 시작 *, 오른손 시작 #
//1,4,7 왼손, 3, 6, 9 오른손, 2, 5, 8, 0은 가까운 곳, 같으면 왼손잡이는 왼손, 오른손 잡이는 오른손
//몇번 움직이는지가 아니라 누가 누구를 건드냐만 return, StringBuilder쓰면 될듯
public class Solution {
    public String solution(int[] numbers, String hand) {
        StringBuilder sb = new StringBuilder();
        int left = 10;
        int right = 12;
        for(int i = 0; i < numbers.length; i++) {
            int number = numbers[i];
            if(number % 3 == 1){//1 4 7 인 경우
                left = number;
                sb.append("L");
            }
            else if(number % 3 == 0 && number != 0){//3 6 9 인 경우
                right = number;
                sb.append("R");
            }
            else if(number % 3 == 2 || number == 0){//2 5 8 인 경우
                number = number == 0 ? 11: number;
                int leftMove = Math.abs(left - number) % 3 + Math.abs(left - number) / 3;
                int rightMove = Math.abs(right - number) % 3 + Math.abs(right - number) / 3;
                if(leftMove == rightMove) {
                    if(hand.equals("right")){
                        sb.append("R");
                        right = number;
                    }
                    else if(hand.equals("left")){
                        sb.append("L");
                        left = number;
                    }
                }
                else if(leftMove > rightMove) {
                    sb.append("R");
                    right = number;
                }
                else {
                    sb.append("L");
                    left = number;
                }
            }

        }
        return sb.toString().trim();
    }
}
