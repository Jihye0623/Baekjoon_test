#include <iostream>
#include <vector>
#include <iomanip>
using namespace std;

// 약수를 찾고 그 합을 계산하는 함수
bool isPerfectNumber(int n, vector<int>& divisors) {
    int sum = 0;
    for (int i = 1; i <= n / 2; i++) {
        if (n % i == 0) { // i가 n의 약수인지 확인
            divisors.push_back(i);
            sum += i; // 약수의 합 계산
        }
    }
    return sum == n; // 약수의 합이 n과 같으면 true, 아니면 false
}

int main() {
    while (true) {
        int n;
        cin >> n; // n 입력받기
        if (n == -1) break; // 종료 조건

        vector<int> divisors; // 약수를 저장할 벡터
        if (isPerfectNumber(n, divisors)) {
            cout << n << " = ";
            for (size_t i = 0; i < divisors.size(); i++) {
                cout << divisors[i];
                if (i < divisors.size() - 1) {
                    cout << " + "; // 마지막 요소가 아닐 경우 + 출력
                }
            }
            cout << endl;
        } else {
            cout << n << " is NOT perfect." << endl;
        }
    }

    return 0;
}
