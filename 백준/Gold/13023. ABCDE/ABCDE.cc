#include <iostream>
#include <algorithm>
#include <vector>
#include <cstring>
using namespace std;
vector<int> v[2000]; //친구 관계를 나타낼 벡터 선언 ex)v[1][2] : 1은 2와 친구
//인접행렬로 구현시 시간초과. 반드시 vector 사용
bool visit[2000]; //방문체크를 위한 visit배열 선언
bool ans = false; //문제에서 원하는 친구관계인지 저장할 변수
//깊이우선탐색
void dfs(int cur, int level) { //현재 노드cur, 호출깊이를 나타낼 level
if (level == 4) { //호출 깊이가 4 -> 5명이 연속으로 친구인 경우
ans = true; //정답을 true로 변경
return; //끝냄
}
visit[cur] = true; //방문체크
for (int i = 0; i < v[cur].size(); i++) { //친구수 만큼 반복
int next = v[cur][i]; //다음노드는 현재노드cur의 친구가 됨.
if (visit[next] == false) { //다음노드를 방문하지 않았다면
dfs(next, level + 1); //방문하면서 방문깊이를 1 증가시킴
visit[next] = false; //방문을 다 하고 돌아오면 다시 방문체크 제거(다른 친구탐색을 위해)
}
}
}
int main() {
int N, M;
cin >> N >> M;
for (int i = 0; i < M; i++) {
int a, b;
cin >> a >> b;
v[a].push_back(b); //친구사이는 양방향이기 때문에 양방향으로 저장
v[b].push_back(a);
}
for (int i = 0; i < N; i++) { //사람 수만큼 반복
memset(visit, 0, sizeof(visit)); //각 노드마다 방문체크 초기화
dfs(i, 0); //각 사람번호로 깊이우선탐색 호출, 레벨은 0으로 시작
if (ans == true) { //정답이 찾아졌다면

cout << "1"; //바로 1 출력 후 프로그램 종료
return 0;
}
}
cout << "0"; //위 반복문에서 정답을 찾지 못할 경우 정답은 0
return 0;
}