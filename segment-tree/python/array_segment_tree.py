class ArraySegmentTree:

    def __init__(self, nums):
        self.nums=nums
        self.n=len(self.nums)
        self.segment_arr=[0]*(4*self.n)
        self._build(0,len(nums)-1,0)

    
    def _build(self,left,right,node_index):
        if left>right:
            return 0
        if left==right:
            self.segment_arr[node_index]=self.nums[left]
            return self.nums[left]
        mid=(left+right)//2
        lval=self._build(left,mid,2*node_index+1)
        rval=self._build(mid+1,right,2*node_index+2)
        s=lval+rval
        self.segment_arr[node_index]=s
        return s

    
    def update(self, index: int, val: int):

        diff=val-self.nums[index]
        self.nums[index]=val
        self._updateRecursive(0,self.n-1,0,index,diff)

    def _updateRecursive(self,l,r,node_index,index,val):
        if(l>r):
            return
        if (l>index or r<index):
            return
        if (l==r==index):
            self.segment_arr[node_index]+=val
            return
        if (l<=index and r>=index):
            self.segment_arr[node_index]+=val
        mid=(l+r)//2
        self._updateRecursive(l,mid,node_index*2+1,index,val)
        self._updateRecursive(mid+1,r,node_index*2+2,index,val)

        

    def sumRange(self, left: int, right: int):
        
        return self._sumRangeRecursive(left,right,0,self.n-1,0)

    def _sumRangeRecursive(self,left,right,l,r,node_index):
        if l>r:
            return 0
        if(l>right or r<left):
            return 0 
        if (left<=l and right>=r):
            return self.segment_arr[node_index]
        
        mid=(l+r)//2
        lval=self._sumRangeRecursive(left,right,l,mid,node_index*2+1)
        rval=self._sumRangeRecursive(left,right,mid+1,r,node_index*2+2)
        return lval+rval



if __name__=="__main__":
    arr=[-28,-39,53,65,11,-56,-65,-39,-43,97]
    tree=ArraySegmentTree(arr)
    print(tree.segment_arr)
    ops=["sumRange","update","sumRange","sumRange","update","update","sumRange","sumRange","update","update"]
    opds=[[5,6],[9,27],[2,3],[6,7],[1,-82],[3,-72],[3,7],[1,8],[5,13],[4,-67]]
    for i,op in enumerate(ops):
        if op=="update":
            a=tree.update(*opds[i])
        else:
            a=tree.sumRange(*opds[i])
        print(a,tree.segment_arr,*opds[i])