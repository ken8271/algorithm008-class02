class Solution {
    public String reverseStr(String s, int k) {
        char[] result = s.toCharArray();
        int size = s.length();
        for (int start = 0; start < size; start += 2 * k) {
            int i = start, j = Math.min(start + k - 1, size - 1);
            while (i < j) {
                char c = result[i];
                result[i++] = result[j];
                result[j--] = c;
            }
        }
        return new String(result);
    }
}