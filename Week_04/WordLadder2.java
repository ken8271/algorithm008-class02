class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> result = new ArrayList();

        //转换wordList为Set
        Set<String> dicts = new HashSet(wordList);

        //判断endWord是否在wordlist中
        if(!dicts.contains(endWord)){
            return result;
        }
        
        //新建队列，将beginWord加入队列
        Queue<List<String>> queue = new LinkedList();
        Set<String> visits = new HashSet();

        List<String> firstPath = new ArrayList();

        firstPath.add(beginWord);

        queue.add(firstPath);
        visits.add(beginWord);

        boolean flag = false;

        //遍历队列，直到队列为空或找到endWord
        while(!queue.isEmpty() && !flag){
            int size = queue.size();
            Set<String> subVisited = new HashSet<>();

             //遍历队列元素
            for(int i=0; i<size; i++){
                List<String> wordPath = queue.poll();

                //获取当前路径最后一个元素
                String lastWord = wordPath.get(wordPath.size() - 1);

                //遍历每个字符，用a-z替换
                char[] chars = lastWord.toCharArray();

                for(int j=0; j<chars.length; j++){
                    char c = chars[j];

                    for(char k = 'a'; k<='z'; k++){
                        if(k == c){
                            continue;
                        }

                        chars[j] = k;

                        String s = new String(chars);
                        
                        //如果在wordList中能找到，且未访问
                        if(dicts.contains(s) && !visits.contains(s)){
                            //则拼接到路径后，加入队列
                            List<String> newPath = new ArrayList(wordPath);

                            newPath.add(s);

                            //如果字符串为endWord，则找到终点
                            if(s.equals(endWord)){
                                flag = true;
                                result.add(newPath);
                            }

                            queue.add(newPath);
                            subVisited.add(s);
                        }
                    }

                    chars[j] = c;
                }
            }

            visits.addAll(subVisited);
        }
        
        return result;
    }
}