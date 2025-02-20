#include <iostream>
using namespace std;
int fraction[2001][2001] = { 0, };
int euclidean(int a, int b);
int main()
{
int d1, d2;
cin >> d1 >> d2;
int cnt = 0;
for (int i = d1; i <= d2; i++) {
for (int j = 1; j <= i; j++) {
int gcd = euclidean(i, j);
int numerator = i / gcd;
int denominator = j / gcd;
if (fraction[numerator][denominator] == 0) {
fraction[numerator][denominator] = 1;
cnt++;
}
}
}
cout << cnt;
}
int euclidean(int a, int b) {
if (b == 0) {
return a;
}
return euclidean(b, a % b);
}