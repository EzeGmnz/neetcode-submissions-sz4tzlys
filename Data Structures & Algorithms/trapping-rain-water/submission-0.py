class Solution:
    def trap(self, height: List[int]) -> int:
        left_max = [-1] * len(height)
        right_max = [-1] * len(height)

        for i in range(len(height)):
            if i > 0:
                if left_max[i-1] > height[i-1]:
                    left_max[i] = left_max[i-1]
                else:
                    left_max[i] = height[i-1]

        for i in range(len(height) - 1, -1, -1):
            if i < len(height) - 1:
                if right_max[i+1] > height[i+1]:
                    right_max[i] = right_max[i+1]
                else:
                    right_max[i] = height[i+1]

        water_area = 0
        for i in range(1, len(height) - 1):
            water_area += max(0, min(left_max[i], right_max[i]) - height[i])
        
        return water_area