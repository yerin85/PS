#include <string>
#include <vector>
#include <queue>
using namespace std;
struct info {
	int weight;
	int time;

	info() {}
	info(int w, int t) {
		weight = w;
		time = t;
	}
};


int solution(int bridge_length, int weight, vector<int> truck_weights) {
	int answer = 1;
	queue<info> q;
	int max = 0;
	int i = 0;

	while (true) {
		if (!q.empty()) {
			/*
			큐가 비어있지 않음!
			그럼 뭘 해야하냐면 트럭 타임과 길이를 고려해서 없애야해
			맨 앞에 있는 트럭을 temp라고 함
			temp가 갖고있는 time은 트럭이 다리에 들어온 시점의 시간!
			들어왔던 시간에다가 length를 더했을 때 현재 시간인 answer와 같다면 나가야함
			전체 무게인 max에 트럭무게를 빼주고 다리에서 빼줌!
			*/
			
			int temp = q.front().time;
			if (temp + bridge_length == answer) {
				max -= q.front().weight;
				q.pop();
			}
		}

		/*
		큐가 비어있던 말던 트럭을 넣을거임
		for문같은거!
		q는 다리와 동일하므로 다리의 거리보다 작아야하고
		max는 다리에 있는 트럭무게 이건 최종 무게보다 작거나 같아야함 
		두 개의 조건이 충족되면 무게max에다가 트럭의 무게를 더함
		다리에다가 트럭을 넣음. 그리고 answer는 현재 트럭이 들어간 시간을 의미
		그리고 i를 더하면서 트럭 하나씩 돌아가며 체크
		
		*/
		if (i < truck_weights.size()) {
			if (q.size() < bridge_length && max + truck_weights[i] <= weight) {
				q.push(info(truck_weights[i], answer));
				max += truck_weights[i];
				i++;
			}
		}
		else if (max == 0) break;
		/*
		max가 0이 되었다는거는 다리에 트럭이 없다는 것과 동일
		*/

		answer++; //결국 1초마다 카운트해주는거임
	}

	return answer;
}
