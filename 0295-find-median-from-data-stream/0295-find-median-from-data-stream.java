class MedianFinder {
    private PriorityQueue<Integer> maxHeap;
    private PriorityQueue<Integer> minHeap;
    public MedianFinder() {
        maxHeap = new PriorityQueue<>(Collections.reverseOrder()); // smaller half
        minHeap = new PriorityQueue<>(); // larger half
    }

    public void addNum(int num) {
        //120 60 80 50 100
        //min 120 80 
        //max 100 60 50
        minHeap.offer(num); 
        maxHeap.offer(minHeap.poll());
        if (maxHeap.size() > minHeap.size() + 1) {
            minHeap.offer(maxHeap.poll());
        }

    }

    public double findMedian() {
        if (minHeap.size() == maxHeap.size()) {
            return (minHeap.peek() + maxHeap.peek()) / 2.0;
        } else {
            return maxHeap.peek();
        }
    }
} 


/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */



//  class MedianFinder {
//     private PriorityQueue<Integer> maxHeap; // lower half
//     private PriorityQueue<Integer> minHeap; // higher half
//     public MedianFinder() {
//         maxHeap = new PriorityQueue<>(Collections.reverseOrder());
//         minHeap = new PriorityQueue<>();
//     }

//     public void addNum(int num) {
//         maxHeap.offer(num);
//         minHeap.offer(maxHeap.poll());
//         if (minHeap.size() > maxHeap.size()) {
//             maxHeap.offer(minHeap.poll());
//         }

//     }

//     public double findMedian() {
//         if (maxHeap.size() == minHeap.size()) {
//             return (maxHeap.peek() + minHeap.peek()) / 2.0;
//         } else {
//             return maxHeap.peek();
//         }
//     } 

//  }
