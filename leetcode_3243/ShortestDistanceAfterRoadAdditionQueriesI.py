from collections import deque


class ShortestDistanceAfterRoadAdditionQueriesI:
    def shortestDistanceAfterQueries(self, n: int, queries: list[list[int]]) -> list[int]:
        adj = [[i + 1] for i in range(n)]
        
        def bfs():
            q = deque()
            q.append((0, 0)) # (node, length)
            visited = set()
            visited.add((0,0))
            
            while q:
                cur, length = q.popleft()
                if cur == n - 1:
                    return length
                
                for neighbor in adj[cur]:
                    if neighbor not in visited:
                        q.append((neighbor, length + 1))
                        visited.add(neighbor)
            
        res = []
        for src, dest in queries:
            adj[src].append(dest)
            res.append(bfs())
        return res

def main():
    queries = [[2,4],[0,2],[0,4]]
    n = 5
    print(ShortestDistanceAfterRoadAdditionQueriesI().shortestDistanceAfterQueries(n, queries))
    
if __name__ == '__main__':
    main()