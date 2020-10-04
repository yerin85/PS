int solution(string s) {
	int answer = 0;
	int len = s.length();
	int half = len / 2;
	int start = 0;
	int sp = 0;
	int flag = 0;
	int same = 0;
	while (1) {
		if (half <= 0) {
			break;
		}
		if (half >= len) { 
			half = len - 1;
		}
		if (start >= len-1) {
			if (same != 0) {
				s[start - 1] = same + 1 + 48;
				for (int i = sp; i < start - 1; i++) {
					s.erase(s.begin());
				}
				same = 0;
			}
			break;
		}
		flag = 0;
		 for (int i = start; i < half; i++) {
			 if (s[i] != s[half + i- start]) {
				 flag = 1;
				 break;
			 }
		 }
		 if (flag == 1&&same==0) {
			 half--;
			 if (half == start) {
				 start++;
				 sp = start;
				 half = (start + len) / 2;
			 }
			 continue;
		 }
		 else if (flag == 1 && same != 0) {
			 s[start - 1] = same+1+48;
			 for (int i = sp; i < start - 1; i++) {
				 s.erase(s.begin());
			 }
			 same = 0;
			 start = half - start+1;
			 sp = start;
			 len = s.length();
			 half = (start + len) / 2;
		 }
		 else if (flag == 0) {
			 same++;
			 start = half;
			 half += half;
		 }

	}
	answer = s.length();
	return answer;
}
