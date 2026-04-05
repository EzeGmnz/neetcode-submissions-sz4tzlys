from collections import defaultdict, deque

class Solution:
    def ladderLength(self, beginWord: str, endWord: str, wordList: List[str]) -> int:
        if beginWord == endWord:
            return 0

        self.vertices = wordList
        self.adj_list = defaultdict(list)

        wordList.append(beginWord)
        self.build_graph(wordList)
        
        return self.BFS(beginWord, endWord)

    def BFS(self, start, end):
        visited = {start:True}
        queue = deque([(start, 0)])

        while queue:
            print(queue)
            curr_node, distance = queue.popleft()

            if curr_node not in visited:
                visited[curr_node] = True

            if curr_node == end:
                return distance + 1

            for neighbor in self.adj_list[curr_node]:
                if neighbor not in visited:
                    visited[neighbor] = True
                    queue.append((neighbor, distance + 1))

        return 0

    def build_graph(self, wordList: List[str]):

        for x in range(len(wordList) - 1):
            word1 = wordList[x]
            for y in range(1, len(wordList)):
                word2 = wordList[y]
                if self.is_less_than_one_char_away(word1, word2):
                    self.add_edge(word1, word2)
                    self.add_edge(word2, word1)

    def is_less_than_one_char_away(self, word1, word2):
        diff_count = 0
        for x in range(len(word1)):
            letter1 = word1[x]
            letter2 = word2[x]
            if letter1 != letter2:
                diff_count += 1
            if diff_count > 1:
                return False
        return diff_count == 1

    def add_edge(self, word1, word2):
        self.adj_list[word1].append(word2)
