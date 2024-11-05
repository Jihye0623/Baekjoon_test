#include <cstdio>
#include <vector>
using namespace std;

const int MAX = 1000000;
vector<int> prime;
bool check[MAX + 1];

int main() {
    for (int i = 2; i <= MAX; i++) {
        if (!check[i]) {
            prime.push_back(i);  // 벡터에 소수 추가
            if (1LL * i * i <= MAX) { // i * i가 MAX 범위 안에 있는지 확인
                for (int j = i * i; j <= MAX; j += i) {
                    check[j] = true;
                }
            }
        }
    }

    while (true) {
        int n;
        scanf("%d", &n);
        if (n == 0) {
            break;
        }

        bool found = false;
        for (int i = 1; i < prime.size() && prime[i] < n; i++) { // prime[i] < n 조건 추가
            if (!check[n - prime[i]]) {
                printf("%d = %d + %d\n", n, prime[i], n - prime[i]);
                found = true;
                break;
            }
        }

        if (!found) {
            printf("Goldbach's conjecture is wrong.\n");
        }
    }

    return 0;
}
