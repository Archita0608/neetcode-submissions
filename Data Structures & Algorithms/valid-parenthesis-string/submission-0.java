class Solution {
    public boolean checkValidString(String s) {
      int low = 0;  // Min open parentheses
      int high = 0; // Max open parentheses

      for (char c : s.toCharArray()){
        if (c == '(') {
            low++;
            high++;
        } else if (c == ')') {
            low--;
            high--;
        } else { // c == '*'
            low--; // Treat as ')'
            high++; // Treat as '('
        }

        if (high < 0) return false; // Too many ')'
        if (low < 0) low = 0;
      }

      return low == 0;

    }
}
