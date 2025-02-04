#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;
int ans[3] = { 0, };
int paper[2200][2200] = { 0, };
void divide(int row, int col, int size);
int main()
{
int n;
cin >> n;
for (int i = 0; i < n; i++) {
for (int j = 0; j < n; j++) {
int u;
cin >> u;
paper[i][j] = u;
}
}
divide(0, 0, n);
for (int i = 0; i < 3; i++) {
cout << ans[i] << '\n';
}
}

void divide(int row, int col, int size) {
int check = paper[row][col];
for (int i = row; i < row + size; i++) {
for (int j = col; j < col + size; j++) {
if (paper[i][j] != paper[row][col]) {
divide(row, col, size / 3);
divide(row + (size / 3), col, size / 3);
divide(row + (size * 2 / 3), col, size / 3);
divide(row, col + (size / 3), size / 3);
divide(row + (size / 3), col + (size / 3), size / 3);
divide(row + (size * 2 / 3), col + (size / 3), size / 3);
divide(row, col + (size * 2 / 3), size / 3);
divide(row + (size / 3), col + (size * 2 / 3), size / 3);
divide(row + (size * 2 / 3), col + (size * 2 / 3), size / 3);
return;
}
}
}
ans[paper[row][col] + 1]++;
return;
}