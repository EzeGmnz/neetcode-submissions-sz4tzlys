from collections import defaultdict, deque

class Solution:
    def countComponents(self, n: int, edges: List[List[int]]) -> int:
        self.adj_list = defaultdict(list)

        for u,v in edges:
            self.adj_list[u].append(v)
            self.adj_list[v].append(u)

        visited = [False] * n
        print(visited)
        print(n)
        count = 0
        for x in range(n):
            if visited[x]:
                continue
            count += 1
            queue = deque()
            queue.append(x)

            while queue:
                curr_node = queue.popleft()
                print(curr_node)
                if not visited[curr_node]:
                    visited[curr_node] = True
                 
                for neighbor in self.adj_list[curr_node]:
                    if not visited[neighbor]:
                        visited[curr_node] = True
                        queue.append(neighbor)

        return count

