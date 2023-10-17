class Solution:
    def firstMissingPositive(self, nums) -> int:
        n=len(nums)
        for i,val in enumerate(nums):
            if val>n or val<=0:
                nums[i]=n+1

        for i,val in enumerate(nums):
            val=abs(val)-1
            if (val<n and nums[val]>0 ):
                nums[val]=-1*nums[val]

        for i,val in enumerate(nums):
            if(val>=0):
                return i+1
        return n+1
    

if __name__=="__main__":
    ls=[1,4,5,6,3,2,4]
    s=Solution()
    print(s.firstMissingPositive(ls))