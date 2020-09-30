import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
		
	    int[] stage = new int[501];
	    
	    //실패율  = 도달했으나 클리어 못한 플레이어 수 / 스테이지에 도달한 플레이어 수
	    
	    int max = stages.length;
	   
	    Arrays.sort(stages);
	    for(int i=0; i<stages.length;i++) {
	    	stage[stages[i]]++;
	    }
	    
	    ArrayList<user> al = new ArrayList<user>();
	    for(int i=1; i<=N;i++) {
	    	if(stage[i]!=0) {
	    		al.add(new user(i, (double)stage[i]/(double)max));
	    		max-=stage[i];
	    	}else al.add(new user(i, 0));
	    }
	    
	    Collections.sort(al);
		for(int i=0; i<al.size();i++) answer[i] = al.get(i).idx;
        return answer;
	}
}

class user implements Comparable<user>{
	int idx;
	double fail;
	
	user(int idx, double fail){
		this.idx = idx;
		this.fail = fail;
	}

	@Override
	public int compareTo(user o) {
		if(this.fail>o.fail) return -1;
		else if(o.fail == this.fail) {
			if(this.idx < o.idx) return -1;
		}
		return 1;
	}
}
