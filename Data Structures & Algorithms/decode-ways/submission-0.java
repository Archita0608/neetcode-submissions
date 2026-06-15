class Solution {
    public int numDecodings(String s) {
      if(s == null || s.length() == 0 || s.charAt(0) == '0') {
            return 0;
        }

        int n = s.length();
        int prev2 = 1;
        int prev1 = 1;

        for (int i = 1; i < n; i++){
            int current = 0;

            int singleDigit = s.charAt(i) - '0';
            if (singleDigit >= 1 && singleDigit <= 9) {
                current += prev1;
            }

            int doubleDigit = (s.charAt(i - 1) - '0') * 10 + singleDigit;
            if (doubleDigit >= 10 && doubleDigit <= 26) {
                current += prev2;
            }

            if (current == 0) {
                return 0;
            }

            prev2=prev1;
            prev1=current;
        }

       return prev1; 
    }
}
