学习笔记
## 学习心得
### 深度优先遍历（DFS）
```python
##递归方式
def dfs(node):
	visited.add(node)

	for child in node.childern():
		if not child in visited:
			dfs(child, visited)

##非递归方式（栈）
def dfs(self, tree):
	if tree.root is None:
		return ;

	visited, stack = [], [tree.root]

	while stack:
		node = stack.pop()

		visited.add(node)

		prcess(node)

		nodes = sub_nodes(node)

		stack.push(nodes)
```
### 广度优先搜索（BFS）
```python
##采用队列实现
def bfs(graph, start, end){
	queue = []

	queue.append([start])
	visited.add(start)

	while queue:
		node = queue.pop()
		visited.add(node)

		process(node)

		nodes = generate_related_nodes(node)

		queue.push(nodes)
}
```
### 贪心算法
* 贪心算法是一种在每一步选择中都采取当前状态下最好或最优的选择，从而希望导致的结果是全局最好或最优的算法
* 贪心算法当下做局部最优判断，不能回退。动态规划最优判断，并有回退功能
* 贪心可以解决一些最优化的问题。如，最小生成树，哈夫曼编码
* 一旦一个问题可以通过贪心算法来解决，那么该方法也是解决这个问题的最好方法。由于贪心的高效性以及最优的结果，贪心算法也可以用作辅助算法或者直接解决一些结果不特别精确的问题

### 二分查找
#### 前提条件
* 目标函数单调性
* 存在上下界
* 能够通过索引访问

#### 代码模板
```python
left,right=0,len(array)-1

while left <= right:
	mid = (left + right) / 2
	if array[mid] == target:
		break
	elif array[mid] < target:
		left = mid + 1
	else:
		right = mid -1
```