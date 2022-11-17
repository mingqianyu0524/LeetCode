class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int n = temperatures.length;
        int[] A = new int[n];
        for (int i = 0; i < n; i++) {
            int temp = temperatures[i];
            while (!stack.isEmpty() && temperatures[stack.peek()] < temp) {
                int j = stack.pop();
                A[j] = i - j;
            }
            stack.push(i);
        }
        return A;
    }
}