#include <iostream>
#include <algorithm>
#define MAX 100001
using namespace std;
int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	int n, res = 0;
	int input[MAX], sum[MAX];
	cin >> n;
	for (int i = 1; i <= n; i++) {
		cin >> input[i];
		sum[i] = sum[i - 1] + input[i];
	}
	for (int i = 2; i < n; i++) {
		res = max((sum[n] - input[1] - input[i]) + (sum[n] - sum[i]), res);
		res = max((sum[i - 1]) + (sum[n] - input[i] - input[n]), res);
		res = max((sum[i] - input[1]) + (sum[n] - sum[i - 1] - input[n]), res);
	}
	cout << res;
	return 0;
}
