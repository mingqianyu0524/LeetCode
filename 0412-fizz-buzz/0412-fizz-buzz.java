class Solution {
    public List<String> fizzBuzz(int n) {
        List<String> answer = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            String s = "";
            boolean divisibleBy3 = (i % 3 == 0);
            boolean divisibleBy5 = (i % 5 == 0);
            if (divisibleBy3) {
                s += "Fizz";
            }
            if (divisibleBy5) {
                s += "Buzz";
            } 
            if (s.equals("")) {
                s += Integer.toString(i);
            }
            answer.add(s);
        }
        return answer;
    }
}