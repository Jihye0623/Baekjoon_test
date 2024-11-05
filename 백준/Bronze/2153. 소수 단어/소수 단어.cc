#include <iostream>
#include <string>
using namespace std;

// 소수 판별 함수
bool isPrime(int num) {
    if (num <= 1) return true; // 1은 소수로 간주
    for (int i = 2; i * i <= num; i++) {
        if (num % i == 0) return false; // 나누어 떨어지면 소수가 아님
    }
    return true; // 소수임
}

int main() {
    string word;
    cin >> word; // 단어 입력받기

    int sum = 0; // 합계 초기화

    // 각 문자의 값 계산
    for (char c : word) {
        if (c >= 'a' && c <= 'z') {
            sum += (c - 'a' + 1); // 소문자 처리
        } else if (c >= 'A' && c <= 'Z') {
            sum += (c - 'A' + 27); // 대문자 처리
        }
    }

    // 소수 판별
    if (isPrime(sum)) {
        cout << "It is a prime word." << endl; // 소수 단어
    } else {
        cout << "It is not a prime word." << endl; // 소수가 아님
    }

    return 0;
}
