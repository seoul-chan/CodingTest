package codingTest;

// ���α׷��ӽ� Level 1 - ���ڿ� �ٷ�� �⺻
class Solution {
    public boolean solution(String s) {
        boolean answer = true;
        
        if(s.length()!=4 && s.length()!=6) return false;
        	
        for(int i=0;i<s.length();i++) {
        	if(s.charAt(i)<48 || s.charAt(i)>57)
        		answer = false;
        }       
        return answer;
    }
    
    public static void main(String[] args) {
    	Solution sol = new Solution();
    	String s  = "99b9";
    	System.out.println(sol.solution(s));
    }
}


