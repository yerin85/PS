import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
class Solution {
    public long solution(String expression) {
        
    ArrayList<Long> num = new ArrayList<Long>();
		ArrayList<Character> mainoper = new ArrayList<Character>();

		String temp ="";
		for(int i=0; i<expression.length();i++) {
			if(Character.isDigit(expression.charAt(i))) temp+=expression.charAt(i);
			else {
				num.add(Long.parseLong(temp));
				temp = "";
				mainoper.add(expression.charAt(i));
			}
		}
		num.add(Long.parseLong(temp));
		char oper[][] = {
				{'+', '-', '*'},
				{'+', '*', '-'},
				{'-', '+', '*'},
				{'-', '*', '+'},
				{'*', '+', '-'},
				{'*', '-', '+'}
		};
		
		long max = 0;
		
		ArrayList<Long> copy1 = new ArrayList<Long>();
		ArrayList<Character> copy2 = new ArrayList<Character>();
		
		for(int i=0; i<6;i++) {
			char priority[] = oper[i];
			
			copy1.clear();
			copy1.addAll(num);
			copy2.addAll(mainoper);
			
			int operidx = 0;
			int idx = 0;
			while(true) {
				if(copy2.get(idx) == priority[operidx]) {
					Long t = 0L;
					if(priority[operidx]=='+') {
						t = copy1.get(idx)+copy1.get(idx+1);
					}else if(priority[operidx]=='-') {
						t = copy1.get(idx)-copy1.get(idx+1);

					}else {
						t = copy1.get(idx)*copy1.get(idx+1);

					}
					
					copy1.remove(idx+1);
					copy1.set(idx, t);
					copy2.remove(idx);
				}else idx++;
				
				if(idx == copy2.size()) {
					operidx++;
					idx = 0;
				}
				if(copy1.size()==1) break;
			}
			long a = copy1.get(0);
			
			max = Math.max(max, Math.abs(a));

		}
        return max;
    }
}
