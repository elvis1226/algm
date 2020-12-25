package org.dgf.sort;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by apple on 2018/5/20.
 */
public class Heap<E extends Comparable<E>> {
    public static Logger log = LoggerFactory.getLogger(Heap.class);
    private int heapSize;
    public E[] elems;

    public Heap(E[] elems, int heapSize) {
        this.elems = elems;
        this.heapSize = heapSize;
    }

    private  int left(int i) {
        return 2*i;
    };

    private int right(int i) {
        return 2*i + 1;
    }

    private int parent(int i) {
        if (i == 0) return -1;
        return (int) Math.floor(i/2);
    }

    public void maxHeap(int head) {
        int h = head;

        boolean bContinue = true;
        while ((left(h) <= heapSize || right(h) <= heapSize) && bContinue) {
            int left = left(h);
            int right = right(h);
            bContinue = false;
            int max = h;
            if (left <= heapSize && elems[left].compareTo(elems[max]) > 0)  {
                max = left;
            }
            if (right <= heapSize && elems[right].compareTo(elems[max]) > 0) {
                max = right;
            }
            if (max != h) {
                bContinue = true;
                E temp = elems[h];
                elems[h] = elems[max];
                elems[max] = temp;
                h = max;
            }
        }
    }

    public void buildMaxHeap() {
        log.info("max heap {}", heapSize/2);
        for (int i = heapSize/2; i >= 1; i--) {
            maxHeap(i);
        }
    }

    public E extractMax() {
        if(heapSize <= 0) return null;
        E h = elems[1];
        elems[1] = elems[heapSize];
        heapSize--;
        maxHeap(1);
        return h;
    }

    public void heapSort() {
        buildMaxHeap();
        int old = heapSize;
        for (int i = heapSize; i > 1; i--) {
            E temp = elems[1];
            elems[1] = elems[i];
            elems[i] = temp;
            heapSize--;
            maxHeap(1);
        }
        heapSize = old;
    }

    public static void main(String[] argv) {
        Integer[] elems = new Integer[] {0,2,3,1,5,4};
        Heap<Integer> heap = new Heap(elems, elems.length-1);
        /*heap.buildMaxHeap();
        for (int i = 1; i < elems.length;i++) {
            int e = heap.extractMax();
            log.info("{}", e);
        }*/
        heap.heapSort();
        for (int i = 1; i < elems.length;i++) {
            //int e = heap.extractMax();
            log.info("{}", heap.elems[i]);
        }
    }
}
