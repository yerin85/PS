class Solution {
    public int solution(String dartResult) {
        int answer = 0;
        int arr[] = new int[3];
	    int idx = 0;
	    
        for(int i=0; i<dartResult.length();i++) {
	    	char temp = dartResult.charAt(i);
	    	
	    	if(Character.isDigit(temp)) {
	    		if(Character.isDigit(dartResult.charAt(i+1))) {
	    			arr[idx] = Integer.parseInt(dartResult.substring(i, i+2));
	    			i+=2;
	    		}else {
	    			arr[idx]= Integer.parseInt(dartResult.substring(i, i+1));
	    			i+=1;
	    		}
	    		
	    		String s = "";
	    		for(int j=i;j<dartResult.length()+1;j++) {
	    			if(j == dartResult.length()) func(s, idx, arr);
	    			else if(Character.isDigit(dartResult.charAt(j))) {
	    				func(s, idx, arr);
	    				idx++;
	    				break;
	    			}
	    			else s+= dartResult.charAt(j);
	    		}
	    		
	    		
	    	}
	    }
	    
	    for(int i=0; i<arr.length; i++) answer+=arr[i];
        return answer;
    }
    
    		public static void func(String s, int idx, int[] arr) {
		for(int i=0; i<s.length();i++) {
			 char temp = s.charAt(i);
			 
			 if(Character.isAlphabetic(temp)) {
				 if(temp == 'D') arr[idx] = (int)Math.pow(arr[idx], 2);
				 else if(temp == 'T') arr[idx] = (int)Math.pow(arr[idx],3);
			 }else {
				 if(temp == '*') {
					 arr[idx]*=2;
					 if(idx!=0) arr[idx-1] *=2;
				 }else arr[idx]*=(-1);
				 
			 }
			 
			 
			
		}
	
	}
}
