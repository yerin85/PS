class Solution {
    public int solution(String s) {
        int answer =Integer.MAX_VALUE;
		
		    int min_length = s.length()/2+1; //예외처리! 문자열이 1일 때 min_length가 0이 되
		
		    for(int i=1; i<=min_length;i++) {
		    	answer = Math.min(answer, func(s, 0, i));
		      }
	
		    return answer;
	}
	
	static int func(String temp, int start_idx, int length) {
		String stand = temp.substring(start_idx, start_idx+length); //비교하는 기준이 되는 문자열
		int cnt = 1;
		String result = "";
		String comp =""; 
		
		for(int i= start_idx+length; i<temp.length();) {
			if(i+length>=temp.length()) comp = temp.substring(i); //3개씩 잘라야 하는데 남은 문자열이 2개일수도 있으니 예외처리
			else comp = temp.substring(i, i+length);
			
			if(stand.equals(comp)) cnt++;
			else {
				if(cnt == 1) result+=stand; //1일 경우 숫자 필요없으니 그냥 문자열만 붙임
				else result += cnt+stand;
				stand = comp;
				cnt = 1;
			}
			i+=length;
		}
		
    //마지막에 저장이 안되길래 남은거 처리
		if(cnt == 1) result+=stand; 
		else result += cnt+stand;
		
		return result.length();
	}
}
