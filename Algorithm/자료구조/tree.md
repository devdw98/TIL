TREE (트리)
=
계층적인 자료 표현 시 사용
-
### 용어
- node  
: 원소(데이터)
- root node  
: 트리의 가장 위에있는 노드
- subtree  
: root node를 제외한 나머지 원소들의 집합
- edge  
: root node 와 subtree의 연결 선
- parent node (부모 노드)  
: 한 원소에 연결된 이전 노드
- child node (자식 노드)  
: 한 원소에 연결된 상위 레벨의 노드
- sibling (형제)  
: 같은 parent node 를 가진 노드들
- ancestor node (조상 노드)  
: root node 에서 임의의 노드까지의 경로를 두고있는 노드
- descendent node (자손 노드)  
: 임의의 노드 하위에 연결된 모든 노드 -> 어떤 노드의 subtree에 속하는 모든 노드들
- leaf node (== terminal node, 단말 노드)  
: 자식 노드가 없는 노드
- internal node(== nonterminal node, 비단말 노드)  
: 자식 노드가 있는 노드
- degree (차수)  
: 어떤 노드가 가지고 있는 자식 노드의 개수
- 트리의 차수  
: 트리의 차수 중 가장 큰 차수 
- level  
: 노드의 깊이. 루트 노드가 1이고, 한 층씩 내려갈수록 1씩 증가한다.
- height (높이)  
: 트리의 최대 레벨
- depth  
: 한 트리에서 가질 수 있는 레벨
----
## 그래프와 트리의 차이
|그래프|트리|
|:---:|:---:|
|순환 O|순환 X|