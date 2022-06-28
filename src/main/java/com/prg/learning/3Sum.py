class Trie(object):
    data = [None for i in range(0, 26)]
    last = False

    def __init__(self):
        self.data = [None for i in range(0, 26)]
        last = False


class WordDictionary(object):

    def __init__(self):
        global root
        root = Trie()

    def addWord(self, word):
        """
        :type word: str
        :rtype: None
        """
        temp = root
        for i, ch in enumerate(word):

            if temp.data[ord(ch) - 97] is None:
                temp.data[ord(ch) - 97] = Trie()
            if i != len(word) - 1:
                temp = temp.data[ord(ch) - 97]
        temp.last = True

    def search(self, word):
        """
        :type word: str
        :rtype: bool
        """
        return self.match(word, root)

    def match(self, word, root):
        if len(word) == 0:
            return False
        if word[0] == '.':
            for j in range(0, 25):
                if root.data[j] and self.match(chr(j + 97) + word[1:], root):
                    return True
            return False

        else:
            if root.data[ord(word[0]) - 97] is not None:
                if root.last and len(word) == 1:
                    return True
                return self.match(word[1:], root.data[ord(word[0]) - 97])


# Your WordDictionary object will be instantiated and called as such:
# obj = WordDictionary()
# obj.addWord(word)
# param_2 = obj.search(word)

class Main:
    dict = WordDictionary()
    dict.addWord('zzzz')
    found = dict.search('zzzz')
    print(found)
