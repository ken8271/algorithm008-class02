学习笔记
### 字典树
     > 概念：一种树形结构，又称Trie树，单词查找树，用于统计和排序大量的字符串，如词频统计
     > 优点：最大限度的减少无畏的字符串比较，查询效率比哈希表高
     > 基本性质：
       * 节点本身不存储完整单词
       * 从跟节点到某一结点，路径上经过的字符连接起来，为该节点对应的字符串
       * 每个节点的所有子节点路径所代表的字符都不相同
     > 核心思想：空间换时间，利用字符串的公共前缀来降低查询时间的开销以达到提高效率的目的

### 并查集
    > 适用场景：组团，配对问题
    > 基本操作：
      * markSet(s)：建立一个新的并查集，其中包含s个单元素集合
      * unionSet(x,y)：把元素x,y所在的集合合并，要求x和y所在的集合不相交，如果相交则不合并
      * find(x)：找到元素x所在的集合代表，该操作也可以用于判断两个元素是否位于同一个集合中，只要将他们各自的代表比较一下就可以了

### 搜索
    > 朴素搜索
    > 优化方式：不重复（fibonacci），剪枝（生成括号问题）
    > 搜索方向：DFS，BFS，双向搜索，启发式搜索（A*）

### 平衡树
    > 保证性能的关键：保证二维维度，左右子树结点平衡

### AVL树
    > 平衡因子：左右子树高度差的绝对值<1
    > 旋转方向：左旋（右右子树，哪边高度小往哪边旋），右旋（左左子树），左右旋（左右子树，先变成左左子树），右左旋（右左子树）
    > 缺点：需要额外空间存储额外信息，且调整次数频繁

### 红黑树
    > 为了解决AVL树频繁更新问题
    > 一种近似平衡的二叉搜索树，确保左右子树的高度差在2倍内
    > 满足条件：
      * 每个节点要么红色，要么黑色
      * 跟结点是黑色
      * 每个叶子结点是黑色的
      * 不能有相邻的两个红色结点
      * 从任意结点到每个叶子节点的所有路径都包含相同数目的黑色结点
    > 对比：
      * AVL树提供了更快的搜索，每个结点存储平衡因子，用于数据库查询
      * 红黑树提供了更快的插入和移除操作，用于语言类库的实现