class Solution(object):
    def threeSumMulti(self, arr: List[int], target: int) -> int:
        arr.sort()
        res, l = 0, len(arr)

        for i in range(l - 2):
            # Initialise the 2-sum pointers
            j, k = i + 1, l - 1
            while j < k:
                if arr[j] + arr[k] < target - arr[i]:  # arr[j] is too small
                    j += 1
                elif arr[j] + arr[k] > target - arr[i]:  # arr[k] is too large
                    k -= 1
                else:  # arr[i]+arr[j]+arr[k] == target
                    res += 1
                    # Shift both pointers by 1
                    j += 1
                    k -= 1
                    return res % 1000000007
