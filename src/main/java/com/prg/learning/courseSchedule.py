
# https://leetcode.com/problems/course-schedule/submissions/
class Solution(object):
    def canFinish(self, numCourses, prerequisites):
        """
        :type numCourses: int
        :type prerequisites: List[List[int]]
        :rtype: bool
        """
        graph = [[] for _ in range(numCourses)]
        degree = [0] * numCourses
        for a, b in prerequisites:
            graph[b].append(a)
            degree[a] += 1
        q = []
        for i, a in enumerate(degree):
            if a == 0:
                q.append(i)

        print(q)
        for a in q:
            for i in graph[a]:
                degree[i] -= 1
                if degree[i] == 0:
                    q.append(i)
        return len(q) == numCourses


class Caller:
    s = Solution().canFinish(5, [[0, 1], [0, 2], [2, 3], [3, 4]])
    print(s)
