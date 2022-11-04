class Solution {
    public int trap(int[] height) {
        int ans = 0, cur = 0;
        Stack<Integer> stack = new Stack<>();
        while (cur < height.length) {
            if (stack.isEmpty() || height[cur] <= height[stack.peek()]) {
                stack.push(cur++);
            } else {
                int bot = stack.pop();
                if (!stack.isEmpty()) {
                    int top = stack.peek();
                    int h = Math.min(height[cur], height[top]) - height[bot];
                    int d = cur - top - 1;
                    ans += (h * d);
                }
            }
        }
        return ans;
    }
}