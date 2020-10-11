#include <string>
#include <vector>

using namespace std;
void dfs(int i, int j, vector<vector<int>> &computers) {
	computers[i][j] = -1;
	computers[j][i] = -1;//혹시모르니까 체크!
	int len = computers.size();
	for (int c = 0; c < len; c++) {
		if (computers[j][c] == 1) {
			dfs(j, c, computers);
		}
	}

}
int solution(int n, vector<vector<int>> computers) {
    int answer = 0;
    int len = computers.size();
	for (int i = 0; i < len; i++) {
		for (int j = i; j < len; j++) {//어차피 대칭이니까 근데 i+1부터하면 안됌. 자기자신 count못함.
			if (computers[i][j] == 1) {
				answer++;
				dfs(i, j,computers);
			}
		}
	}
    return answer;
}
