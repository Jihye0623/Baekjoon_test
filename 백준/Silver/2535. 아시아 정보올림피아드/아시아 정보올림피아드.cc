#include <iostream>
#include<algorithm>
using namespace std;
struct st {
int na, num, score;
};
st ar[101];

int check(st a, st b) {
return a.score > b.score;
}
int main()
{
int n;
scanf("%d", &n);
for (int i = 0; i < n; i++) {
scanf("%d%d%d", &ar[i].na, &ar[i].num, &ar[i].score);
}
sort(ar, ar + n, check);
printf("%d %d\n", ar[0].na, ar[0].num);
printf("%d %d\n", ar[1].na, ar[1].num);
if (ar[0].na != ar[1].na) {
printf("%d %d\n", ar[2].na, ar[2].num);
}
else {
for (int i = 2; i < n; i++) {
if (ar[0].na != ar[i].na) {
printf("%d %d\n", ar[i].na, ar[i].num);
break;
}
}
}
return 0;
}