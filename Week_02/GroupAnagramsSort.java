class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs == null || strs.length == 0){
            return new ArrayList();
        }

        Map<String, List<String>> results = new HashMap<>();
        for (String s : strs) {
            char[] chars = s.toCharArray();

            Arrays.sort(chars);
            
            String keyStr = String.valueOf(chars);

            if (!results.containsKey(keyStr)) {
                results.put(keyStr, new ArrayList<>());
            }

            results.get(keyStr).add(s);
        }
        return new ArrayList<>(results.values());
    }
}