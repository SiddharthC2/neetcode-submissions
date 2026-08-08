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
    private int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.head = new LinkedList();
        Arrays.sort(nums);
        int n = nums.length, nhalf = n/2, temp;
        for (int i=0; i<nhalf; i++) {
            temp = nums[i];
            nums[i] = nums[n-1-i];
            nums[n-1-i] = temp;
        }
        LinkedList curr = this.head, next;
        for (int num: nums) {
            next = new LinkedList(num);
            curr.next = next;
            curr = next;
        }
    }
    
    public int add(int val) {
        insert(val);
        return getKthNode();
    }

    private void insert(int val) {
        LinkedList curr = this.head, next = curr.next;
        while (next != null && next.val > val) {
            curr = next;
            next = next.next;
        }
        LinkedList newNode = new LinkedList(val);
        curr.next = newNode;
        newNode.next = next;
    }

    private int getKthNode() {
        LinkedList curr = this.head;
        for (int i=0; i<this.k; i++) {
            curr = curr.next;
        }
        return curr.val;
    }

}
