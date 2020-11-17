import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
class Solution {
    public int solution(int[][] routes) {
        		ArrayList<car> point = new ArrayList<car>();
		for (int route[] : routes) {
			point.add(new car(route[0], route[1]));
		}

		Collections.sort(point);

		car camera = new car(point.get(0).start, point.get(0).end);
		int answer = 1;

		for (int i = 1; i < point.size(); i++) {
			if (camera.end < point.get(i).start) {
				camera = new car(point.get(i).start, point.get(i).end);
				answer++;
				continue;
			}
			
			if (point.get(i).end < camera.end)
				camera.end = point.get(i).end;
			if (point.get(i).start > camera.start)
				camera.start = point.get(i).start;
		}

		return answer;

	}
}

class car implements Comparable<car> {
	int start;
	int end;

	car(int s, int e) {
		start = s;
		end = e;
	}

	@Override
	public int compareTo(car o) {
		if (this.start < o.start)
			return -1;
		else if (this.start == o.start) {
			if (this.end > o.end)
				return -1;
		}
		return 1;
	}
}
