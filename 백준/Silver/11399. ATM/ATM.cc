#include<cstdio>
#include<algorithm>
using namespace std;
int ar[1000];
int main() {
int N, sum = 0, result = 0;
scanf("%d", &N);
for (int i = 0; i < N; i++) {
scanf("%d", ar + i);
}
sort(ar, ar + N);
for (int i = 0; i < N; i++) {
sum += ar[i];
result += sum;
}
printf("%d", result);
}