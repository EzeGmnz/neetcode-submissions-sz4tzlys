from collections import defaultdict, deque

# n = amount of wors
# y = letter count
class Solution:
    def ladderLength(self, beginWord: str, endWord: str, wordList: List[str]) -> int:
        if beginWord == endWord:
            return 0
        wordList.append(beginWord)
        # O(n * y)
        placeholders_to_words = defaultdict(list)
        words_to_placeholders = defaultdict(list)
        for i in range(len(wordList)):
            word = wordList[i]
            placeholders = self.get_placeholders(word)
            for x in placeholders:
                placeholders_to_words[x].append(word)
                words_to_placeholders[word].append(x)

        return self.BFS(placeholders_to_words,words_to_placeholders, beginWord, endWord)

    def get_placeholders(self, word):
        placeholders = []
        for x in range(len(word)):
            placeholder = word[:x] + '*' + word[x + 1:]
            placeholders.append(placeholder)
        return placeholders

    def BFS(self, placeholders_to_words, words_to_placeholders, beginWord, endWord):
        visited = {beginWord:True}
        queue = deque([(beginWord, 0)])

        while queue:
            curr_word, distance = queue.popleft()

            if curr_word not in visited:
                visited[curr_word] = True

            if curr_word == endWord:
                return distance + 1
            
            neighbors = words_to_placeholders[curr_word]
            for placeholder in neighbors:
                words = placeholders_to_words[placeholder]
                for word in words:
                    if word not in visited:
                        visited[word] = True
                        queue.append((word, distance + 1))

        return 0
