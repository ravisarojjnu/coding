# Segment Tree Node
class SegmentTreeNode:
    def __init__(self, left_index, right_index):
        self.val = None
        self.left_index = left_index
        self.right_index = right_index
        self.left_child = None
        self.right_child = None

# Segment Tree Defination


class SegmentTree:
    def __init__(self, arr):
        self.n = len(arr)
        self.tree = self._build(arr, 0, self.n-1)

    def _build(self, arr, left_index, right_index):
        # if left_index > right_index:
        #     return

        node = SegmentTreeNode(left_index, right_index)
        if left_index == right_index:
            node.val = arr[left_index]
        else:
            mid = (left_index+right_index)//2
            node.left_child = self._build(arr, left_index, mid)
            node.right_child = self._build(arr, mid+1, right_index)
            node.val = node.left_child.val+node.right_child.val
        return node
    
    def update(self,index,val):
        self._update(0,self.n-1,index,val,self.tree)

    def _update(self,left,right,index,val,node):
        if left>right:
            return 
        if node==None:
            return

        if node.left_index==node.right_index and node.left_index==index:
            node.val=val
            return
        if node.left_index<=index and node.right_index>=index:

            node.val+=val
        mid=(left+right)//2
        self._update(left,mid,index,val,node.left_child)
        self._update(mid+1,right,index,val,node.right_child)
            

    def query(self, l, r):
        return self._query(l, r, self.tree)

    def _query(self, l, r, node):
        if node == None:
            return 0
        if node.left_index >= l and node.right_index <= r:
            return node.val
        lval = self._query(l, r, node.left_child)
        rval = self._query(l, r, node.right_child)
        return lval+rval

    def inorder_traversal(self):
        if self.tree == None:
            return
        self._inorder_traversal(self.tree)

    def _inorder_traversal(self, node):
        if node == None:
            return

        self._inorder_traversal(node.left_child)
        print(node.val, " ", end="")
        self._inorder_traversal(node.right_child)

    def level_order_traversal(self):
        queue = []
        queue.append(self.tree)
        while len(queue) != 0:
            node = queue.pop(0)
            print(node.val, " ", end="")
            if node.left_child:
                queue.append(node.left_child)
            if node.right_child:
                queue.append(node.right_child)
        print()


if __name__ == "__main__":
    # Create an array 'arr' with values [1, 2, 3, 4, 5, 6]
    arr = [1,2,3]

    # Create a Segment Tree 's_tree' using the 'arr' as input
    s_tree = SegmentTree(arr)
    print("Sum Segment Tree created with input array:", arr)

    # Perform an inorder traversal of the Segment Tree
    s_tree.inorder_traversal()
    print("Inorder Traversal of the Segment Tree:")

    # Perform a level order traversal of the Segment Tree
    print("Level Order Traversal of the Segment Tree:")
    s_tree.level_order_traversal()
    

    # Print the value stored at the root of the Segment Tree
    print("Value at the root of the Segment Tree:", s_tree.tree.val)

    # Query the Segment Tree to find the sum of elements in the range [0, 3]
    val = s_tree.query(0, 3)
    print("Query [0, 3] Result:", val)

    # Query the Segment Tree to find the sum of elements in the range [2, 5]
    val = s_tree.query(2, 5)
    print("Query [2, 5] Result:", val)

    # Query the Segment Tree to find the sum of elements in the range [5, 6]
    val = s_tree.query(5, 6)
    print("Query [5, 6] Result:", val)

    # update the array at index 5 with value 10
    print("before updating the arr at index 5 with value 10 Tree: ")
    s_tree.level_order_traversal()
    s_tree.update(5, 10)
    print("after updating the arr at index 5 with value 10 Tree: ")
    s_tree.level_order_traversal()

    # update the array at index 2 with value 10
    print("before updating the arr at index 2 with value 10 Tree: ")
    s_tree.level_order_traversal()
    s_tree.update(2, 10)
    print("after updating the arr at index 2 with value 10 Tree: ")
    s_tree.level_order_traversal()
   
