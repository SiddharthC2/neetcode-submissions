class Solution {

    private double findMedianSortedArr(int[] nums1, int[] nums2) {
        int n1=nums1.length, n2=nums2.length, n=n1+n2, m=n/2;
        if (n1==0 && n2==0) {
            return 0d;
        }
        int left=0, right=n1-1, m1=0, m2=0;
        int count=0;
        while (left <= right) {
            m1=left+(right-left)/2;
            m2=m-m1-1;

            // System.out.println(left+" "+right+" "+m1+" "+m2);
            // count++;
            // if (count == 10) break;

            if(m2<n2-1 && nums1[m1]>nums2[m2+1]) {
                right=m1-1;
            } else if (m1<n1-1 && nums2[m2]>nums1[m1+1]) {
                left=m1+1;
            } else {
                break;
            }
        }
        // System.out.println(m1+" "+m2+" "+left+" "+right);
        double s1=0d, s2=0d;
        if (right == -1) {
            m2=n2/2;
            if (n%2!=0) {
                return (double) nums2[m2];
            } else {
                return ((double) (nums2[m2]+nums2[m2-1]))/2;
            }
        } else if (left == n1) {
            if (n%2!=0) {
                return (double) nums1[m1];
            } else {
                return ((double) (nums1[m1]+nums1[m1-1]))/2;
            }
        } else {
            if (n%2!=0) {
                return (double) Math.max(nums1[m1], nums2[m2]);
            } else {
                if (nums1[m1] >= nums2[m2]) {
                    s1 = (double) nums1[m1];
                    if (m1>0) {
                        s2 = (double) Math.max(nums1[m1-1], nums2[m2]);
                    } else {
                        s2 = (double) nums2[m2];
                    }
                } else {
                    s1 = (double) nums2[m2];
                    if (m2>0) {
                        s2 = (double) Math.max(nums2[m2-1], nums1[m1]);
                    } else {
                        s2 = (double) nums1[m1];
                    }
                }
                return ((double) (s1+s2))/2;
            }
        }
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length <= nums2.length) return findMedianSortedArr(nums1, nums2);
        else return findMedianSortedArr(nums2, nums1);        
    }
}
