import java.util.List;
import java.util.ArrayList;
import java.util.PriorityQueue;
class Solution {
    static boolean check[];
	  static List<String> ans;
    public String[] solution(String[][] tickets) {
		
    ans = new ArrayList<String>();
		ans.add("ICN");
		check = new boolean[tickets.length];
		
		bfs(1, "ICN", tickets);
		String[] answer =  ans.toArray(new String[ans.size()]); //arraylist to array
		return answer;
	}
	
	static void bfs(int cnt, String current, String[][] tickets) {
		if(cnt == tickets.length+1) return;
		
		PriorityQueue<airport> pq = new PriorityQueue<airport>(); //출발지가 current인 티켓 넣어서 알파벳 순으로 정렬
		for(int i=0; i< tickets.length;i++) {
			if(!check[i] && tickets[i][0].equals(current)) pq.add(new airport(i, tickets[i][1]));
		}
		
		
		while(!pq.isEmpty()) {
			airport next = pq.poll();
			check[next.idx] = true;
			ans.add(next.air);
			dfs(cnt+1, next.air, tickets); //도착역을 current로 해서 다시 함수
			
			int flag_cnt=0; //check의 falg를 세는 변수
			for(int i=0; i<check.length;i++) {
				if(check[i]) flag_cnt++;
			}
			if(flag_cnt==check.length) return; //만약 모두 방문했으면 종료, 아니라면 다른 곳 방문
			check[next.idx]= false;
			ans.remove(ans.size()-1);
		}
		
	}
}

class airport implements Comparable<airport>{
	int idx;
	String air;
	
	airport(int idx, String air){
		this.air = air;
		this.idx = idx;
	}

	@Override
	public int compareTo(airport o) {
		return this.air.compareTo(o.air);
	}
}
