import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

class Solution {
    public String solution(String m, String[] musicinfos) {
        String answer ="(None)";
        ArrayList<sing> arr = new ArrayList<sing>();
		
        for(int i=0; i<musicinfos.length;i++) {
        String temp[] = musicinfos[i].split(",");		

        int tt = time(temp[1])-time(temp[0]);
        String ss = convert(temp[3]);
        if(tt<ss.length()) arr.add(new sing(tt, temp[2], ss.substring(0, tt)));
        else arr.add(new sing(tt, temp[2], ss.repeat(tt/ss.length())+ss.substring(0, tt%ss.length())));
		    }
        Collections.sort(arr);

        for(sing s: arr) {
          if(s.lyrics.contains(convert(m))) {
            answer = s.title;
            break;
          }
        }

            return answer;
    }
    
static int time(String s){
		StringTokenizer st = new StringTokenizer(s,":");
		int h = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		return h*60+m;
	}
    
static String convert(String s) {
		String tempS = "";
		
		for(int j=0; j<s.length();j++) {
			if(s.charAt(j)=='#') continue;
			if(j==s.length()-1) {
				tempS+=s.charAt(j);
				break;
			}
			if(s.charAt(j+1) == '#') {
				tempS+= Character.toLowerCase(s.charAt(j));
			}else {
				tempS+=s.charAt(j);
			}
		}
		return tempS;
	}
}

class sing implements Comparable<sing>{
	int time;
	String title;
	String lyrics;
	
	sing(int time, String title, String lyrics){
		this.time = time;
		this.title = title;
		this.lyrics = lyrics;
	}

	@Override
	public int compareTo(sing o) {
		if(o.time < this.time) return -1;
        else if(o.time == this.time) return 0;
		return 0;
	}
}
