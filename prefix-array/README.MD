# Prefix-array based Algorithms

Prefix array based algorithms, also known as prefix-sum algorithms. 

Prefix algorithms are class of algorithms used to compute cumulative sums or prefix sums of an array or sequence of values.

The main idea behind prefix-array based algorithms is to precompute and store the comulative sums of elements in the array in another data structure. this precomputation allows for fast query and update operation.
## Some common applications of prefix-array based.

### 1. Prefix sum queries
- Given an array of numbers, compute the sum of elements in prefix. that is the sum of elements from index 0 to given index efficiently.

### 2. Range sum queries
- Given an array of numbers, compute the sum of elements in a range

### 3. Dynamic Programming
- Used in dynamic programming problems where you need to compute and update values that depend on cumulative sums.


## Algorithm
### prefix-sum array
- In this approach, you create an additional array where each element stores the sum of all elements in the original array up to the current index. this allows for efficient prifix sum queries.
