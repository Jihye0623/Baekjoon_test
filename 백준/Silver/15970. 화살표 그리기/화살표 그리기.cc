#include<stdio.h>
#include<algorithm>
using namespace std;
struct st {
int spot, col;
};
st ar[5010];
int check(st a, st b) {
if (a.col == b.col) {
return a.spot < b.spot;
}
return a.col < b.col;
}
int main() {
int n;
scanf("%d", &n);
for (int i = 1; i <= n; i++) {
scanf("%d%d", &ar[i].spot, &ar[i].col);
}
sort(ar + 1, ar + n + 1, check);
int s = 0;
for (int i = 1; i <= n; i++) {
if (ar[i].col != ar[i - 1].col) {
s += ar[i + 1].spot - ar[i].spot;
}
else if (ar[i].col != ar[i + 1].col) {
s += ar[i].spot - ar[i - 1].spot;
}
else {
s += min(ar[i + 1].spot-ar[i].spot, ar[i].spot-ar[i - 1].spot);
}
}
printf("%d", s);
}