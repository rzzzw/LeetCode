/*
Core idea (the invariant)
Maintain two heaps:
1️⃣ Max-heap (left)
    - Stores the smaller half of the numbers
    - Top = largest of the smaller half

2️⃣ Min-heap (right)
    - Stores the larger half of the numbers
    - Top = smallest of the larger half

Invariants must keep
    1. left.size() == right.size() OR
       left.size() == right.size() + 1
    2. Every element in left ≤ every element in right
*/

class MedianFinder {

    private PriorityQueue<Integer> left; // max heap
    private PriorityQueue<Integer> right; // min heap

    public MedianFinder() {
        left = new PriorityQueue<>(Collections.reverseOrder());
        right = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        left.offer(num);
        right.offer(left.poll());

        if (right.size() > left.size()) {
            left.offer(right.poll());
        }
    }
    
    public double findMedian() {
        if (left.size() > right.size()) {
           return left.peek();
        }
        return (left.peek() + right.peek()) / 2.0;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */