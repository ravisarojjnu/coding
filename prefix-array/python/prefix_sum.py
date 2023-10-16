
class PrefixSumArray():
    def __init__(self,arr):
        self.prefix_arr=[]
        self.arr=arr
        self._build()

    def _build(self):
        s=0
        for ele in self.arr:
            s+=ele
            self.prefix_arr.append(s)
    
    def query(self,left,right):
        if left>right  or  right>=len(self.arr) or left<0:
            return
        if (left==0):
            return self.prefix_arr[right]
        
        s=self.prefix_arr[right]-self.prefix_arr[left-1]
        return s


if __name__=="__main__":
    arr=[7,2,7,2,0]
    prarr=PrefixSumArray(arr)
    # val=prarr.query(3,5)
    
        