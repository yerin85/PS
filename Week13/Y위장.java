import java.util.HashMap;

class Solution {
    public int solution(String[][] clothes) {
    int answer =1;
        		
		HashMap<String, Integer> wear = new HashMap<String, Integer>();
		for(String []s: clothes) {
			if(!wear.containsKey(s[1])) wear.put(s[1], 1);
			else wear.put(s[1], wear.get(s[1])+1);
		}

		for(String s: wear.keySet()) answer *= wear.get(s)+1;
		
		answer--;
        return answer;
    }
}
