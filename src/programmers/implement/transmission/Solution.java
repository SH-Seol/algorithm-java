package programmers.implement.transmission;

class Solution {
    public String solution(String p) {
        return ans(new StringBuilder(p)).toString();
    }
    public StringBuilder ans(StringBuilder str){
        //1
        if(str.length() == 0){
            return str;
        }

        //2 균형잡힌 괄호 문자열 u,v로 분리

        StringBuilder u = new StringBuilder();
        StringBuilder v = new StringBuilder();

        //올바른이 아니라 균형잡힌임
        int open = 0;
        int close = 0;
        char[] chars = str.toString().toCharArray();
        int t = 0;
        for(int i = 0; i < chars.length; i++){
            if(chars[i] == '('){
                open++;
                u.append('(');
            }
            if(chars[i] == ')'){
                close++;
                u.append(')');
            }
            if(open == close){
                t = i;
                break;
            }
        }
        for(int i = t + 1; i < chars.length; i++){
            v.append(chars[i]);
        }

        //3
        switch(isRight(u.toString())){
            //3 올바른 괄호 문자열
            case 2:
                //3-1 수행한 결과 문자열을 u에 이어 붙인 후 반환
                StringBuilder tmp = ans(new StringBuilder(v));
                return u.append(tmp);
            //4
            case 1:
                StringBuilder tmp2 = new StringBuilder();
                //4-1
                tmp2.append('(');
                //4-2
                StringBuilder rec = ans(v);
                //4-3
                tmp2.append(rec).append(')');
                //4-4
                u.deleteCharAt(u.length()-1);
                u.deleteCharAt(0);
                for(char c: u.toString().toCharArray()){
                    if(c == '('){
                        tmp2.append(')');
                    }
                    else if(c == ')'){
                        tmp2.append('(');
                    }
                }
                //4-5
                return tmp2;
        }

        return u;
    }
    public int isRight(String str){
        //0을 반환 시 균형잡힌 x, 올바른 x
        //1을 반환 시 균형잡힌 o, 올바른 x,
        //2를 반환 시 균형잡힌 o, 올바른 o
        //)로 시작하는 경우 일단 올바른은 절대 될 수 없음.
        //근데 어차피 여기 들어오는 것은 올바르냐 올바르지 않냐만 판별하면 됨
        //) 로 시작해도 됨 그냥 flag만 두면 될듯
        //만약 )가 더 많은 순간이 발생하면, ex )로 시작
        //flag 는 true가 됨
        boolean flag = false;
        char[] charArr = str.toCharArray();
        int open = 0;
        int close = 0;
        for(char ch : charArr){
            if(ch == '('){
                open++;
            }
            else if(ch == ')'){
                close++;
                if(open < close){
                    flag = true;
                }
            }
        }
        if(flag){
            return 1;
        }
        return 2;
    }
}
