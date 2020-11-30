import java.util.LinkedList;

class Solution {
    public int solution(int[] priorities, int location) {
    int number[] = new int[10];
		
		LinkedList<info> list = new LinkedList<info>();
		for(int i=0; i<priorities.length;i++) {
			list.add(new info(i, priorities[i]));
			number[priorities[i]]++;
		}
		
		int answer=0;
		while(true) {
			info temp = list.pollFirst();
			
			boolean flag = false;
			for(int i=temp.num+1; i<=9;i++) {
				if(number[i]>0) {
					flag = true;
					list.add(temp);
					break;
				}
			}
			
			if(!flag) {
				number[temp.num]--;
				answer++;
				if(temp.idx==location) {
					break;
				}
			}
		}
		
        return answer;
    }
}


class info{
	int idx;
	int num;
	
	info(int idx, int num){
		this.idx = idx;
		this.num = num;
	}
}
