
class TreeNode:

    def __init__(self,left_index,right_index):
        self.val=None
        self.left_child=None
        self.right_child=None
        self.left_index=left_index
        self.right_index=right_index


class MaxSegmentTree:
    def __init__(self,arr):
        self.arr=arr
        self.n=len(arr)
        self.root=self._build(0,self.n-1)
    def _build(self,left,right):
        node=TreeNode(left,right)
        if left==right:
            node.val=self.arr[left]
            return node
        mid=(left+right)//2
        node.left_child=self._build(left,mid)
        node.right_child=self._build(mid+1,right)
        node.val=max(node.left_child.val,node.right_child.val)
        return node
    
    def level_order_traversal(self):
        queue=list()
        queue.append(self.root)
        while(len(queue)!=0):
            node=queue.pop(0)
            print(node.val,end=" ")
            if node.left_child!=None:
                queue.append(node.left_child)
            if node.right_child!=None:
                queue.append(node.right_child)
        print()

        

if __name__=="__main__":
    arr=[1,2,3,4,5,6,7]
    m_tree=MaxSegmentTree(arr)
    print("level order traversal of max segment tree of the arr: ",arr)
    m_tree.level_order_traversal()


       
