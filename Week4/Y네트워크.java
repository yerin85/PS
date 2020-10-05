import java.util.LinkedList;
import java.util.Queue;
class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        boolean visited[] = new boolean[n];

	    	Queue<Integer> q = new LinkedList<Integer>();
	    	
	    	for(int i=0; i<n;i++) {
	    		if(!visited[i]){
	    			q.add(i);
	    			visited[i] = true;
	    			answer++;
	    			func(computers, visited, q);
	    		}
	    	}
               
        return answer;
    }
    
     static void func(int[][] computers, boolean visited[], Queue<Integer>q) {

	    	while(!q.isEmpty()) {
	    		int temp = q.poll();
	    		
	    		for(int i=0; i<computers.length;i++) {
		    		if(temp!=i) {
		    			if(!visited[i] && computers[temp][i]==1) {
		    				visited[i] = true;
		    				q.add(i);
		    			}
		    		}
		    	}
	    	}
	    	
	    	
	    	
	    }
}
