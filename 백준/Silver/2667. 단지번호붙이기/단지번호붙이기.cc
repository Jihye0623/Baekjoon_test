#include <iostream>
#include <vector>
#include <algorithm>
#include <queue>
#include <string>
#define MAX 25 //지도의 크기는 가로,세로 각 최대 25
using namespace std;
typedef struct st { //집의 위치 좌표를 위한 구조체
int x, y;
}st;
int n, map[MAX][MAX]; //n:지도의 크기, map:집에 대한 자료
bool visit[MAX][MAX]; //방문체크를 위한 배열
int dx[] = { -1, 1, 0, 0 }; //상하좌우 방향
int dy[] = { 0, 0,-1, 1 };
bool check(st node) { //방문 가능여부 확인 함수
//바깥부분 접근 불가
if (node.x < 0 || node.y < 0 || node.x >= n || node.y >= n)
return false;
//데이터가 0이면 접근불가(집이 없음)
if (map[node.x][node.y] == 0)
return false;
//재방문 불가
if (visit[node.x][node.y] == true)
return false;
//이외에는 방문 가능
return true;
}
int dfs(st node) { //깊이우선탐색
int cnt = 1; //방문횟수
st cur = node; //현재노드
visit[cur.x][cur.y] = true; //방문체크
for (int i = 0; i < 4; i++) { //다음노드 4방향 반복
st next = { cur.x + dx[i], cur.y + dy[i] }; //다음노드
if (check(next) == true) //방문할 수 있다면
cnt += dfs(next); //재귀호출 후 방문횟수 더하여 리턴

}
return cnt;//방문횟수 리턴
}
int bfs(st node) { //너비우선탐색

int cnt = 1; //방문횟수
visit[node.x][node.y] = true; //방문체크
queue<st> q; //다음 방문할 노드를 저장할 큐 선언
q.push(node); //다음 방문할 노드 기록
while (!q.empty()) { //다음 방문할 노드가 있으면 반복
st cur = q.front(); //현재노드
q.pop(); //방문을 했으므로 제거
for (int i = 0; i < 4; i++) { //다음노드 4방향 반복
st next = { cur.x + dx[i], cur.y + dy[i] };//다음노드
if (check(next) == true) { //방문할 수 있다면
cnt++; //방문횟수 증가
q.push(next); //다음 방문할 노드 추가
visit[next.x][next.y] = true; //방문체크
}
}
}
return cnt; //방문횟수 리턴
}
int main() {
cin >> n; //지도의 크기 입력
for (int i = 0; i < n; i++) {
string s; //공백없이 입력이 받아졌으므로 string 이용
cin >> s;
for (int j = 0; j < s.size(); j++)
map[i][j] = s[j] - '0'; //문자->숫자로 변경하여 저장

}
vector<int> ans; //정답을 저장할 벡터 선언
for (int i = 0; i < n; i++) //모든 정점 검사
for (int j = 0; j < n; j++)
if (check({ i, j }) == true) { //방문할 수 있다면
//dfs 또는 bfs를 호출하여 방문횟수를 ans벡터에 저장
ans.push_back(dfs({ i,j }));
//ans.push_back(bfs({ i,j }));
}

sort(ans.begin(), ans.end()); //오름차순을 위해 정렬
cout << ans.size() << "\n"; //방문단지수 출력
for (int i = 0; i < ans.size(); i++)
cout << ans[i] << "\n"; //각 방문횟수 출력
return 0;
}