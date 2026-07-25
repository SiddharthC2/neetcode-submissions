class Solution {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) return findMedianSortedArrays(nums2, nums1);
        int n1=nums1.length, n2=nums2.length, n=n1+n2, nhalf=n/2;
        if (n1==0) {
            if (n%2!=0) return nums2[n2/2];
            else return ((double) nums2[n2/2-1]+nums2[n2/2])/2;
        }
        int left=0, right=n1, m1, m2, l1, l2, r1, r2;
        while (left<=right) {
            m1=left+(right-left)/2;
            m2=nhalf-m1;
            // System.out.println(left+" "+right+" "+m1+" "+m2);
            l1=Integer.MIN_VALUE;
            l2=Integer.MIN_VALUE;
            r1=Integer.MAX_VALUE;
            r2=Integer.MAX_VALUE;
            if (m1!=0) l1=nums1[m1-1];
            if (m1<n1) r1=nums1[m1];
            if (m2!=0) l2=nums2[m2-1];
            if (m2<n2) r2=nums2[m2];
            // System.out.println(l1+" "+l2+" "+r1+" "+r2);
            // System.out.println();
            if (l1<=r2 && l2<=r1) {
                if (n%2!=0) return Math.min(r1,r2);
                else return ((double) Math.max(l1,l2)+Math.min(r1,r2))/2;
            } else if (l1>r2) {
                right=m1-1;
            } else {
                left=m1+1;
            }
        }
        return 0d;
    }
}
