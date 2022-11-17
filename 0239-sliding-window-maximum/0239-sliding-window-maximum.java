class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        ArrayDeque<Integer> deq = new ArrayDeque<>();
        int[] ans = new int[nums.length - k + 1];
        
        for (int i = 0; i < nums.length; i++) {
            while (!deq.isEmpty() && nums[i] > nums[deq.getLast()]) {
                deq.removeLast();
            }
            deq.addLast(i);
            
            while (deq.getFirst() + k <= i) {
                deq.removeFirst();
            }
            if (i >= k-1) {
                ans[i-k+1] = nums[deq.getFirst()];
            }
        }
        return ans;
    }
}