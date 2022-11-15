class Solution {
    public int equalPairs(int[][] grid) {
        // Map for rows
        Map<String, Integer> dict1 = new HashMap<>();
        for (int[] row : grid) {
            String key = convertToKey(row);
            int count = dict1.getOrDefault(key, 0) + 1;
            dict1.put(key, count);
        }
        // Map for columns
        Map<String, Integer> dict2 = new HashMap<>();
        for (int col = 0; col < grid[0].length; col++) {
            int[] column = new int[grid.length];
            for (int row = 0; row < grid.length; row++) {
                column[row] = grid[row][col];
            }
            String key = convertToKey(column);
            int count = dict2.getOrDefault(key, 0) + 1;
            dict2.put(key, count);
        }
        // Compare row with column
        int ans = 0;
        for (String key : dict1.keySet()) {
            ans += dict1.get(key) * dict2.getOrDefault(key, 0);
        }
        return ans;
    }
    private String convertToKey(int[] nums) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nums.length; i++) {
            sb.append(nums[i]);
            sb.append(",");
        }
        return sb.toString();
    }
    
}