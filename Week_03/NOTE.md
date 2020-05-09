学习笔记
## 学习心得
### 递归
** 找重复性，最优重复性即动态规划，最近重复性即分治和回溯
```java
void recur(int level, int param){
	//递归终结条件
	if(level > MAX_LEVEL){
		//处理结果
		return ;
	}

	//处理本层逻辑
	process();

	//下探到下一层
	recur(level+1, param);

	//清理当前层
}
```
### 分治
** 分治是一种特殊的递归
```python
def divide_conquer(problem, param1, param2){
	if problem is None:
		print_result
		return

	data = prepare(problem)

	subproblems = split_problem(problem, data)

	subresult1 = self.divide_conquer(subproblems[0], param1, param2)
	subresult2 = self.divide_conquer(subproblems[1], param1, param2)

	result = process_result(subresult1, subresult2)
}
```
### 回溯
** 回溯法采用试错的思想，尝试分步去解决一个问题
** 回溯法典型应用在八皇后，数独，全排列问题
** 回溯问题，实际上就是一个决策树的遍历过程
** 回溯的核心就是循环里的递归，在递归调用之前做选择，在递归调用之后撤销选择
```java
void backtrace(路径,选择列表){
	if(满足结束条件){
		加入结果集;
		return ;
	}

	for(选择 in 选择列表){
		做选择;
		backtrace(路径, 选择列表);
		撤销选择;
	}
}
```