import java.io.*;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Heap heap = new Heap(n);
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            int value = Integer.parseInt(br.readLine());
            if (value == 0) {
                sb.append(heap.poll()).append("\n");
            }else {
                heap.offer(value);
            }
        }
        System.out.println(sb);
    }

    static class Heap {
        private int size;
        private int[] heap;

        public Heap(int size) {
            this.size = 0;
            heap = new int[size];
        }

        public void offer(int element) {
            if (size == heap.length) {
                return;
            }
            heap[size] = element;
            heapifyUp(size);
            size++;
        }

        public int poll() {
            if (size == 0) {
                return 0;
            }
            int root = heap[0];
            heap[0] = heap[size - 1];
            heap[size - 1] = 0;
            size--;
            heapifyDown(0);
            return root;
        }

        public boolean compare(int o1, int o2) {
            if (Math.abs(o1) == Math.abs(o2)) {
                return o1 > o2;
            } else {
                return Math.abs(o1) > Math.abs(o2);
            }
        }

        private void heapifyUp(int index) {
            while (hasParent(index) && compare(getParent(index), heap[index])) {
                swap(getParentIndex(index), index);
                index = getParentIndex(index);
            }
        }

        private void heapifyDown(int index) {
            while (hasLeftChild(index)) {
                int smallerChildIndex = 2 * index + 1;
                if (hasRightChild(index)) {
                    if (compare(heap[getLeftChildIndex(index)], heap[getRightChildIndex(index)])) {
                        smallerChildIndex = getRightChildIndex(index);
                    }
                }
                if (compare(heap[smallerChildIndex], heap[index])) {
                    break;
                }
                swap(index, smallerChildIndex);
                index = smallerChildIndex;
            }
        }

        private void swap(int idx1, Integer idx2) {
            int temp = heap[idx1];
            heap[idx1] = heap[idx2];
            heap[idx2] = temp;
        }

        private boolean hasParent(int index) {
            return getParentIndex(index - 1) >= 0;
        }

        private int getParentIndex(int index) {
            return (index - 1) / 2;
        }

        private Integer getParent(int index) {
            return heap[getParentIndex(index)];
        }

        private int getRightChildIndex(int index) {
            return 2 * index + 2;
        }

        private int getLeftChildIndex(int index) {
            return 2 * index + 1;
        }

        private boolean hasRightChild(int index) {
            return 2 * index + 2 < size;
        }

        private boolean hasLeftChild(int index) {
            return (2 * index + 1) < size;
        }
    }
}
