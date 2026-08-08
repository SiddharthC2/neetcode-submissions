class KthLargest {
    
    private static class LinkedList {
        int val;
        LinkedList next;
        LinkedList() {}
        LinkedList(int val) {
            this.val = val;
        }
    }

    private LinkedList head;
    private LinkedList kNode;
    private int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.head = new LinkedList();
        Arrays.sort(nums);
        LinkedList curr = this.head, next;
        int n = nums.length;
        for (int i=n-1; i>=0; i--) {
            next = new LinkedList(nums[i]);
            curr.next = next;
            curr = next;
            if (n-1-i == k-1) {
                kNode = next;
            }
        }
    }
    
    public int add(int val) {
        insert(val);
        return kNode.val;
    }

    private void insert(int val) {
        if (kNode == null || kNode.val <= val) {
            LinkedList curr = this.head, next = curr.next;
            while (next != null && next.val > val) {
                curr = next;
                next = next.next;
            }
            LinkedList newNode = new LinkedList(val);
            curr.next = newNode;
            newNode.next = next;

            curr = this.head;
            for (int i=0; i<k; i++) {
                curr = curr.next;
            }
            kNode = curr;
        }
    }

}
