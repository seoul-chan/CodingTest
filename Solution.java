package codingTest;

import java.util.Arrays;

//���α׷��ӽ� Level 1 - ���ڿ� �� ������� �����ϱ�
class Solution {
    public String[] solution(String[] strings, int n) {
    	Arrays.sort(strings);
    	
    	for(int i=0;i<strings.length-1;i++) {
    		for(int j=1;j<strings.length-i;j++) {
    			if(strings[j-1].charAt(n)>strings[j].charAt(n)) {
	    			String temp = strings[j];
	    			strings[j] = strings[j-1];
	    			strings[j-1] = temp;
        		}
    		}
    	}
        return strings;
    }
    
    public static void main(String[] args) {
    	Solution sol = new Solution();
    	String[] answer = {"sun","bed","car"};
    	
    	System.out.println(Arrays.toString(sol.solution(answer,1)));
    }
}

//1. �Է� ���� ���ڿ����� n��° ���� ���
//2. 