#include <iostream>
#include <cmath>
using namespace std;
int ans = 0;
int n, r, c;
void divide(int row, int col, int size);
int main()
{
cin >> n >> r >> c;
divide(0, 0, pow(2, n));
}
void divide(int row, int col, int size) {
if (row == r && col == c) {
cout << ans;
return;
}
if (row <= r && r < row + size && col <= c && c < col + size) {
divide(row, col, size / 2);
divide(row, col + (size / 2), size / 2);
divide(row + (size / 2), col, size / 2);
divide(row + (size / 2), col + (size / 2), size / 2);
}
else {
ans += size * size;
}
}