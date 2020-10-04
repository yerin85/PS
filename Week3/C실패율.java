import java.util.*;
class pair implements Comparable<pair>{
	int index=0;
	double faill=0;
	public pair(int i, double d) {
		// TODO Auto-generated constructor stub
		this.index=i;
		this.faill=d;
	}
	public pair(int i) {
		// TODO Auto-generated constructor stub
		this.index=i;
		this.faill=0;
	}
	@Override
	public int compareTo(pair a) {
		// TODO Auto-generated method stub
		if(this.faill<a.faill) {//실패율은 내림차순
			return 1;
		}else if(this.faill==a.faill) {
			if(this.index>a.index) {
				return 1;//인덱스는 오름차순
			}
			
		}
		return -1;
	}
	
	
	
}
class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer=new int[N];
		double[] level=new double[N+2];
		List<pair> failure=new ArrayList<pair>();
		int storage=0;
		for(int i=0;i<stages.length;i++) {//level에 현재있는 사람들 수 더하기. 
			level[stages[i]]++;
		}
		for(int i=N+1;i>=1;i--) {//level이용해서 각각의 실패율 정하기
			storage+=level[i];
			if(i!=N+1) {
				if(level[i]!=0 && storage!=0) {//0인 경우는 실패율이 0이거나 (그 레벨 자체가 없거나.->N으로 처리)
					failure.add(new pair(i,level[i]/storage));
					
				}else {
					failure.add(new pair(i));
					
				}		
			}
		}
		Collections.sort(failure);
		for(int i=0;i<N;i++) {
			answer[i]=failure.get(i).index;
		}
        return answer;
    }
}
