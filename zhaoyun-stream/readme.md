
## 中间操作
+ distinct
> 保证输出的流中包含唯一的元素，它是通过Object.equals(Object)来检查是否包含相同的元素；
+ filter
> 返回的流中只包含满足断言(predicate)的数据；
+ map
> 将流中的元素映射成另外的值，新的值类型可以和原来的元素的类型不同;
+ limit
> 指定数量的元素的流。
+ sorted
> 将流中的元素按照自然排序方式进行排序；
+ skip
> 返回丢弃了前n个元素的流，如果流中的元素小于或者等于n，则返回空的流；

## 终点操作
+ forEach、forEachOrdered
> 遍历流的每一个元素，执行指定的 action；
+ match
> 根据指定条件，判断是否能够进行匹配
+ find
> 在流中查找元素，返回Optional
+ max、min、count
> 在流中进行计算，特殊类型的reduce
+ reduce
> 根据指定算法进行计算
+ collect
> 收集流中的元素到list，set,map中