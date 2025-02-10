#include <cstdio>
#include <vector>
#include <algorithm>
using namespace std;
int k;
vector<int> Max, Min;
char ar[15];
int check(vector<int> v) {//부등호가 성립하는지 확인
for (int i = 0; i < k; i++) {
if (ar[i] == '<' && v[i] > v[i + 1])
return 0;
else if (ar[i] == '>' && v[i] < v[i + 1])
return 0;

}
return 1;
}
int main() {
scanf("%d", &k);
for (int i = 0; i < k; i++) {
char temp[2];
scanf("%s", temp);
ar[i] = temp[0];
}
//최대
for (int i = 9; i > 9 - (k + 1); i--)
Max.push_back(i);
do {
if (check(Max) == 1)
break;

} while (prev_permutation(Max.begin(), Max.end()));
//최소
for (int i = 0; i < (k + 1); i++)

Min.push_back(i);
do {
if (check(Min) == 1)
break;

} while (next_permutation(Min.begin(), Min.end()));
for (int i = 0; i < Max.size(); i++)
printf("%d", Max[i]);
printf("\n");
for (int i = 0; i < Min.size(); i++)
printf("%d", Min[i]);
return 0;
}