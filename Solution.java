package CodingTest;

// ���α׷��ӽ� Level 1 - ���￡�� �輭�� ã��
class Solution {
    public String solution(String[] seoul) {
    	int i;
    	for(i=0;i<seoul.length;i++) {
    		if(seoul[i].equals("Kim")) break;
        }
    	String answer = "�輭���� " + i + "�� �ִ�";
        return answer;
    }
    
    public void main(String[] args) {
    	Solution sol = new Solution();
    	String[] seoul = {"Jane","Kim"};
    	
    	System.out.println(sol.solution(seoul));
    }
}
