#include <iostream>
#include <queue>
#include <algorithm>
#include <vector>
using namespace std;
vector<int> v[1001]; //정점의 개수 최대 1000개
bool visit[1001]; //방문체크를 하기 위한 배열
void dfs(int node) { //깊이우선탐색
int cur = node; //현재노드는 cur에 저장
visit[cur] = true; //현재노드를 방문했으니 방문체크
for (int i = 0; i < v[cur].size(); i++) { //다음노드 개수만큼 반복
int next = v[cur][i]; //다음노드는 next에 저장
if (visit[next] == false) //방문하지 않은 다음노드라면
dfs(next); //재귀함수호출

}
}
void bfs(int node) { //너비우선탐색
visit[node] = true; //방문체크
queue<int> q; //다음 방문할 노드번호를 저장할 큐 선언
q.push(node); //큐에 방문할 노드 삽입
while (!q.empty()) { //방문할 노드가 하나라도 있다면 반복
int cur = q.front(); //현재 노드는 cur, 큐의 맨앞
q.pop(); //cur에 저장해두었으니 팝
for (int i = 0; i < v[cur].size(); i++) { //다음노드 개수만큼 반복
int next = v[cur][i]; //다음노드는 next에 저장
if (visit[next] == false) { //방문하지 않은 다음노드라면
visit[next] = true; //방문체크 후
q.push(next); //큐에 다음 방문할 노드를 삽입
}
}
}
}
int main() {
int n, m;
cin >> n >> m;
for (int i = 0; i < m; i++) { //간선개수만큼 반복
int a, b;
cin >> a >> b;
v[a].push_back(b); //양방향이기 때문에 서로 저장

v[b].push_back(a);
}
int cnt = 0; //연결된 요소가 몇개인지 저장할 정답 변수
for (int i = 1; i <= n; i++) { //노드 개수만큼 반복
if (visit[i] == false) { //방문하지 않은 노드라면
dfs(i); //방문
//bfs(i);
cnt++; //한번 방문할 때마다 한 그룹을 방문한 것임
}
}
cout << cnt; //정답 출력
return 0;
}