#include <iostream>
#include <algorithm>
using namespace std;

// 최대공약수(GCD)를 구하는 함수
int gcd(int a, int b) {
    if (b == 0) return a;
    return gcd(b, a % b);
}

int main() {
    int D1, D2;
    cin >> D1 >> D2;
    int count = 0;

    // 반지름이 D1부터 D2까지 반복
    for (int r = D1; r <= D2; r++) {
        // 반지름이 r인 원의 각 좌석에 대해 검사
        for (int seat = 1; seat <= r; seat++) {
            // 좌석이 가려지지 않으려면 (반지름 r과 좌석 번호 seat의 GCD가 1이어야 함)
            if (gcd(r, seat) == 1) {
                count++;
            }
        }
    }

    cout << count;
    return 0;
}
