#include <iostream>
#include<algorithm>
using namespace std;
int dis[20][20];
int ar[15];
int main()
{
int n;
scanf("%d", &n);
for (int i = 1; i <= n; i++) {
for (int j = 1; j <= n; j++) {
scanf("%d", &dis[i][j]);
}
}
for (int i = 1; i <= n; i++) {
ar[i] = i;
}
int Min = 123456789;
do {
int sum = 0;
int chk = 0;
for (int i = 1; i < n; i++) {
sum += dis[ar[i]][ar[i + 1]];
if (dis[ar[i]][ar[i + 1]] == 0) {
chk++;
}
}
sum += dis[ar[n]][ar[1]];
if (dis[ar[n]][ar[1]] == 0) {
chk++;
}
if (chk == 0) {
if (sum < Min) {
Min = sum;
}
}
} while (next_permutation(ar + 1, ar + n + 1));
printf("%d", Min);
return 0;
}