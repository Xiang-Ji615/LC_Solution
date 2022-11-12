class MedianFinder {

    Queue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
    Queue<Integer> minHeap = new PriorityQueue<>();
    boolean isEven = false;
    
    /** initialize your data structure here. */
    public MedianFinder() {
        
    }
    
    public void addNum(int num) {
        if(!isEven){
            maxHeap.offer(num);
            minHeap.offer(maxHeap.poll());
        }else{
            minHeap.offer(num);
            maxHeap.offer(minHeap.poll());
        }
        isEven = !isEven;
    }
    
    public double findMedian() {
        if(isEven)
            return (double)minHeap.peek();
        return (minHeap.peek() + maxHeap.peek())/2.0;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */