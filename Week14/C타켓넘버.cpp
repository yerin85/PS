#include <string>
#include <vector>

using namespace std;
int dfs(int total,int ans, vector<int> num, int n, int target) {
	if (n >= num.size()) {
		if (total == target) {
			ans++;
			return ans;
		}
		else {
			return ans;
		}
	}

	ans=dfs(total + num[n], ans, num, n + 1, target);
	ans=dfs(total - num[n], ans, num, n + 1, target);

	return ans;
}
int solution(vector<int> numbers, int target) {
    int answer = 0;
    int n = 0;
	int total = 0;
	answer = dfs(total,answer, numbers, n, target);
    return answer;
}
