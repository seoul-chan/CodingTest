package codingTest;

//���α׷��ӽ� Level 1 - ����� ��
class Solution {
    public int solution(int n) {
    	int answer = 0;
    	for(int i=1;i<=n;i++) {
    		answer=(n%i==0)?answer+=i:answer;
    	}
        
        return answer;
    }
    
    public static void main(String[] args) {
    	Solution sol = new Solution();
    	System.out.println(sol.solution(5));
    }
}