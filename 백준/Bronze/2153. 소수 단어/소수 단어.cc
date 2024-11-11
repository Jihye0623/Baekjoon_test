#include <iostream>
#include <string>
using namespace std;

bool isPrime(int num) {
    if (num <= 1) return true; 
    for (int i = 2; i * i <= num; i++) {
        if (num % i == 0) return false; 
    }
    return true;
}
int main() {
    string word;
    cin >> word; 
    int sum = 0; 

    for (char c : word) {
        if (c >= 'a' && c <= 'z') {
            sum += (c - 'a' + 1); 
        } else if (c >= 'A' && c <= 'Z') {
            sum += (c - 'A' + 27); 
        }
    }
    if (isPrime(sum)) {
        cout << "It is a prime word." << endl; 
    } else {
        cout << "It is not a prime word." << endl; 
    }

    return 0;
}
