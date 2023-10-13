# What is a Segment Tree?

A **segment tree** is a binary tree structure used to represent a range of values from an array or list. It is built in a way that allows efficient queries and updates on those ranges.

## Structure of a Segment Tree

- **Tree Nodes:** Each node in a segment tree represents a range of values from the original array. The root node represents the entire array, and each child node splits its parent's range into two equal halves.

- **Leaf Nodes:** The leaf nodes of the segment tree represent individual elements of the original array.

- **Range:** A node represents a specific range of values from the original array. For example, the root node represents the entire array, and a child node represents a subset of that array.

- **Operations:** Segment trees are primarily used for two operations: query and update.

## Building a Segment Tree

Building a segment tree is typically done using a recursive approach. Here are the steps:

1. Start with the root node, which represents the entire array.

2. If the current node represents a single element (i.e., it's a leaf node), assign the value of the element to that node.

3. If the current node represents a range of values, calculate the middle index of that range, and recursively build the left and right subtrees for the left and right halves of the range.

4. To compute the value of an internal (non-leaf) node, you can use an appropriate operation, such as sum, minimum, maximum, etc., depending on the problem's requirements. For example, for a sum segment tree, the value of an internal node would be the sum of its children's values.

## Querying with a Segment Tree

Querying in a segment tree is efficient and works as follows:

1. Start at the root node.

2. If the current node's range is entirely contained within the query range, return the value stored at that node.

3. If the current node's range does not overlap with the query range, return a neutral value (e.g., 0 for sum queries, positive infinity for minimum queries).

4. If the current node's range partially overlaps with the query range, recursively search in both the left and right subtrees.

5. Combine the results obtained from the left and right subtrees using the appropriate operation.

## Updating with a Segment Tree

Updating in a segment tree is also efficient and works as follows:

1. Start at the root node.

2. If the current node's range contains the index of the element to be updated, update the node's value accordingly.

3. If the current node's range does not contain the index, no update is needed for this node.

4. Recursively update the left and right subtrees.

5. Update the parent nodes' values as you move back up the tree.

## Example Use Cases

Segment trees have a wide range of applications, including:

- **Range Sum Queries:** You can use a segment tree to quickly find the sum of elements in a given range of an array.

- **Range Minimum/Maximum Queries:** Segment trees are useful for finding the minimum or maximum element in a given range of an array.

- **Range Updates:** You can efficiently update elements in a given range of an array using a segment tree.

Segment trees are a powerful tool for solving a wide range of problems involving range queries and updates. They have applications in competitive programming, database systems, and more. Understanding how to build and use segment trees can be a valuable skill for algorithmic problem-solving.

## Complexity
### Building the Segment Tree:

Building a segment tree from an array of size "n" typically takes O(n) time. The construction process involves recursively dividing the array into segments and computing the aggregate values (e.g., sum, minimum, maximum) for each segment.

### Range Query (e.g., Sum Query):

Querying for the sum of elements in a specific range [L, R] in the array using a segment tree takes O(log n) time, where "n" is the size of the array. This is because you descend the tree by visiting a logarithmic number of nodes (specifically, O(log n) nodes) to compute the result.

### Update Operation (e.g., Updating an Element):

Updating a single element in the array and subsequently updating the segment tree to maintain consistency also takes O(log n) time. This is because you need to traverse the tree from the leaf node corresponding to the element you're updating up to the root, updating the aggregate values along the way.

### Range Update Operation (e.g., Range Add):

Range update operations (updating all elements in a specified range) can be supported efficiently in segment trees as well. Updating a range takes O(log n) time, where "n" is the size of the array, because you descend the tree in a manner similar to range queries.

