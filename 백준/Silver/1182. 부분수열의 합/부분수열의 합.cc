#include <iostream>
using namespace std;
int ar[30];
int main()
{
int n, s;
int cnt = 0;
scanf("%d%d", &n, &s);
for (int i = 0; i < n; i++) {
scanf("%d", &ar[i]);
}
for (int i = 1; i < (1 << n); i++) {
int sum = 0;
for (int j = 0; j < n; j++) {
if (i & (1 << j)) {
sum += ar[j];
}
}
if (sum == s) {
cnt++;
}
}
printf("%d", cnt);
return 0;
}