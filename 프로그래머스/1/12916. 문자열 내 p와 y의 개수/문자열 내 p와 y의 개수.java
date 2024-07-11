class Solution {
    boolean solution(String s) {
        int pNum = 0; 
        int yNum = 0;
        
        for(char c : s.toCharArray()) {
            switch (c) {
                case 'p','P' : pNum++;
                    break;
                case 'y','Y' : yNum++;
                    break;
            }
        }
        
        return pNum == yNum;
    }
}