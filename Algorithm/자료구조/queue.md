QUEUE (큐)
=
선입선출 (FIFO: First In First Out) 방식
-
### 용어
- front  
: 원소를 꺼낼 수 있는 곳 (head)
- rear  
: 원소를 추가할 수 있는 곳 (tail)
- overflow  
: 큐가 꽉차서 원소를 추가할 수 없는 경우
- underflow  
: 큐가 비어있어 원소를 꺼낼 수 없는 경우  
### 연산
- put(q, e)  
: 큐에 원소 추가  
insert / enqueue 라고도 함
- get(q)  
: 큐의 원소 삭제  
delete / dequeue 라고도 함

### 종류
- 선형 큐
- 환형 큐 