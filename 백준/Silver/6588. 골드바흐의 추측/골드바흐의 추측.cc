#include <cstdio>
#include <cmath> // 추가: sqrt 사용을 위해
const int MAX = 1000000;
int prime[MAX]; // 소수를 저장할 배열
int pn; // 소수 개수
bool check[MAX + 1]; // 소수 체크 배열

int main() {
    // 에라토스테네스의 체를 이용하여 소수 찾기
    for (int i = 2; i <= MAX; i++) {
        if (!check[i]) { // 소수인 경우
            prime[pn++] = i; // 소수 배열에 추가
            // long long을 사용하여 i * i의 오버플로우 방지
            for (long long j = (long long)i * i; j <= MAX; j += i) {
                check[j] = true; // 배수는 소수가 아님
            }
        }
    }

    while (true) {
        int n;
        scanf("%d", &n);
        if (n == 0) {
            break; // 입력이 0이면 종료
        }

        // 짝수 n을 두 소수의 합으로 표현
        for (int i = 0; i < pn; i++) {
            if (prime[i] > n) {
                break; // prime[i]가 n보다 크면 종료
            }
            if (!check[n - prime[i]]) { // n - prime[i]가 소수인지 확인
                printf("%d = %d + %d\n", n, prime[i], n - prime[i]);
                break; // 첫 번째 쌍을 찾으면 종료
            }
        }
    }

    return 0;
}
