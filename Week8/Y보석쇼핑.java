import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        int[] answer = new int[2];
        answer[0] = answer[1] = -1;
		HashMap<String, Integer> map = new HashMap<String, Integer>();

		for(String s:gems) {
			if(!map.containsKey(s)) map.put(s, 1);
		}
		
		int lo = 0;
		int hi = 0;
		
		HashMap<String, Integer> save = new HashMap<String, Integer>();
		save.put(gems[lo], 1);
		
		while(true) {
			if(lo==gems.length-1) break;
			if(save.size() == map.size()) {
				//길이가 작다면 무조건 대입
				//같다면 인덱스 작은걸로
				if(answer[1] == -1 && answer[0]==-1) {
					answer[0] = lo;
					answer[1] = hi;
				}else {
					if(answer[1]-answer[0]>hi-lo) {
						answer[0] = lo;
						answer[1] = hi;
					}else if(answer[1]-answer[0]==hi-lo) {
						if(answer[0]>lo) {
							answer[0] = lo;
							answer[1] = hi;
						}
					}
				}
				
				if(save.get(gems[lo])>1) save.put(gems[lo], save.get(gems[lo])-1);
				else save.remove(gems[lo]);
				lo++;
			}
			else {
				if(hi == gems.length-1) {
					lo++;
				}else {
					hi++;
					if(save.containsKey(gems[hi])) save.put(gems[hi], save.get(gems[hi])+1);
					else save.put(gems[hi], 1);
				}					
			}			
		}
        answer[0]++;
        answer[1]++;
        return answer;
	}
}
