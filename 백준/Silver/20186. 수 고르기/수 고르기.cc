#include<stdio.h>
#include<algorithm>
using namespace std;
int check(int a, int b) {
return a > b;
}
int ar[5010];
int main() {
int n, k;
scanf("%d%d", &n, &k);
for (int i = 0; i < n; i++)scanf("%d", &ar[i]);
sort(ar, ar + n,check);
int sum = 0;
for (int i = 0; i < k; i++)
sum += ar[i] - i;
printf("%d", sum);
}