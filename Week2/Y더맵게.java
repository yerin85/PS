int[] scoville = {1, 2, 3, 9, 10, 12};
		int K = 7;
		int answer = 0;
	
		/*
		 * PrioirityQueue가 heap이니까 알아서 정렬됨!
		 * */
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		for(int i:scoville) pq.add(i);
		
		while(!pq.isEmpty()) {
			/*
			 * 오름차순으로 정렬되므로 맨 앞에 있는 원소의 값이 k를 넘는다면 뒤에 있는 원소들도 다 넘을 거임 그니까 break
			 * size==1은 예외처리 안하면 런타임에러걸림ㅜㅜ
			 * 남은 원소는 하나인데 k보다 작다면 answer를 -1로 만듦
			 * 앞에 두 개 빼고 값만들어서 다시 넣고 반복
			 * */
			if(pq.peek()>=K) break;
			if(pq.size()==1) {
				if(pq.peek()<K) answer=-1;
				break;
			}
			int temp1 = pq.poll();
			int temp2 = pq.poll();
			pq.add(temp1+(temp2*2));
			answer++;
		}
