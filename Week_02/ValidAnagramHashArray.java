class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }

        int[] counts = new int[26];

        int size = s.length();
        for(int i=0; i<size; i++){
            counts[s.charAt(i) - 'a']++;
            counts[t.charAt(i) - 'a']--;
        }

        for(int i=0; i<counts.length; i++){
            if(counts[i] != 0){
                return false;
            }
        }

        return true;
    }
}