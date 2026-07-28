class Solution {
    public String smallestPalindrome(String s) {
        int n = s.length();
        int[] hash = new int[26];

        // Count characters from the first half
        for (int i = 0; i < n / 2; i++) {
            hash[s.charAt(i) - 'a']++;
        }

        StringBuilder half = new StringBuilder();

        for (int i = 0; i < 26; i++) {
            while (hash[i] > 0) {
                half.append((char) (i + 'a'));
                hash[i]--;
            }
        }

        StringBuilder ans = new StringBuilder();
        ans.append(half);

        if (n % 2 == 1) {
            ans.append(s.charAt(n / 2));
        }

        ans.append(new StringBuilder(half).reverse());

        return ans.toString();
    }
}