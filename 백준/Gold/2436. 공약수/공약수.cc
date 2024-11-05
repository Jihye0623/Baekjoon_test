#include <iostream>
using namespace std;

int gcd(int a, int b) {
    if (a < b) return gcd(b, a);
    if (b == 0) return a;
    else return gcd(b, a % b);
}

int main() {
    int g, l, num, i, x;
    cin >> g >> l;
    num = l / g;
    
    for (i = 1; i * i <= num; i++) {
        if (num % i == 0 && gcd(i, num / i) == 1) {
            x = i;
        }
    }
    
    cout << x * g << " " << num / x * g;
    return 0;
}
