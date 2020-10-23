import java.util.Stack;
class Solution {
    public String solution(String p) {
        String answer = "";
	    
	    //괄호 순서와 짝이 맞으면 올바른 괄호 문자열
	    //개수만 맞으면 균형잡힌 문자열
	    //균형잡힌 문자열을 변환할거임!!
	    
	    return func(p);    
	    
	}
  
	//올바른 문자열 true 아니면 false
	public static boolean check(String s) {
		Stack<Character> st = new Stack<>();
		for(int i=0; i<s.length();i++) {
			if(s.charAt(i) == '(') st.add(s.charAt(i));
			else {
				if(st.isEmpty()) {
					return false;
				}else st.pop();
			}
		}
		if(!st.isEmpty()) return false;
		
		return true;
	}
  
	//균형잡힌 문자열 인덱스 반환
	public static int balance_idx(String s) {
		if(s.length()==0) return -1;
		
		int left = 0;
		int right = 0;
		int i = 0;
		for(;i<s.length();i++) {
			if(s.charAt(i) == '(') left++;
			else right++;
			
			if(left == right) break;
		}
		return i;
	}
	
	public static String func(String p) {
		int idx = balance_idx(p)+1;
    	String u = p.substring(0,idx);
    	//System.out.println(idx);
	    String v = p.substring(idx);
	    
	    if(check(u)) { //올바른 문자열인데 v가 빈문자열이면 u만 반환 아니면 v에 대해서 다시 재귀
	    	if(v.equals("")) return u;
	    	v = func(v);
	    	
	    	return u+v;
	    }else {
	    	String temp = "(";
	    	temp += func(v)+")";
	    	u = u.substring(1,u.length()-1);
	    	
	    	for(int i=0;i<u.length();i++) {
	    		if(u.charAt(i)=='(') temp+=')';
	    		else temp+='(';
	    	}
	    	return temp;
	    }

	    
	}
}
