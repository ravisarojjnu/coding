
#find Median of two sorted array
class Solution:
    def findMedianSortedArrays(self, nums1 , nums2) -> float:
        n1=len(nums1)
        n2=len(nums2)

        if n1>n2:
            return self.findMedianSortedArrays(nums2,nums1)

        c_mid=(n1+n2+1)//2
        low=0
        high=n1
        while(low<=high):
            mid1=(low+high)//2
            mid2=c_mid-mid1
            l1=float("-inf")
            l2=float("-inf")
            r1=float("+inf")
            r2=float("+inf")

            if (mid1-1>=0 and mid1-1<n1):
                l1=nums1[mid1-1]
            if(mid2-1>=0 and mid2-1<n2):
                l2=nums2[mid2-1]
            if(mid1<n1 and mid1>=0):
                r1=nums1[mid1]
            if(mid2<n2 and mid2>=0):
                r2=nums2[mid2]
            
            if (l1<=r2 and l2<=r1):
                
                if(n1+n2)%2==0:
                    
                    return (max(l1,l2)+min(r1,r2))/2
                else:
                    
                    return max(l1,l2)
            elif(l1>r2):
                
                high=mid1-1
            else:
                low=mid1+1

        
if __name__=="__main__":
    nums1=[1,3,5,7,9]
    nums2=[2,4,6,8]
    sol=Solution()
    ans=sol.findMedianSortedArrays(nums1,nums2)
    print(ans)
