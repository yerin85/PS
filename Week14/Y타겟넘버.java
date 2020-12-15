class Solution {
    static int answer;
    public int solution(int[] numbers, int target) {
        answer = 0;
        
		answer = 0;

		func(numbers, 0, true, 0, target);
		func(numbers, 0, false, 0, target);
		return answer;
	}

	static void func(int[] numbers, int idx, boolean flag, int sum, int target) {
		if (idx == numbers.length) {
			if (sum == target)
				answer++;
			return;
		}
		if (flag)
			sum += numbers[idx];
		else
			sum -= numbers[idx];

		if(idx==numbers.length-1) {
			if(sum==target) answer++;
			return;
		}else {
			func(numbers, idx + 1, true, sum, target);
			func(numbers, idx + 1, false, sum, target);
		}
		
		return;
	}

}
