class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < matches.length; i++) {
            for (int j = 0; j < 2; j++) {
                int player = matches[i][j];
                int count = map.getOrDefault(player, 0);
                if (j==1) map.put(player, count+1);
                else map.put(player, count);
            }
        }
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> tmp1 = new ArrayList<>();
        List<Integer> tmp2 = new ArrayList<>();
        for (int key : map.keySet()) {
            if (map.get(key) == 0) {
                tmp1.add(key);
            } else if (map.get(key) == 1) {
                tmp2.add(key);
            }
        }
        Collections.sort(tmp1);
        Collections.sort(tmp2);
        
        res.add(tmp1);
        res.add(tmp2);
        return res;
    }
}