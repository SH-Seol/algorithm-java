package programmers.implement.mbtisomething;

public class Solution {
    public String solution(String[] survey, int[] choices) {
        StringBuilder answerBuilder = new StringBuilder();
        int[] list = new int[4];//RT, CF, JM, AN

        for(int i = 0; i < survey.length; i++) {
            if(survey[i].equals("RT")){
                list[0] += choices[i] - 4;
            }
            else if(survey[i].equals("TR")){
                list[0] += 4 - choices[i];
            }
            else if(survey[i].equals("CF")){
                list[1] += choices[i] - 4;
            }
            else if(survey[i].equals("FC")){
                list[1] += 4 - choices[i];
            }
            else if(survey[i].equals("JM")){
                list[2] += choices[i] - 4;
            }
            else if(survey[i].equals("MJ")){
                list[2] += 4 - choices[i];
            }
            else if(survey[i].equals("AN")){
                list[3] += choices[i] - 4;
            }
            else if(survey[i].equals("NA")){
                list[3] += 4 - choices[i];
            }
        }
        answerBuilder.append(list[0] <= 0 ? "R" : "T");
        answerBuilder.append(list[1] <= 0 ? "C" : "F");
        answerBuilder.append(list[2] <= 0 ? "J" : "M");
        answerBuilder.append(list[3] <= 0 ? "A" : "N");

        return answerBuilder.toString();
    }
}
