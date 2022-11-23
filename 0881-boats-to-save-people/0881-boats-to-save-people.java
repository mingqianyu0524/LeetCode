class Solution {
    public int numRescueBoats(int[] people, int limit) {
        int i = 0, j = people.length - 1, count = 0;
        Arrays.sort(people);
        while (j >= i) {
            if (people[i] + people[j] <= limit) i++;
            count++;
            j--;
        }
        return count;
    }
}