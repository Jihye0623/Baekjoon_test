#include<cstdio>
#include<math.h>
#include<algorithm>
using namespace std;
int chk[10] ;
int numchk(int n) {
int count = 0;
if (n == 0) {
if (chk[n] == 1) {
return 0;
}
else
return 1;

}
while (n > 0)
{
if (chk[n % 10] == 1) {
return 0;
}
n = n / 10;
count++;
}
return count;

}
int main() {
int i, n, m;
scanf("%d%d", &n, &m);
for (i = 0; i < m; i++) {
int j;
scanf("%d", &j);
chk[j] = 1;
}
int result = abs(n - 100);
for (i = 0; i <= 1000000; i++) {
int length = numchk(i);
if (length > 0) {
int result1 = length + abs(n - i);
if (result > result1) {
result = result1;
}
}
}
printf("%d", result);
return 0;
}