class Solution {
    public String solution(String s, int n) {
        String answer = "";
        char[] c = s.toCharArray();
        
        for(int i = 0; i < c.length; i++){
            char ch = c[i];
            if (ch >= 'a' && ch <= 'z') {
                ch = (char)((ch + n -'a') % 26 + 'a');
            }else if(ch >= 'A' && ch <= 'Z'){
                ch = (char)((ch + n - 'A') % 26 +'A');
            }
            
            c[i] = ch;
        }
        
        answer = new String(c);//찾아봤다 
        return answer;
    }
}