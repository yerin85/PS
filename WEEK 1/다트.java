public static int solution(String dartResult) {
	        int answer = 0;
	        char[] arr=dartResult.toCharArray();
	        int[] score= new int[3];
	        score[0]=arr[0]-'0';
	        int num=0;
	        int point=0;
	        for(point=1;point<dartResult.length();point++) {
	        	if(arr[point]=='*') {
	        		if(num==0) {score[num]*=2;continue;}
	        		for(int i=num-1;i<=num;i++) {
	        			score[i]=score[i]*2;
	        		}
	        		continue;
	        	}
	        	else if(arr[point]=='#') {
	        		score[num]=score[num]*(-1);
	        		continue;
	        	}
	        	else if(arr[point]=='S') {
	        		continue;
	        	}else if(arr[point]=='D') {
	        		score[num]=score[num]*score[num];
	        		continue;
	        	}else if(arr[point]=='T') {
	        		score[num]=score[num]*score[num]*score[num];
	        		continue;
	        		
	        	}
	        	else {
	        		if(arr[point-1]=='1'&&arr[point]=='0') {
	        			score[num]=10;
	        		}else {
	        		num++;
	        		score[num]=arr[point]-'0';}
	        	}
	        	
	        }
	        for(int i=0;i<3;i++) {
	        	answer+=score[i];
	        	
	        }
	        		
	        return answer;
	    }
