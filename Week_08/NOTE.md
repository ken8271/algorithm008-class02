学习笔记
### 布隆过滤器
     > 概念：很长的二进制向量和一系列的随机映射函数，不存储数据信息
     > 优点：空间效率和时间效率远超过一般算法
     > 缺点：一定的误判率和无法删除

### LRU Cache
    > 两个要素：大小，替换策略
    > 一般实现：HashTable + 双向链表
    > 基本操作：
      * get：从HashTable中获取元素，存在时将元素移到最前
      * put：存在则更新值，并移动到最前；不存在，则加入HashTable，并放到链表最前，若长度超过容量则将末尾元素移除

### 排序算法
    > 比较类排序：通过比较来决定元素间的次序，由于其时间复杂度不能突破O(nlogn)，因此称为非时间线性比较类排序
    > 非比较类排序：不通过比较来决定元素间的相对次序，可以突破比较类排序的时间复杂度，以线性时间运行，因此也称为线性时间非比较类排序

### 比较类排序
    > 交换排序：冒泡排序，快速排序
    > 插入排序：简单插入排序，希尔排序
    > 选择排序：简单选择排序，堆排序
    > 归并排序：二路归并排序，多路归并排序

### 非比较类排序
    > 非比较类排序：计数排序，桶排序，基数排序

### 初级排序（O(n^2)）
    > 选择排序：每次找最小值，然后放到待排序数组的起始位置
    > 插入排序：从前往后逐步构建有序序列；对于未排序数据，在已排序中从后向前扫描，找到相应位置插入
    > 冒泡排序：嵌套循环，每次查看相邻的元素，如果逆序，则交换

### 高级排序（O(nlogn)）
    > 快速排序：数据选取标杆，将小元素放在标杆左边，将大元素放在标杆右边，然后依次对左右进行快速排序
    > 归并排序：分治思想，将数组拆分成两个子序列，分别采用归并排序，将排序好的子序列合并成最终序列
    > 堆排序：数组元素依次建立小顶堆，然后依次取出堆顶元素，并删除
    > 对比：归并和快排具有相似性，但步骤相反。归并先排序左右子序列，然后合并；快排先调配左右数组，然后分别排序