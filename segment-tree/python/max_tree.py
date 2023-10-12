
import math
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
    
    def query(self,l,r):
        return self._query(l,r,self.root)
    
    def _query(self,l,r,node):
        if node==None:
            return - math.inf
        
        if node.left_index>=l and node.right_index<=r:
            return node.val
        lmax=self._query(l,r,node.left_child)
        rmax=self._query(l,r,node.right_child)
        return max(lmax,rmax)

    def update(self,index,val):
        self.arr[index]=val
        self._update(index,val,self.root)

    def _update(self,index,val,node):
        if node==None:
            return
        if node.left_index==node.right_index and node.left_index==index:
            node.val=val
            return

        if node.left_index<=index and node.right_index>=index:
            node.val=max(node.val,val)
        
        self._update(index,val,node.left_child)
        self._update(index,val,node.right_child)

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

    print("query max of element between the index 2,5 : ",arr, end=" - ")
    max_val=m_tree.query(2,5)
    print(max_val)

    print("level order traversal of max segment tree of the arr before update at index 3 ,11: ",arr)
    m_tree.level_order_traversal()
    m_tree.update(3,11)
    print("level order traversal of max segment tree of the arr after update at index 3 ,11: ",arr)
    m_tree.level_order_traversal()



       
